package plugina;

import pluginhost.api.Plugin;

public class PluginA implements Plugin {

  public String getName() {
    return "Plugin A";
  }

  public void doWork() {
    System.out.println("Doing whatever plugins do!");
  }

}
