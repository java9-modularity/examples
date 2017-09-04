package mrlib;

public class Helper {
  public Helper() {
    ModuleLayer.boot().modules().forEach(System.out::println);
  }
}
