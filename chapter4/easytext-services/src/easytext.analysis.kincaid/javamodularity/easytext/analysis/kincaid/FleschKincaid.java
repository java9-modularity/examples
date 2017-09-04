package javamodularity.easytext.analysis.kincaid;

import javamodularity.easytext.analysis.api.Analyzer;

import java.util.ArrayList;
import java.util.List;

public class FleschKincaid  implements Analyzer {

   public static final String NAME = "Flesch-Kincaid";

   @Override
   public String getName() {
     return NAME;
   }

   @Override
   public double analyze(List<List<String>> sentences) {
      float totalsentences = sentences.size();
      float totalwords = sentences.stream().mapToInt(sentence -> sentence.size()).sum();
      float totalsyllables = sentences.stream()
         .flatMapToInt(sentence ->
            sentence.stream().mapToInt(word -> countSyllables(word)))
         .sum();
      return 206.835 - 1.015 * (totalwords / totalsentences) - 84.6 * (totalsyllables / totalwords);
   }

   private int countSyllables(String word) {
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
