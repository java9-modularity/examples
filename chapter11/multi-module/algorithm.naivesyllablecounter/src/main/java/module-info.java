module easytext.algorithm.naivesyllablecounter {
  requires easytext.algorithm.api;

  provides javamodularity.easytext.algorithm.api.SyllableCounter
      with javamodularity.easytext.algorithm.naivesyllablecounter.NaiveSyllableCounter;
}
