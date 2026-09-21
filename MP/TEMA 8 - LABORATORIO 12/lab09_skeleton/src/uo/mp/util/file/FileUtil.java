package uo.mp.util.file;

import java.io.BufferedReader;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;


/**
 * A utility class to read/write text lines from/to a text file
 */
public class FileUtil extends BaseFileUtil{

	/**
	 * Fake method to read lines from a file
	 * 
	 * Read all lines from a file. A line is considered to be terminated by a line feed ('\n'). 
	 * Each item in the list (line) will contain the contents of a line, not including any line-termination characters.
	 * @param pathToTheFile path to a plain text file
	 * @return the lines from the file as a List
	 * @throws FileNotFoundException 
	 * @throws IOException
	 * 							TODO
	 */
	public List<String> readLines(String pathToTheFile) throws  IOException {//FileNotFound hija de IO
		List<String> res = new LinkedList<>();
		try(BufferedReader reader = createReaderChain(pathToTheFile)){
			while(reader.ready()) {//mientras tengamos datos para leer
				String line = reader.readLine();
				res.add(line);
			}
		} catch(IOException e) {
			throw new RuntimeException("Error en lectura de datos");
		}
		return res;
	}

	/**
	 * Fake method to write lines to a file
	 * 
	 * Write to a plain text file all strings in the list. Lines will be separated by a line feed ('\n'). 
	 * Each item in the list (line) contains the contents for one line, not including any
	 * line-termination characters.
	 * 
	 * @param pathToTheFile path to a plain text file
	 * @param lines         the List of Strings to be writen to the file
	 * @throws IOException 	
	 * 							TODO
	 */
	public void writeLines(String outFileName, List<String> lines) throws IOException {
		try(BufferedWriter writer = createWriterChain(outFileName)){
			for(String line : lines) {
				writer.write(line);
				writer.newLine();//true significa que esrcibe a continuación de lo que ya había
			}
		}
	}

	@Override
	protected BufferedReader createReaderChain(String inFileName) throws FileNotFoundException, IOException {
		// TODO Auto-generated method stub
		BufferedReader reader = new BufferedReader(new FileReader(inFileName));
		return reader;
	}

	@Override
	protected BufferedWriter createWriterChain(String outFileName) throws IOException {
		// TODO Auto-generated method stub
		BufferedWriter writer = new BufferedWriter(new FileWriter(outFileName));
		return writer;
	}
}
