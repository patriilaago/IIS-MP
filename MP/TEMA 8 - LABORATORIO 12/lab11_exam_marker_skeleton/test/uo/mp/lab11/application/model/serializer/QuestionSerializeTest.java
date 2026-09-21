package uo.mp.lab11.application.model.serializer;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import uo.mp.lab11.application.model.question.ChoiceQuestion;
import uo.mp.lab11.application.model.question.GapQuestion;
import uo.mp.lab11.application.model.question.ValueQuestion;

public class QuestionSerializeTest {

	@Test
	void serializeGap() {
		GapQuestion gap = new GapQuestion(0, 2.0, "Allocation");
		String result = "gap" + "\t" + 0 + "\t" + 2.0 + "\t" + "Allocation"; 
		assertEquals(result.toString(),gap.serialize());
	}

	@Test
	void serializeValue() {
		ValueQuestion value = new ValueQuestion(8, 1.0, 33.3);
		String result = "value" + "\t" + 8 + "\t" + 1.0 + "\t" + 33.3; 
		assertEquals(result.toString(),value.serialize());
	}
	
	@Test
	void serializeChoice() {
		ChoiceQuestion choice = new ChoiceQuestion(4, 0.5, "d");
		String result = "choice" + "\t" + 4 + "\t" + 0.5 + "\t" + "d"; 
		assertEquals(result.toString(),choice.serialize());
	}
}
