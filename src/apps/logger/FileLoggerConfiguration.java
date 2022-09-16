package apps.logger;

/*
 * @author Oleg Rudoi
 * @version 1.0 16 Sept 2022
 */
public class FileLoggerConfiguration {
    private String filePath;
    private LoggingLevel loggingLevel;
    private int maxSize;
    private String fileFormat;

    public FileLoggerConfiguration(LoggingLevel loggingLevel) {
        this.loggingLevel = loggingLevel;
    }

    public FileLoggerConfiguration(String filePath, LoggingLevel loggingLevel,
                                   int maxSize, String fileFormat) {
        this.filePath = filePath;
        this.loggingLevel = loggingLevel;
        this.maxSize = maxSize;
        this.fileFormat = fileFormat;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public LoggingLevel getLoggingLevel() {
        return loggingLevel;
    }

    public void setLoggingLevel(LoggingLevel loggingLevel) {
        this.loggingLevel = loggingLevel;
    }

    public int getMaxSize() {
        return maxSize;
    }

    public void setMaxSize(int maxSize) {
        this.maxSize = maxSize;
    }

    public String getFileFormat() {
        return fileFormat;
    }

    public void setFileFormat(String fileFormat) {
        this.fileFormat = fileFormat;
    }
}