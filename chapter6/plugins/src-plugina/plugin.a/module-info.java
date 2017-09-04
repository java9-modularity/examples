module plugin.a {
  requires pluginhost.api;

  provides pluginhost.api.Plugin
      with plugina.PluginA;
}
