package javamodularity.easytext.test;

import javamodularity.easytext.syllablecounter.SimpleSyllableCounter;

public class TestSyllableCounter {

  public static void main(String... args) {
    SimpleSyllableCounter sc = new SimpleSyllableCounter();

    assert sc.countSyllables("Bike") == 1;
    assert sc.countSyllables("Motor") == 2;
    assert sc.countSyllables("Bicycle") == 3;
    
  }

}
