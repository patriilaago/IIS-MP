package uo.mp.util.file;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.IOException;

public abstract class BaseFileUtil {
	protected abstract BufferedReader createReaderChain(String inFileName) throws FileNotFoundException, IOException;
			
	protected abstract BufferedWriter createWriterChain(String outFileName) throws IOException;

}
