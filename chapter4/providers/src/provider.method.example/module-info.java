module provider.method.example {
    requires easytext.analysis.api;

    provides javamodularity.easytext.analysis.api.Analyzer
      with javamodularity.providers.method.ExampleProviderMethod;
}
