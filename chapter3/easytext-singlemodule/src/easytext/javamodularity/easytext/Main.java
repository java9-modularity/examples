package javamodularity.easytext;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Main {

   public static void main(String... args) throws IOException {
      if (args.length == 0) {
         System.out.println("Welcome to EasyText. Please provide a filename as input argument");
         return;
      }

      Path path = Paths.get(args[0]);
      System.out.println("Reading " + path);
      String text = new String(Files.readAllBytes(path), Charset.forName("UTF-8"));

      List<List<String>> sentences = toSentences(text);
      
      System.out.println("Flesch-Kincaid: " + analyze(sentences));
      
   }


   public static List<List<String>> toSentences(String text) {
      String removedBreaks = text.replaceAll("\\r?\\n", " ");
      ArrayList<List<String>> sentences = new ArrayList<>();
      for(String rawSentence: removedBreaks.split("[\\.\\?\\!]")) {
         List<String> words = toWords(rawSentence);
         if(words.size() > 0) {
            sentences.add(words);
         }
      }
      
      return sentences;
   }
   
   public static List<String> toWords(String sentence) {
      String[] rawWords = sentence.split("\\s+");
      List<String> words = new ArrayList<>();
      for(String rawWord: rawWords) {
         String word = rawWord.replaceAll("\\W", "");
         if(word.length() > 0) {
            words.add(word);
         }
      }
      
      return words;
   }

   public static double analyze(List<List<String>> sentences) {
      float totalsentences = sentences.size();
      float totalwords = sentences.stream().mapToInt(sentence -> sentence.size()).sum();
      float totalsyllables = sentences.stream()
         .flatMapToInt(sentence -> 
            sentence.stream().mapToInt(word -> countSyllables(word)))
         .sum();
      return 206.835 - 1.015 * (totalwords / totalsentences) - 84.6 * (totalsyllables / totalwords);
   }

   public static int countSyllables(String word) {
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

   private static boolean isVowel(char letter) {
      return letter == 'a' || letter == 'e' || letter == 'i' || letter == 'o' || letter == 'u';
   }
     
}
