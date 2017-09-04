rm -rf out
mkdir out

# Copy resources
cd src
rsync -Rq $(find . -name *.properties) ../out
cd -

# Compile modules
javac -Xlint:unchecked      \
      --module-source-path src \
      -d out $(find src -name '*.java') \
&& \
java -p out \
     --add-modules resourcebundle.main \
     --add-modules resourcebundle.dutch \
     -m resourcebundle.main/javamodularity.resourcebundle.Loader $1 # en-GB or nl-NL
