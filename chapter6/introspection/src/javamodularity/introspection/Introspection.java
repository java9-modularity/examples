package javamodularity.introspection;

import java.util.*;
import java.lang.module.*;
import java.lang.module.ModuleDescriptor.Exports;

public class Introspection {

  public static void main(String... args) {
    Module module = String.class.getModule();

    String name1 = module.getName(); // Name as defined in module-info.java
    String[] packages1 = module.getPackages(); // Lists all packages in the module

    // The methods above are convenience methods that return
    // information from the Module's ModuleDescriptor:
    ModuleDescriptor descriptor = module.getDescriptor();
    String name2 = descriptor.name(); // Same as module.getName();
    Set<String> packages2 = descriptor.packages(); // Same as module.getPackages();

    // Through ModuleDescriptor, all information from module-info.java is exposed:
    Set<Exports> exports = descriptor.exports(); // All exports, possibly qualified
    Set<String> uses = descriptor.uses(); // All services used by this module
  }

}
