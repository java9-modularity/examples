package pluginhost;

import java.lang.Iterable;
import java.lang.module.Configuration;
import java.lang.module.ModuleFinder;
import java.lang.module.ModuleReference;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.ServiceLoader;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

import pluginhost.api.Plugin;

public class PluginHostMain {

  public static void main(String... args) {
    if (args.length < 1) {
      System.out.println("Please provide plugin directories");
      return;
    }

    System.out.println("Loading plugins from " + Arrays.toString(args));

    Stream<ModuleLayer> pluginLayers = Stream
      .of(args)
      .map(dir -> createPluginLayer(dir)); //<1>

    pluginLayers
      .flatMap(layer -> toStream(ServiceLoader.load(layer, Plugin.class))) // <2>
      .forEach(plugin -> {
         System.out.println("Invoking " + plugin.getName());
         plugin.doWork(); // <3>
      });
  }

  static ModuleLayer createPluginLayer(String dir) {
    ModuleFinder finder = ModuleFinder.of(Paths.get(dir));

    Set<ModuleReference> pluginModuleRefs = finder.findAll();
    Set<String> pluginRoots = pluginModuleRefs.stream()
             .map(ref -> ref.descriptor().name())
             .filter(name -> name.startsWith("plugin")) // <1>
             .collect(Collectors.toSet());

    ModuleLayer parent = ModuleLayer.boot();
    Configuration cf = parent.configuration()
      .resolve(finder, ModuleFinder.of(), pluginRoots); // <2>

    ClassLoader scl = ClassLoader.getSystemClassLoader();
    ModuleLayer layer = parent.defineModulesWithOneLoader(cf, scl); // <3>

    return layer;
  }

  static <T> Stream<T> toStream(Iterable<T> iterable) {
    return StreamSupport.stream(iterable.spliterator(), false);
  }

}
