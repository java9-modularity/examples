module plugin.b {
  requires pluginhost.api;
  requires somelibrary;

  provides pluginhost.api.Plugin
      with pluginb.PluginB;
}
