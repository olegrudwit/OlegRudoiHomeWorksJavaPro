package apps.logger;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/*
 * @author Oleg Rudoi
 * @version 1.0 16 Sept 2022
 */
public class FileLogger {
    private static final String LOGRECORD_TIME_PATTERN = "yyyy-MM-dd HH:mm:ss";
    private static final String FILENAME_TIME_PATTERN = "yyyy.MM.dd_HH-mm-ss";
    private FileLoggerConfiguration loggerConfig;
    private ArrayList<LoggingLevel> levels =
            new ArrayList<>(List.of(LoggingLevel.values()));

    public FileLogger(FileLoggerConfiguration loggerConfig) {
        this.loggerConfig = loggerConfig;
    }

    public void info(String msg) {
        if (levels.indexOf(loggerConfig.getLoggingLevel()) >=
                levels.indexOf(LoggingLevel.INFO)) {

            writeRecordToFile(setTextLogRecord(LoggingLevel.INFO, msg));
        }
    }

    public void debug(String msg) {
        if (levels.indexOf(loggerConfig.getLoggingLevel()) >=
                levels.indexOf(LoggingLevel.DEBUG)) {

            writeRecordToFile(setTextLogRecord(LoggingLevel.DEBUG, msg));
        }
    }

    private void writeRecordToFile(String record) {
        File file = new File(loggerConfig.getFilePath() + setLogFileName());

        try (OutputStream out = new FileOutputStream(file, true);
             Writer writer = new OutputStreamWriter(out, StandardCharsets.UTF_8)) {

            checkLoggingFile(file);
            writer.write(record);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void checkLoggingFile(File file) throws IOException {
        // варіант по завданню номер 4
//        if (file.getTotalSpace() > loggerConfig.getMaxSize()) {
//            throw new FileMaxSizeReachedException(
//                    "Maximum possible file size: " + loggerConfig.getMaxSize() + " byte(s). " +
//                    "Current file size: " + file.getTotalSpace() + " byte(s). " +
//                    "File path " + file.getPath());
//        }
        // варіант по завданню номер 6
        if (file.getTotalSpace() > loggerConfig.getMaxSize()) {
            file.createNewFile();
        }
    }

    private String setTextLogRecord(LoggingLevel loggingLevel, String msg) {
        SimpleDateFormat df = new SimpleDateFormat(LOGRECORD_TIME_PATTERN);
        StringBuilder sb = new StringBuilder();

        sb.append("\n[").append(df.format(new Date())).append("]")
          .append(" [").append(loggingLevel).append("]")
          .append(" [").append(msg).append("]");

        return sb.toString();
    }

    private String setLogFileName() {
        SimpleDateFormat df = new SimpleDateFormat(FILENAME_TIME_PATTERN);
        StringBuilder sb = new StringBuilder();

        sb.append("Log_").append(df.format(new Date()))
          .append(".").append(loggerConfig.getFileFormat());

        return sb.toString();
    }
}