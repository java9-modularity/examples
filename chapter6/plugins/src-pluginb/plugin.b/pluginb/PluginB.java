package pluginb;

import pluginhost.api.Plugin;

import some.library.Helper;

public class PluginB implements Plugin {

  public String getName() {
    return "Plugin B";
  }

  public void doWork() {
    System.out.println("Doing whatever second plugins do: " + Helper.help());
  }

}
