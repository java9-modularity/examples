package demo;

public class Main {

  public static void main(String... args) throws Exception {
    Class<?> clazz = Class.forName("org.hsqldb.jdbcDriver");
    System.out.println(clazz.getName());
  }
}
