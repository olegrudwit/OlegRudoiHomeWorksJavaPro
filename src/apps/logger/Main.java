package apps.logger;

/*
 * @author Oleg Rudoi
 * @version 1.0 16 Sept 2022
 */
public class Main {
    public static void main(String[] args) {
        FileLoggerConfiguration fileLoggerConfig = new FileLoggerConfiguration(LoggingLevel.DEBUG);
        fileLoggerConfig.setFilePath("src/log/");
        fileLoggerConfig.setFileFormat("TXT");
        fileLoggerConfig.setMaxSize(128);
        FileLogger fileLogger = new FileLogger(fileLoggerConfig);

        fileLogger.info("Program starts");
        fileLogger.info("infolog");
        fileLogger.debug("debuglog");
        fileLogger.debug("debuglog");
        fileLogger.debug("debuglog");
        fileLogger.debug("debuglog");
        fileLogger.debug("debuglog");
        fileLogger.debug("debuglog");
        fileLogger.debug("debuglog");
        fileLogger.debug("debuglog");
        fileLogger.debug("debuglog");
        fileLogger.debug("debuglog");
        fileLogger.debug("debuglog");
        fileLogger.debug("debuglog");
        fileLogger.debug("debuglog");
        fileLogger.debug("debuglog");
        fileLogger.debug("debuglog");
        fileLogger.debug("debuglog");
        fileLogger.debug("debuglog");
        fileLogger.debug("debuglog");
        fileLogger.debug("debuglog");
        fileLogger.debug("debuglog");
        fileLogger.debug("debuglog");
        fileLogger.info("Program ends");


        FileLoggerConfigurationLoader configLoader2 = new FileLoggerConfigurationLoader();
        FileLoggerConfiguration fileLoggerConfig2 = configLoader2.load("src/log/LoggerConfiguration.txt");
        FileLogger fileLogger2 = new FileLogger(fileLoggerConfig2);

        fileLogger2.info("Program starts");
        fileLogger2.info("infolog");
        fileLogger2.debug("debuglog");
        fileLogger2.debug("debuglog");
    }
}
