package uo.mp.newsstand.service.parsers;

import java.util.ArrayList;

import java.util.List;

import uo.mp.newsstand.domain.Magazine;
import uo.mp.newsstand.domain.Newspaper;
import uo.mp.newsstand.domain.Publication;
import uo.mp.newsstand.domain.Magazine.Frequency;
import uo.mp.newsstand.ui.UserInterface;
import uo.mp.util.check.ArgumentChecks;
import uo.mp.util.exceptions.Cause;
import uo.mp.util.exceptions.InvalidLineFormatException;
import uo.mp.util.log.Logger;

public class PublicationParser {

	private final static int MAGAZINE_FIELDS = 5;
	private final static int NEWSPAPER_FIELDS = 4;
	/**
	 * Transforms a list of Strings in a list of instances of Publication.
	 * Any of the following are invalid lines in the input file: 
	 * 		- incorrect type of publication, 
	 * 		- wrong number of fields in a line, and 
	 * 		- incorrect data format in numeric fields.
	 * Invalid lines will not produce a Publication instance but will throw an InvalidLineFormatException instead.
	 * As a result of processing this exception, a message will be written to a log (use Log) 
	 * @param lines non-null list of strings, probably empty
	 * 		One by each publication
	 * 				type_of_publication \t name_of_publication \t sales \t stock \t frequency
	 * 
	 * @return a list of publications
	 */
	public List<Publication> parse(List<String> lines) {
		//throw new NotYetImplementedException("parse(lines)");
		Logger logger = new Logger(UserInterface.LOG_FILE);
		ArgumentChecks.isNotNull(lines);
		int lineNumber = 0;
		List<Publication> publications_list = new ArrayList<>();
		for(String line : lines) {
			if(line.isBlank()) {
				continue;//Si hay una linea en blanco continua
			}
			Publication publication;
			try {
				publication = parseLine(line);
				publications_list.add(publication);
			} catch (InvalidLineFormatException e) {
				logger.log("Error in line " + lineNumber + ": " + e.getMessage());
			}
		}
		return publications_list;
	}

	/**
	 * Transforms a line into a publication
	 * @param line we want to convert to a publication
	 * @return publication that was a line of a file before
	 * @throws InvalidLineFormatException 
	 */
	private Publication parseLine(String line) throws InvalidLineFormatException {
		checkIsBlank(line);
		final String SEPARATOR = "\t", NEWS = "newspaper", MAGAZINE="magazine";
		String[] fields = line.split(SEPARATOR);
		if(fields.length>MAGAZINE_FIELDS && fields.length<NEWSPAPER_FIELDS) {
			throw new InvalidLineFormatException(line, Cause.INVALID_NUMBER_OF_FIELDS);
		}
		final int KEYWORD_INDEX = 0;
		if(fields[KEYWORD_INDEX].contentEquals(NEWS)) {
			return parseNewsPaper(fields,line);
		}	
		else if(fields[KEYWORD_INDEX].contentEquals(MAGAZINE)){
			return parseMagazine(fields, line);
		}
		else {
			throw new InvalidLineFormatException(line, Cause.INVALID_KEYWORD);
		}
	}
	
	private void checkIsBlank(String line) throws InvalidLineFormatException {
		// TODO Auto-generated method stub
		if (line.isBlank()) {
			throw new InvalidLineFormatException("Blank line");
		}
	}

	/**
	 * Transforms a line into a newspaper
	 * @param fields that are part of the newspaper
	 * @return newspaper that was a line of a file before
	 * @throws InvalidLineFormatException 
	 */
	private Newspaper parseNewsPaper(String[] fields, String line) throws InvalidLineFormatException {
		checkNumberOfParts(fields, NEWSPAPER_FIELDS,line);
		final int NAME_INDEX = 1, SALES_INDEX = 2, STOCK_INDEX = 3;
		int sales = toInteger(fields[SALES_INDEX],line);
		int stock = toInteger(fields[STOCK_INDEX],line);
		return new Newspaper(fields[NAME_INDEX], sales, stock);
	}
	
	/**
	 * Transforms a line into a magazine
	 * @param fields that are part of the magazine
	 * @return magazine that was a line of a file before
	 * @throws InvalidLineFormatException 
	 */
	private Magazine parseMagazine(String[] fields, String line) throws InvalidLineFormatException {
		checkNumberOfParts(fields, MAGAZINE_FIELDS,line);
		final int NAME_INDEX = 1, SALES_INDEX = 2, STOCK_INDEX = 3, FREQUENCY_INDEX = 4;
		int sales = toInteger(fields[SALES_INDEX],line);
		int stock = toInteger(fields[STOCK_INDEX],line);
		return new Magazine(fields[NAME_INDEX], sales, stock, Frequency.valueOf(fields[FREQUENCY_INDEX].toUpperCase()));
	}
	
	private int toInteger(String convert, String line) throws InvalidLineFormatException {
		try {
			return Integer.parseInt(convert);
		} catch (Exception e) {
			throw new InvalidLineFormatException(line,Cause.INVALID_NUMBER);
		}	
	}
	
	private void checkNumberOfParts(String[] parts, int expected, String line) throws InvalidLineFormatException {
		if (parts.length != expected) {
			throw new InvalidLineFormatException(line,Cause.INVALID_NUMBER_OF_FIELDS);
		}
	}
}
