package uo.mp.lab11.application.model.serializer;

import java.util.ArrayList;
import java.util.List;

import uo.mp.lab11.application.model.question.Question;

public class QuestionSerializer {

	public List<String> serialize(List<Question> questions){
		List<String> result = new ArrayList<>();
		for(Question question : questions) {
			result.add(question.serialize());
		}
		return result;
	}
	
}
