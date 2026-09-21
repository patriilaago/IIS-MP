package uo.mp.util.log;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.Date;

public class FileLogger {

    private static PrintStream out;

    static {
        try {
            out = new PrintStream(new FileOutputStream("log.txt", true));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * Sends the string received as message to the log file, prefixing it with 
     * a timestamp 
     * @param message
     */
    public static void log(String message) {
        out.print(new Date() + " ");
        out.println(message);
    }

    /**
     * Sends the full stack trace of the exception received to the log file
     * prefixing it with a timestamp 
     * @param t, the exception to be logged
     */
    public static void log(Throwable t) {
        out.print(new Date() + " ");
        t.printStackTrace(out);
    }
}

