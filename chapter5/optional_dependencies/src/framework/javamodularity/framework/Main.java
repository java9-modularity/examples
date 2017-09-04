package javamodularity.framework;

import javamodularity.fastjsonlib.FastJson;

public class Main {

  public static void main(String... args) {
    try {
      Class<?> clazz = Class.forName("javamodularity.fastjsonlib.FastJson");
      FastJson instance =
        (FastJson) clazz.getConstructor().newInstance();
      System.out.println("Using FastJson");
    } catch (ReflectiveOperationException e) {
      System.out.println("Oops, we need a fallback!");
    }
  }

}
