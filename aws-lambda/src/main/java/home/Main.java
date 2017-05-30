package home;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {
    public static void main(String[] args) {
        String name = "World";

        Logger formatterLogger = LogManager.getFormatterLogger("home");
        formatterLogger.debug("Hello %s!", name);

        Logger slf4jLogger = LogManager.getLogger("home");;
        slf4jLogger.debug("Hello {}!", name);
        slf4jLogger.debug("Hello {}!", () -> "a very expensive operation");
        slf4jLogger.printf(Level.DEBUG, "slf4jLogger can be used as a %s but then cannot use *** %s ***.",
                "formatterLogger", "Java 8 lambdas");

    }
}
