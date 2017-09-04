package javamodularity.easytext.analysis.factory;

import java.util.List;
import java.util.stream.Collectors;

import javamodularity.easytext.analysis.api.Analyzer;
import javamodularity.easytext.analysis.kincaid.FleschKincaid;
import javamodularity.easytext.analysis.coleman.Coleman;

public class AnalyzerFactory {

   public static List<String> getSupportedAnalyses() {
     return List.of(FleschKincaid.NAME, Coleman.NAME);
   }

   public static Analyzer getAnalyzer(String name) {
      switch (name) {
         case FleschKincaid.NAME: return new FleschKincaid();
         case Coleman.NAME: return new Coleman();
         default: throw new IllegalArgumentException("No such analyzer!");
      }
   }

}
