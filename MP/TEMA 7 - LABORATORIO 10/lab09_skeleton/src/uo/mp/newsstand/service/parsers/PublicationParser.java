package uo.mp.newsstand.service.parsers;

import java.util.ArrayList;
import java.util.List;

import uo.mp.newsstand.domain.Magazine;
import uo.mp.newsstand.domain.Newspaper;
import uo.mp.newsstand.domain.Publication;
import uo.mp.newsstand.domain.Magazine.Frequency;
import uo.mp.util.check.ArgumentChecks;
import uo.mp.util.exceptions.Cause;
import uo.mp.util.exceptions.InvalidLineFormatException;
import uo.mp.util.log.Logger;

public class PublicationParser {

	private final static int MAGAZINE_FIELDS = 5;
	private final static int NEWSPAPER_FIELDS = 5;
	private final static int LOW_STOCK = 0;
	private final static int MAXIMUM_STOCK = 50;
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
				Logger.log("Error in line " + lineNumber + ": " + e.getMessage());
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
		final String SEPARATOR = "\t", NEWS = "newspaper", MAGAZINE="magazine";
		String[] fields = line.split(SEPARATOR);
		final int KEYWORD_INDEX = 0;
		if(fields[KEYWORD_INDEX].contentEquals(NEWS)) {
			return parseNewsPaper(fields, line);
		}	
		else if(fields[KEYWORD_INDEX].contentEquals(MAGAZINE)){
			return parseMagazine(fields,line);
		}
		else {
			throw new InvalidLineFormatException(Cause.INVALID_NUMBER,Integer.parseInt(line));
		}
	}

	/**
	 * Transforms a line into a newspaper
	 * @param fields that are part of the newspaper
	 * @return newspaper that was a line of a file before
	 * @throws InvalidLineFormatException 
	 */
	private Newspaper parseNewsPaper(String[] fields, String line) throws InvalidLineFormatException {
		checkNumberOfParts(fields, NEWSPAPER_FIELDS, line);
		final int NAME_INDEX = 1, SALES_INDEX = 2, STOCK_INDEX = 3;
		int sales = Integer.parseInt(fields[SALES_INDEX]);
		int stock = Integer.parseInt(fields[STOCK_INDEX]);
		if(sales<0||sales>50||stock<0||stock>50) {
			throw new InvalidLineFormatException(Cause.INVALID_NUMBER, Integer.parseInt(line));
		}
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
		int sales = Integer.parseInt(fields[SALES_INDEX]);
		int stock = Integer.parseInt(fields[STOCK_INDEX]);
		if(sales<LOW_STOCK||sales>MAXIMUM_STOCK||stock<LOW_STOCK||stock>MAXIMUM_STOCK) {
			throw new InvalidLineFormatException(Cause.INVALID_NUMBER, Integer.parseInt(line));
		}
		Frequency frequency = Frequency.valueOf(fields[FREQUENCY_INDEX].toUpperCase());
		if(isValidFrequency(fields[FREQUENCY_INDEX].toUpperCase())== false) {
			throw new InvalidLineFormatException(Cause.INVALID_FREQUENCY, Integer.parseInt(line));
		}
		return new Magazine(fields[NAME_INDEX], sales, stock, frequency);
	}
	
	private boolean isValidFrequency(String frequency){
		for(String s : Frequency.getNames()) {
			if(s.equals(frequency)) {
				return true;
			}
		}
		return false;
	}
	

	private void checkNumberOfParts(String[] parts, int expected, String line) throws InvalidLineFormatException {
		if (parts.length != expected) {
			throw new InvalidLineFormatException(Cause.INVALID_NUMBER_OF_FIELDS,Integer.parseInt(line));
		}
	}
}
