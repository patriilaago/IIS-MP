package uo.mp.lab11.application.marker;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import uo.mp.lab11.application.marker.parser.ExamParser;
import uo.mp.lab11.application.marker.parser.QuestionParser;
import uo.mp.lab11.application.model.StudentExam;
import uo.mp.lab11.application.model.StudentMark;
import uo.mp.lab11.application.model.comparator.IdComparator;
import uo.mp.lab11.application.model.comparator.MarkComparator;
import uo.mp.lab11.application.model.question.Question;


public class ExamMarker {
	/*
	 * file questions.txt is read and parsed into questions list
	 */
	private List<Question> questions = new ArrayList<>();
	/*
	 * file answers.gz is read and parsed into answers list
	 */
	private List<StudentExam> answers = new ArrayList<>();
	/*
	 * Student marks are computed and stored into marks list
	 */
	private List<StudentMark> marks = new LinkedList<>();


	/**
	 * 
	 * @param examModelFile
	 * @throws IOException 
	 * @throws IllegalArgumentException if examModelFile is null or blank
	 * @throws FileNotFoundException if examModelFile cannot be found
	 */
	public void loadQuestions(String questionsFilename) throws IOException {
		List<String> lines = readQuestionLines(questionsFilename);
		List<Question> questions = new QuestionParser().parse( lines );
		addQuestions( questions );
	}
	
	/*
	 * TODO : FAKE IMPLEMENTATION
	 */
	private List<String> readQuestionLines(String questionsFilename) throws IOException {
		List<String> res = new LinkedList<>();
		try(BufferedReader reader = new BufferedReader(new FileReader(questionsFilename))){
			while(reader.ready()) {
				String line = reader.readLine();
				res.add(line);
			}
			reader.close();
		}
		catch(IOException e) {
			throw new RuntimeException("PROGRAMMING ERROR. Error reading data");
//			FileLogger.log(e.printStackTrace());
		}
		return res;
	}
	
	
	/*
	 * TODO : FAKE IMPLEMENTATION
	 */
	private void addQuestions(List<Question> quests) {
		this.questions = quests;
		
	}

	/**
	 * 
	 * @param answersFilename
	 * @throws FileNotFoundException if answersFile cannot be found
	 * @throws IllegalArgumentException if answersFilename is null or blank
	 * @throws ExamMarkerException when there are more than one exam for the same student 
	 */
	public void loadAnswers(String answersFilename) {
		
		List<String> lines = readAnswerLines();
		List<StudentExam> exams = new ExamParser().parse( lines );
		addExams( exams );
	}

	/*
	 * FAKE IMPLEMENTATION 
	 */
	private List<String> readAnswerLines() {
		List<String> res = new ArrayList<>();
		res.add("20209	c	b	cosa	computer	10.5	100	inheritance	256.0	a	abstract");
		res.add("20210	a	b	stuff	processor	11.5	120	inheritance	128.0	a	abstract");
		res.add("20211	b	a	other	process	12.5	110	inheritance	256.0	a	blank");
		res.add("20215	a	b	stuff	thread	13.5	80	inheritance	0.0	a	n/a");
		res.add("20214	b	c	thing	computer	14.5	0	inheritance	512.0	a	abstract");
		res.add("20213	c	d	cosa	computer	12.5	10	inheritance	1021.0	a	abstract");
		
		return res;
	}

	/*
	 * TODO: FAKE IMPLEMENTATION
	 */
	private void addExams(List<StudentExam> exams) {
		this.answers = exams;
	}


	/**
	 * 
	 * @return the list of marks ordered by student id in ascending order
	 */
	public List<StudentMark> getMarksByStudent() {
		Collections.sort(marks, new IdComparator());
		return marks;	
	}

	/**
	 * 
	 * @return the list of marks ordered by grade in ascending order
	 * 			For the same grade, by ascending student id
	 */
	public List<StudentMark> getMarksByMark() {
		Collections.sort(marks, new MarkComparator());
		return marks;
	}

	/**
	 * calculates the mark for each exam. 
	 * Generates StudentMark instances
	 */
	public void mark() {
		// TODO FAKE IMPLEMENTATION
		marks.add(new StudentMark("20209", 5.2));
		marks.add(new StudentMark("20210", 3.9));
		marks.add(new StudentMark("20211", 2.0)); 
		marks.add(new StudentMark("20215", 2.4));
		marks.add(new StudentMark("20214", 1.5)); 
		marks.add(new StudentMark("20213", 3.0));
	}

	/**
	 * 
	 * @param resultsFilename
	 * @throws IllegalArgumentException if resultsFilename is null or blank
	 */
	public void saveResults(String resultsFilename) {
		// TODO 
	}


	public List<StudentExam> getAnswers() {
		// TODO FAKE IMPLEMENTATION
		return answers ;
	}

	public List<Question> getQuestions() {
		// TODO FAKE IMPLEMENTATION
		return questions;
	}


}
