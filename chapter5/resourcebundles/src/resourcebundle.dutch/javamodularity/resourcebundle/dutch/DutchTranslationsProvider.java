package javamodularity.resourcebundle.dutch;

import java.util.Locale;
import java.util.ResourceBundle;
import java.util.spi.AbstractResourceBundleProvider;

import javamodularity.resourcebundle.spi.TranslationsProvider;

public class DutchTranslationsProvider extends AbstractResourceBundleProvider
                                       implements TranslationsProvider {

  private static Locale DUTCH = Locale.forLanguageTag("nl");

  @Override
  public String toBundleName(String baseName, Locale locale) {
    String bundleName = super.toBundleName(baseName, locale);
    if (DUTCH.equals(locale)) {
        int index = bundleName.lastIndexOf('.');
        return bundleName.substring(0, index + 1) + "dutch" + bundleName.substring(index);
    }
    return bundleName;
  }

  @Override
  public ResourceBundle getBundle(String baseName, Locale locale) {
    if (DUTCH.equals(locale)) {
        return super.getBundle(baseName, locale);
    }
    return null;
  }

}
