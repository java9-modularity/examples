import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.LogRecord;


public class NotInModule {

  public static void main(String... args) {
    Logger logger = Logger.getGlobal();
    LogRecord message =
    new LogRecord(Level.INFO, "This still works!");
    logger.log(message);
  }

}
