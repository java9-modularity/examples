package javamodularity.easytext.syllablecounter;

import javamodularity.easytext.syllablecounter.vowel.VowelHelper;

public class SimpleSyllableCounter {

   public int countSyllables(String word) {
      int syllables = 0;
      boolean prevNonVowel = false;
      for(int i = 0; i < word.length(); i++) {
         boolean isVowel = VowelHelper.isVowel(word.toLowerCase().charAt(i));
         if(prevNonVowel && isVowel && i != word.length() - 1) {
            syllables++;
         }
         prevNonVowel = !isVowel;
      }
      syllables = syllables == 0 ? 1 : syllables;
      return syllables;
   }

}
