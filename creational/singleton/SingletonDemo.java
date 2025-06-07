// Singleton class: Thread-safe with lazy initialization
public class AppLogger {
  private static volatile AppLogger instance;

  // Private constructor prevents instantiation from outside
  private AppLogger() {
    System.out.println("Logger Initialized");
  }

  // Double-checked locking for thread safety
  public static AppLogger getInstance() {
    if (instance == null) {
      synchronized (AppLogger.class) {
        if (instance == null) {
          instance = new AppLogger();
        }
      }
    }
    return instance;
  }

  public void log(String message) {
    System.out.println("[LOG] " + message);
  }
}

// Demo
public class SingletonDemo {
  public static void main(String[] args) {
    AppLogger logger1 = AppLogger.getInstance();
    AppLogger logger2 = AppLogger.getInstance();

    logger1.log("Application started.");
    logger2.log("Another component logging.");

    System.out.println("Are both loggers same instance? " + (logger1 == logger2));
  }
}
