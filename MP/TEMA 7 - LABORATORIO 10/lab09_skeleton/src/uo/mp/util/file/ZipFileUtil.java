package uo.mp.util.file;



import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.zip.GZIPInputStream;

import uo.mp.newsstand.exception.NotYetImplementedException;

/**
 * A utility class to read/write text lines 
 * from/to a compressed text file (.txt.gz) 
 */
public class ZipFileUtil {

	/**
	 * Fake method to read lines from a .gz file
	 * 
	 * Read all lines from a .gz file. A line is considered to be terminated by a line feed ('\n'). 
	 * Each item in the list (line) will contain the contents of a line, not including any line-termination characters.
	 * 
	 * @param pathToZippedFileName path to a compressed file 
	 * @return the lines from the file as a List
	 * @throws FileNotFoundException 
	 * @throws IOException
	 */
	public List<String> readLines(String pathToZippedFileName) throws FileNotFoundException, IOException {
		List<String> res = new LinkedList<>();
		BufferedReader reader = new BufferedReader(new InputStreamReader(new GZIPInputStream(new FileInputStream(pathToZippedFileName)))) ;
		while(reader.ready()) {//mientras tengamos datos para leer
			String line = reader.readLine();
			res.add(line);
		}
		
		reader.close();
		
		return res;
	}

	/**
	 * Fake method to write lines to a .gz file
	 * 
	 * Write to a .gz file all strings in the list. Lines must be terminated by a line feed ('\n'). 
	 * Each item in the list (line) contains the contents for one line, not including any
	 * line-termination characters.
	 * @param pathToZippedFileName 	path to a compressed file 
	 * @param lines         		the List of strings to the written to the file 
	 * @throws IOException
	 */
	public void writeLines(String outZippedFileName, List<String> lines) {
//		try(BufferedWriter writer = new BufferedWriter(new (new GZIPInputStream(new FileInputStream(outZippedFileName))))) {
//			for(String line : lines) {
//				writer.write(line);
//				writer.newLine();//salto de linea
//			}// este try lo cierra solo
//			//writer.close();
//		}
	}

}
