module resourcebundle.dutch {
  requires resourcebundle.main;

  provides javamodularity.resourcebundle.spi.TranslationsProvider
      with javamodularity.resourcebundle.dutch.DutchTranslationsProvider;

}
