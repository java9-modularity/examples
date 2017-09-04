package javamodularity.easytext.syllablecounter.vowel;

import java.util.Set;

public class VowelHelper {

  public static boolean isVowel(char letter) {
     return getVowels().contains(letter);
  }

  static Set<Character> getVowels() {
    return Set.of('a', 'e', 'i', 'o', 'u');
  }

}
