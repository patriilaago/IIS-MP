package uo.mp.util.file;



import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.List;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;


/**
 * A utility class to read/write text lines 
 * from/to a compressed text file (.txt.gz) 
 */
public class ZipFileUtil extends BaseFileUtil{

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
		try(BufferedReader reader = createReaderChain(pathToZippedFileName)){
			while(reader.ready()) {//mientras tengamos datos para leer
				String line = reader.readLine();
				res.add(line);
			}
		}

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
	public void writeLines(String outZippedFileName, List<String> lines) throws IOException {
		try(BufferedWriter writer = createWriterChain(outZippedFileName)){
			for(String line : lines) {
				writer.write(line);
				writer.newLine();//true significa que esrcibe a continuación de lo que ya había
			}
		}
	}

	@Override
	protected BufferedReader createReaderChain(String inFileName) throws FileNotFoundException, IOException {
		// TODO Auto-generated method stub
		BufferedReader reader = new BufferedReader(new InputStreamReader(new GZIPInputStream(new FileInputStream(inFileName))));
		return reader;
	}

	@Override
	protected BufferedWriter createWriterChain(String outFileName) throws IOException {
		// TODO Auto-generated method stub
		BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new GZIPOutputStream(new FileOutputStream(outFileName))));
		return writer;
	}

}
