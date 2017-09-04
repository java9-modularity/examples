package javamodularity.providers.method;

import java.util.List;
import javamodularity.easytext.analysis.api.Analyzer;

public class ExampleProviderMethod implements Analyzer {

  private String name;

  ExampleProviderMethod(String name) {
    this.name = name;
  }

  @Override
  public String getName() {
    return name;
  }

  @Override
  public double analyze(List<List<String>> sentences) {
     return 0;
  }

  public static ExampleProviderMethod provider() {
    return new ExampleProviderMethod("Analyzer created by static method");
  }
}
