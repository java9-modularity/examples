package javamodularity.application;

import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodHandles.Lookup;

import javamodularity.ormframework.OrmFramework;

public class Main {

  public static void main(String... args) {
    Lookup lookup = MethodHandles.lookup();
    OrmFramework ormFramework = new OrmFramework(lookup);

    Book book = ormFramework.loadfromDatabase("/* query */", Book.class);

    System.out.println(book.getTitle());
  }

}
