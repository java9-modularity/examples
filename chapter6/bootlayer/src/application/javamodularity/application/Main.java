package javamodularity.application;

import java.sql.Driver;

public class Main {

  public static void main(String... args) {
    Driver driver = null; // We reference java.sql.Driver to see 'java.sql' gets resolved
    ModuleLayer.boot().modules().forEach(m -> System.out.println(m.getName() + ", loader: " + m.getClassLoader()));
    System.out.println("System classloader: " + ClassLoader.getSystemClassLoader());
  }

}
