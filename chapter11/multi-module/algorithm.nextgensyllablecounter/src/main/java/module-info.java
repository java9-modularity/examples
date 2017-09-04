module easytext.algorithm.nextgensyllablecounter {
  requires easytext.algorithm.api;
  requires syllable.counter; // Automatic module: name derived from library jar name

  provides javamodularity.easytext.algorithm.api.SyllableCounter
      with javamodularity.easytext.algorithm.nextgensyllablecounter.SyllableCounter3Wrapper;

}
