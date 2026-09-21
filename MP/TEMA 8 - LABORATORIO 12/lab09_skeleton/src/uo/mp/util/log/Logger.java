package uo.mp.util.log;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

/**
 * A very basic implementation of a logger utility.
 * For this the date are sent to the System.err standard output.
 * The format of every lines is: <timestamp> <message>
 */
public class Logger {

	private String outFileName;
    private static boolean APPEND = true;
    private static boolean AUTOFLUSH = true;
	
	public Logger(String fileName) {
		this.outFileName=fileName;
	}

	/**
	 * Sends the string received as message to the log, prefixing it with 
	 * a timestamp 
	 * @param message
	 * @throws IOException 
	 */
	public void log(String message){
		try (PrintWriter out= new PrintWriter(new FileWriter(outFileName,APPEND),AUTOFLUSH)){
			out.print( new Date()  + " ");
			out.println( message );
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.err.println("Unable to log");
			System.err.println(e.getMessage());
			e.printStackTrace();
		}
	}

	/**
	 * Sends the full stack trace of the exception received to the log
	 * prefixing it with a timestamp 
	 * @param t, the exception to be logged
	 */
	public void log(Throwable exception) {
		try(PrintWriter out= new PrintWriter(new FileWriter(outFileName,APPEND),AUTOFLUSH)) {
			out.print( new Date()  + " ");
			exception.printStackTrace( out );
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.err.println("Unable to log");
			System.err.println(e.getMessage());
			e.printStackTrace();
		}
	}
}
