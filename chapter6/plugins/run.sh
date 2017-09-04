rm -rf out-pluginhost/ out-plugins/

# Compile main application + plugin API first
javac --module-source-path src-pluginhost -d out-pluginhost $(find src-pluginhost -name '*.java')
# Compile plugin a to api of the main application
javac --module-path out-pluginhost/pluginhost.api --module-source-path src-plugina -d out-plugina $(find src-plugina -name '*.java')
# Compile plugin b to api of the main application
javac --module-path out-pluginhost/pluginhost.api --module-source-path src-pluginb -d out-pluginb $(find src-pluginb -name '*.java')

# Run the main app, without putting the compiled modules on the module path.
# These are loaded by the application as plugins!
java --module-path out-pluginhost --add-modules ALL-SYSTEM -m pluginhost/pluginhost.PluginHostMain out-plugina out-pluginb
