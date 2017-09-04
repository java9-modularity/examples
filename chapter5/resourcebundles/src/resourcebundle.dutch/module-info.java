module resourcebundle.dutch {
  requires resourcebundle.main;

  provides javamodularity.resourcebundle.TranslationsProvider
      with javamodularity.resourcebundle.dutch.DutchTranslationsProvider;

}
