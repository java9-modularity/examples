rm -rf out

# Copy resources
cd src
rsync -Rq $(find . -name *.txt) ../out
cd -

# Compile modules
javac -Xlint:unchecked      \
      --module-source-path src \
      -d out $(find src -name '*.java') \
&& \
java -p out -ea \
     --add-modules secondresourcemodule \
     -m firstresourcemodule/javamodularity.firstresourcemodule.ResourcesInModule \
&& \
     java -p out -ea \
          --add-modules secondresourcemodule \
          -m firstresourcemodule/javamodularity.firstresourcemodule.ResourcesOtherModule
