package platform.container;

import java.io.File;
import java.lang.Iterable;
import java.lang.module.Configuration;
import java.lang.module.ModuleFinder;
import java.lang.module.ModuleReference;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import platform.api.ContainerApplication;

public class Launcher {

  private static AppDescriptor[] apps;
  private static ContainerApplication[] deployedApps;

  public static void main(String... args) {
    System.out.println("Starting container");
    ModuleLayer.boot().modules().forEach(m -> System.out.println(m.getName() + ", loader: " + m.getClassLoader()));
    deployedApps = new ContainerApplication[args.length];
    apps = new AppDescriptor[args.length];
    for (int i = 0; i < args.length; i++)
      apps[i] = new AppDescriptor(args[i]);


    System.out.println("Apps available for deployment: ");
    for (int i = 0; i < apps.length; i++) {
      System.out.println(i + ": " + apps[i]);
    }
    System.out.println("Usage: deploy/undeploy <n>");
    System.out.println("Stop container with exit.");

    Scanner scanner = new Scanner(System.in);
    String next;
    do {
      next = scanner.nextLine();
      if ("exit".equals(next))
        System.exit(0);

      if (next.startsWith("deploy")) {
        deployApp(getAppNumber(next));
      }

      if (next.startsWith("undeploy")) {
        undeployApp(getAppNumber(next));
      }

    } while(true);

  }

  private static int getAppNumber(String command) {
    return Integer.parseInt(command.split("\\s")[1]);
  }

  private static void undeployApp(int appNo) {
    ContainerApplication toBeStopped = deployedApps[appNo];
    if (toBeStopped != null) {
      toBeStopped.stopApp();
      deployedApps[appNo] = null;
      System.out.println(appNo + " stopped and undeployed");
    } else {
      System.out.println(appNo + " cannot be undeployed because it is not deployed");
    }
  }

  private static void deployApp(int appNo) {
    AppDescriptor appDescr = apps[appNo];
    System.out.println("Deploying " + appDescr);

    ModuleLayer.Controller appLayerCtrl = createAppLayer(appDescr);
    Module appModule = appLayerCtrl.layer()
      .findModule(appDescr.rootmodule)
      .orElseThrow(() -> new IllegalStateException(appDescr.rootmodule + " missing"));

    appLayerCtrl.addOpens(appModule, appDescr.appClassPkg,
      Launcher.class.getModule());

    ContainerApplication app = instantiateApp(appModule, appDescr.appClass);
    deployedApps[appNo] = app;
    app.startApp();
  }

  private static ModuleLayer.Controller createAppLayer(AppDescriptor appDescr) {
    ModuleFinder finder = ModuleFinder.of(Paths.get(appDescr.appDir));
    ModuleLayer parent = ModuleLayer.boot();

    Configuration cf = parent.configuration()
       .resolve(finder, ModuleFinder.of(), Set.of(appDescr.rootmodule));

    ClassLoader scl = ClassLoader.getSystemClassLoader();
    ModuleLayer.Controller layerCtrl =
      ModuleLayer.defineModulesWithOneLoader(cf, List.of(parent), scl);

    return layerCtrl;
  }

  @SuppressWarnings("unchecked")
  private static ContainerApplication instantiateApp(Module appModule, String appClassName) {
    try {
      ClassLoader cl = appModule.getClassLoader();
      Class<?> appClass = cl.loadClass(appClassName);

      if(ContainerApplication.class.isAssignableFrom(appClass)) {
        return ((Class<ContainerApplication>) appClass).getConstructor().newInstance();
      } else {
        System.out.println("WARNING: " + appClassName + " doesn't implement ContainerApplication, cannot be started");
      }
    } catch (ReflectiveOperationException roe) {
      System.out.println("Could not start " + appClassName);
      roe.printStackTrace();
    }

    return null;

  }

}
