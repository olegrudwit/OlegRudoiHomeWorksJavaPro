package apps.logger;

public class FileLogger {
    public void info(String msg){
        System.out.println("infolog" + msg);
    }

    public void debug(String msg){
        info("1debug");
        System.out.println("debuglog" + msg);
    }
}
