package uo.mp.lab11.application.marker.parser;

import java.util.ArrayList;
import java.util.List;

import uo.mp.lab11.application.log.FileLogger;
import uo.mp.lab11.application.model.question.ChoiceQuestion;
import uo.mp.lab11.application.model.question.GapQuestion;
import uo.mp.lab11.application.model.question.Question;
import uo.mp.lab11.application.model.question.ValueQuestion;

public class QuestionParser {

	private final static String CHOICE = "choice";
	private final static String GAP = "gap";
	private final static String VALUE = "value";
	private final static int WEIGHT_INDEX = 1;
	private final static int RIGHT_ANSWER = 2;
	private final static int VALID_NUMBER_OF_FIELDS = 3;
	private FileLogger logger = new FileLogger("files/log.txt");
	
	/**
	 * 
	 * @param lines
	 * @return
	 * @throws IllegalArgumentException if lines is null
	 */
	public List<Question> parse(List<String> lines) {
		List<Question> res = new ArrayList<>();
		
		for(String line: lines) {
			res.add(parseLine(line,lines.indexOf(line)));
		}
		return res;
	}

	private Question parseLine(String line, int index) {
		// TODO Auto-generated method stub
		String[] fields = line.split("\t");
		checkFields(fields, index);
		String type_question = fields[0];
		if(type_question.contentEquals(CHOICE)) {
			return parseChoiceQuestion(fields,index);
		}
		else if(type_question.contentEquals(GAP)) {
			return parseGapQuestion(fields,index);
		}
		else if(type_question.contentEquals(VALUE)) {
			return parseValueQuestion(fields,index);
		}
		else {
			logger.log(String.format("INVALID LINE (%d): invalid type of question",index));
		}
		return null;
	}

	private ValueQuestion parseValueQuestion(String[] fields,int index) {
		// TODO Auto-generated method stub
		checkFields(fields, index);
		double weight = Double.parseDouble(fields[WEIGHT_INDEX]);
		double rightAnswer = Double.parseDouble(fields[RIGHT_ANSWER]);
		checkWeight(weight, index);
		return new ValueQuestion(index, weight, rightAnswer);
	}

	private GapQuestion parseGapQuestion(String[] fields, int index) {
		// TODO Auto-generated method stub
		checkFields(fields, index);
		double weight = Double.parseDouble(fields[WEIGHT_INDEX]);
		String rightAnswer = fields[RIGHT_ANSWER];
		checkWeight(weight, index);
		return new GapQuestion(index, weight, rightAnswer);
	}

	private ChoiceQuestion parseChoiceQuestion(String[] fields, int index) {
		// TODO Auto-generated method stub
		checkFields(fields, index);
		double weight = Double.parseDouble(fields[WEIGHT_INDEX]);
		String rightAnswer = fields[RIGHT_ANSWER];
		checkWeight(weight, index);
		return new ChoiceQuestion(index, weight, rightAnswer);
	}
	
	private void checkWeight(double weight, int index) {
		if(weight<0.0) {
			logger.log(String.format("INVALID LINE (%d): invalid weight for question",index));
		}
	}
	
	private void checkFields(String[] fields, int index) {
		if(fields.length!=VALID_NUMBER_OF_FIELDS) {
			logger.log(String.format("INVALID LINE (%d): invalid number of fields for question",index));
		}
	}
}
