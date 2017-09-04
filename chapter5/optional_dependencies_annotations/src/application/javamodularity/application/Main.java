package javamodularity.application;

public class Main {
  public static void main(String... args) {
    BookEntity b = new BookEntity();
    assert BookEntity.class.getAnnotations().length == 0;
    System.out.println("Running without annotation @GenerateSchema present.");
  }
}
