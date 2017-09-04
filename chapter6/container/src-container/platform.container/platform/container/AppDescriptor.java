package platform.container;

import java.io.File;

public class AppDescriptor {
  public final String appDir;
  public final String rootmodule;
  public final String appClass;
  public final String appClassPkg;

  public AppDescriptor(String unparsed) {
    int firstSlash = unparsed.indexOf(File.separator);
    int lastSlash = unparsed.lastIndexOf(File.separator);
    rootmodule = unparsed.substring(firstSlash + 1, lastSlash);
    appDir = unparsed.substring(0, lastSlash);
    appClass = unparsed.substring(lastSlash + 1);
    appClassPkg = appClass.substring(0, appClass.lastIndexOf('.'));
  }

  @Override
  public String toString() {
    return String.format("{ rootmodule: %s, appClass: %s, appDir: %s}",
      rootmodule, appClass, appDir);
  }

}
