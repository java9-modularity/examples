package javamodularity.framework;

import java.util.Iterator;
import java.util.ServiceLoader;

import javamodularity.fastjsonlib.FastJson;

public class Main {

  public static void main(String... args) {
    FastJson fastJson =
      ServiceLoader.load(FastJson.class)
                   .findFirst()
                   .orElse(getFallBack());

      if(fastJson == null) {
        System.out.println("Using a fallback");
      } else {
        System.out.println("Found a service");
      }
  }

  private static FastJson getFallBack() {
    return null;
  }

}
