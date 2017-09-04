package javamodularity.providers.factory;

public class ExampleProviderFactory {
  public static ExampleProvider provider() {
    return new ExampleProvider("Analyzer created by factory");
  }
}
