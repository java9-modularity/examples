package modulename;

public class Main {

  public static void main(String... args) {
    // TODO: Module-Name not implemented yet!
    String moduleName = Main.class.getModule().getName();
    System.out.println("Automatic module loaded with name: " + moduleName);
    assert moduleName.equals("com.javamodularity.modulename");
  }

}
