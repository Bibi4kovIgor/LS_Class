package edu.lemon.transactions.logger;

@FunctionalInterface
public interface Logger {
    void log(LoggerState loggerState, String message);

    static Logger loggerPrintableFactoryWithState(){
        return ((loggerState, message) -> System.err.printf("Log type = %s, log message: %s%n",
                loggerState.name(), message));
    }
}
