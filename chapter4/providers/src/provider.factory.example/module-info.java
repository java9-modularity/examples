module provider.factory.example {
    requires easytext.analysis.api;

    provides javamodularity.easytext.analysis.api.Analyzer
      with javamodularity.providers.factory.ExampleProviderFactory;
}
