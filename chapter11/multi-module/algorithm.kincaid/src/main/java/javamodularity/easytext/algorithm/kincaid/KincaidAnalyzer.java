package javamodularity.easytext.algorithm.kincaid;

import java.util.Iterator;
import java.util.List;
import java.util.ServiceLoader;

import javamodularity.easytext.algorithm.api.Analyzer;
import javamodularity.easytext.algorithm.api.SyllableCounter;

public class KincaidAnalyzer implements Analyzer {

   private SyllableCounter syllableCounter;

   public KincaidAnalyzer() {
      Iterator<SyllableCounter> counters = ServiceLoader.load(SyllableCounter.class).iterator();
      if(counters.hasNext()) {
         this.syllableCounter =  counters.next();
      } else {
         throw new IllegalStateException("SyllableCounter not found");
      }
   }

   public String getName() {
      return "Flesch-Kincaid";
   }

   public double analyze(List<List<String>> sentences) {
      float totalsentences = sentences.size();
      float totalwords = sentences.stream().mapToInt(sentence -> sentence.size()).sum();
      float totalsyllables = sentences.stream()
         .flatMapToInt(sentence ->
            sentence.stream().mapToInt(word -> syllableCounter.countSyllables(word)))
         .sum();
      return 206.835 - 1.015 * (totalwords / totalsentences) - 84.6 * (totalsyllables / totalwords);
   }

}
