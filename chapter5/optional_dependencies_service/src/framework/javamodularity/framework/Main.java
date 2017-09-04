package javamodularity.framework;

import java.util.Iterator;
import java.util.ServiceLoader;

import javamodularity.fastjsonlib.FastJson;

public class Main {

  public static void main(String... args) {
    FastJson fastJson =
      ServiceLoader.load(FastJson.class)
                   .findFirst()
                   .orElse(getFallBack())
  }

  private static FastJson getFallBack() {
    return null;
  }

}
