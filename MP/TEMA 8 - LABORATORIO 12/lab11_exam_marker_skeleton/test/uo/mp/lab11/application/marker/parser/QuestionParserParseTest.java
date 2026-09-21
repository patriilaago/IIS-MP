package uo.mp.lab11.application.marker.parser;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import javax.swing.text.html.HTMLEditorKit.Parser;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import uo.mp.lab11.application.model.question.ChoiceQuestion;
import uo.mp.lab11.application.model.question.GapQuestion;
import uo.mp.lab11.application.model.question.Question;
import uo.mp.lab11.application.model.question.ValueQuestion;

public class QuestionParserParseTest {

	private QuestionParser parser;

	
	@BeforeEach
	public void setUp() {
		parser = new QuestionParser();
	}
	
	@Test
	public void correctFileCorrectQuestions() {
		List<String> lines = new ArrayList<>();
		lines.add("choice	1.0	a");
		lines.add("gap	0.5	computer");
		lines.add("value	1.5	12.5");
		List<Question> questions = new LinkedList<>();
		questions = new LinkedList<>();
		questions.add(new ChoiceQuestion(0, 1.0, "a"));
		questions.add(new GapQuestion(1, 0.5, "computer"));
		questions.add(new ValueQuestion(2, 1.5, 12.5));
		assertEquals(questions.toString(), parser.parse(lines).toString());
	}
	
	@Test
	public void gapQuestionValid() {
		List<String>lines = new ArrayList<>();
		lines.add("gap	1.0	polymorphism");
		List<Question> gap = new LinkedList<>();
		gap.add(new GapQuestion(0, 1.0, "ploymorphism"));
		assertEquals(gap.toString(),parser.parse(lines).toString());
	}
	
	@Test
	public void valueQuestionValid() {
		List<String>lines = new ArrayList<>();
		lines.add("value	1.0	256.0");
		List<Question> value = new LinkedList<>();
		value.add(new ValueQuestion(0, 1.0, 256.0));
		assertEquals(value.toString(),parser.parse(lines).toString());
	}

	@Test
	public void choiceQuestionValid() {
		List<String>lines = new ArrayList<>();
		lines.add("choice	0.5	c");
		List<Question> choice = new LinkedList<>();
		choice.add(new ChoiceQuestion(0, 0.5, "c"));
		assertEquals(choice.toString(),parser.parse(lines).toString());
	}
}
