package javamodularity.providers.factory;

import java.util.List;
import javamodularity.easytext.analysis.api.Analyzer;

class ExampleProvider implements Analyzer {

  private String name;

  public ExampleProvider(String name) {
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
}
