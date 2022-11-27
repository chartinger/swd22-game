package at.compus02.swd.ss2022.logger;

public class ConsoleLogger implements Logger {
    private static ConsoleLogger logger;

    private ConsoleLogger() {
    }

    public static ConsoleLogger getInstance() {
        if (logger == null) {
            logger = new ConsoleLogger();
        }

        return logger;
    }

    @Override
    public void log(String message) {
        System.out.println(message);
    }
}
