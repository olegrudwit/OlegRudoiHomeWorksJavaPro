package apps.logger;

import java.io.*;

/*
 * @author Oleg Rudoi
 * @version 1.0 16 Sept 2022
 */
public class FileLoggerConfigurationLoader {
    private String pathConfigFile;

    private String filePath;
    private LoggingLevel loggingLevel;
    private int maxSize;
    private String fileFormat;

    public FileLoggerConfiguration load(String path) {
        try (FileReader fr = new FileReader(path);
             BufferedReader br = new BufferedReader(fr)) {
            String s;
            while (br.ready()) {
                s = br.readLine();

                if (s.contains("FILE")) {
                    filePath = s.replaceAll("FILE: ", "");
                } else if (s.contains("LEVEL")) {
                    loggingLevel = LoggingLevel.valueOf(s.replaceAll("LEVEL: ", ""));
                } else if (s.contains("MAX-SIZE")) {
                    maxSize = Integer.parseInt(s.replaceAll("MAX-SIZE: ", ""));
                } else if (s.contains("FORMAT")) {
                    fileFormat = s.replaceAll("FORMAT: ", "");
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return new FileLoggerConfiguration(filePath, loggingLevel, maxSize, fileFormat);
    }

    public FileLoggerConfigurationLoader() {
    }

    public String getPathConfigFile() {
        return pathConfigFile;
    }

    public void setPathConfigFile(String pathConfigFile) {
        this.pathConfigFile = pathConfigFile;
    }
}