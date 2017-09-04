package javamodularity.easytext.test;

import org.junit.Test;
import javamodularity.easytext.syllablecounter.SimpleSyllableCounter;

import static org.junit.Assert.assertEquals;

public class JUnitTestSyllableCounter {

   private SimpleSyllableCounter counter = new SimpleSyllableCounter();

   @Test
   public void testSyllableCounter() {
      assertEquals(1, counter.countSyllables("Bike"));
      assertEquals(2, counter.countSyllables("Motor"));
      assertEquals(3, counter.countSyllables("Bicycle"));
   }

}
