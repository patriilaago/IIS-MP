package uo.mp.lab11.application.simulator;

import java.io.IOException;
import java.util.List;

import uo.mp.lab11.application.marker.ExamMarker;
import uo.mp.lab11.application.model.StudentExam;
import uo.mp.lab11.application.model.StudentMark;
import uo.mp.lab11.application.model.question.Question;

public class Simulator {

	private static final String QUESTIONS_FILE = "questions.txt";
	private static final String STUDENTS_EXAMS_FILE = "studentsExams.gz";
	private static final String MARKS_FILE = "marks.txt";

	public void simulate() {
		simulateScenario1();
		
		simulateScenario2();
		
	}



	/**
	 * There is no user interface for this small program. This method
	 * simulates an example scenario of use.
	 * @throws IOException 
	 */
	private void simulateScenario1() {
		ExamMarker ex = new ExamMarker();
		try {
			ex.loadQuestions( QUESTIONS_FILE );
		} catch (IOException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException("Error reading data");
		}
		showQuestions(ex.getQuestions());
		ex.loadAnswers( STUDENTS_EXAMS_FILE );
		showExams(ex.getAnswers());

		ex.mark();

		showMarks( ex.getMarksByMark(), " by ascending mark" );
		showMarks( ex.getMarksByStudent(), " by ascending student id" );
		ex.saveResults( MARKS_FILE );
	}

	private void showQuestions(List<Question> questions) {
		System.out.println("---------------------------------------------");
		System.out.println("List of questions");
		for(Question q: questions) {
			System.out.println( q.toString() );
		}
	}

	private void showExams(List<StudentExam> exams) {
		System.out.println("---------------------------------------------");
		System.out.println("List of exams");
		for(StudentExam se: exams) {
			System.out.println( se.toString() );
		}
	}

	private void showMarks(List<StudentMark> marks, String string) {
		System.out.println("---------------------------------------------");
		System.out.println("List of marks" + string);
		for(StudentMark mark: marks) {
			System.out.println( mark.toString() );
		}
	}

	
	private void simulateScenario2() {
		/*
		 * Write other possible scenarios
		 */
	}

}
