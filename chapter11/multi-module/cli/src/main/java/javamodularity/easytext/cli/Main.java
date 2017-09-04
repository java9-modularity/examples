package javamodularity.easytext.cli;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.ServiceLoader;

import javamodularity.easytext.algorithm.api.Analyzer;
import static javamodularity.easytext.algorithm.api.Preprocessing.toSentences;

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
      
      Iterable<Analyzer> analyzers = ServiceLoader.load(Analyzer.class);
      for(Analyzer analyzer: analyzers) {
         System.out.println(analyzer.getName() + ": " + analyzer.analyze(sentences));
      }
      
   }
     
}
