package javamodularity.easytext.algorithm.api;

import java.util.List;

public interface Analyzer {
   
   String getName();
   
   double analyze(List<List<String>> text);

}