package javamodularity.easytext.algorithm.nextgensyllablecounter;

import javamodularity.easytext.algorithm.api.SyllableCounter;

public class SyllableCounter3Wrapper implements SyllableCounter {

   eu.crydee.syllablecounter.SyllableCounter counter = new 
      eu.crydee.syllablecounter.SyllableCounter(1000);

   @Override
   public int countSyllables(String word) {
      return counter.count(word);
   }
   
}