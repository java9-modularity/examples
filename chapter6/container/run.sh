rm -rf out-app/ out-container/

# Compile container and platform API first
javac -Xlint:deprecation -Xlint:unchecked --module-source-path src-container -d out-container -m platform.api,platform.container

# Compile app a with platform API in separate output directory
javac -Xlint:deprecation --module-path out-container/platform.api --module-source-path src-appa -d out-appa -m app.a

# Compile app b with platform API in separate output directory
javac -Xlint:deprecation --module-path out-container/platform.api --module-source-path src-appb -d out-appb -m app.b

# Run the container app, without putting the compiled modules of the app on the module path.
# These are loaded by the container as applications!
java --module-path out-container --add-modules ALL-SYSTEM -m platform.container/platform.container.Launcher out-appa/app.a/app.a.AppA out-appb/app.b/app.b.AppB
