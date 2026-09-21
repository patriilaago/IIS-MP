package uo.mp.lab11.application.model.question;

public abstract class Question {

	private int questionNumber;
	private double weight;

	/**
	 * @param number
	 * @param weight
 	 * @throws IllegalArgumentException if question <= 0
	 * @throws IllegalArgumentException if weight <= 0
	 */
	protected Question(int number, double weight) {

		this.questionNumber = number;
		this.weight = weight;
	}

	/**
	 * 
	 * @param answer
	 * @return
	 * @throws IllegalArgumentException
	 */
	public abstract double mark(String answer);

	protected double getWeight() {
		return weight;
	}
	
	protected int getNumber() {
		return this.questionNumber;
	}

	@Override
	public String toString() {
		return "Question [questionNumber=" + questionNumber + ", weight=" + weight + "]";
	}

	public abstract String serialize();
	
}
