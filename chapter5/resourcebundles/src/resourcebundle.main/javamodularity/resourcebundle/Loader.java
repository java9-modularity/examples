package javamodularity.resourcebundle;

import java.util.Locale;
import java.util.ResourceBundle;

public class Loader {

   public static void main(String... args) throws Exception {
     String locale = args.length > 0 ? args[0] : "en-GB";
     Locale l = Locale.forLanguageTag(locale);
     ResourceBundle translations =
       ResourceBundle.getBundle("javamodularity.resourcebundle.Translations", l);

     System.out.println("Translation of modularity in " + l
       + ": " + translations.getString("modularity_key"));
   }

}
