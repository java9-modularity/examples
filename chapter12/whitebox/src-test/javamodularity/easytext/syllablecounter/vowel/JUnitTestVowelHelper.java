package javamodularity.easytext.syllablecounter.vowel;

import org.junit.Test;
import javamodularity.easytext.syllablecounter.vowel.VowelHelper;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class JUnitTestVowelHelper {

   @Test
   public void testIsVowel() {
      assertTrue(VowelHelper.isVowel('e'));
   }

   @Test
   public void testGetVowels() {
      assertEquals(5, VowelHelper.getVowels().size());
   }

}
