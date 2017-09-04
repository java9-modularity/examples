package javamodularity.easytext.algorithm.naivesyllablecounter;

import javamodularity.easytext.algorithm.api.SyllableCounter;

public class NaiveSyllableCounter implements SyllableCounter {
   
   @Override
   public int countSyllables(String word) {
      int syllables = 0;
      boolean prevNonVowel = false;
      for(int i = 0; i < word.length(); i++) {
         boolean isVowel = isVowel(word.toLowerCase().charAt(i));
         if(prevNonVowel && isVowel && i != word.length() - 1) {
            syllables++;
         }
         prevNonVowel = !isVowel;   
      }
      syllables = syllables == 0 ? 1 : syllables;
      return syllables;
   }

   private boolean isVowel(char letter) {
      return letter == 'a' || letter == 'e' || letter == 'i' || letter == 'o' || letter == 'u';
   }
}