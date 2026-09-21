package uo.mp.lab11.application.model.question;

public class ValueQuestion extends Question {

	private double rightAnswer;

	/**
	 * 
	 * @param weight
	 * @param rightAnswer
	 * @throws IllegalArgumentException if
	 * 			* weight <= 0 
	 */
	public ValueQuestion(int number, Double weight, Double rightAnswer) {
		super( number, weight );
		this.rightAnswer = rightAnswer;
	}

	/**
	 * 
	 * @param answer
	 * @return
	 * @throws IllegalArgumentException if answer is 
	 * 		- null or blank
	 * 		- invalid number format
	 */
	@Override
	public double mark(String answer) {
		double anwsValue = toDouble(answer);
		return isInRange(getRightAnswer(), anwsValue, 0.1) 
				? getWeight() 
				: 0.0;
	}

	private double toDouble(String answer) {
		try {
			return Double.parseDouble( answer );			
		} catch(NumberFormatException nfe) {
			throw new IllegalArgumentException(nfe);
		}
	}

	private boolean isInRange(double rightValue, double anwsValue,
			double delta) {
		return rightValue - delta <= anwsValue
				&& anwsValue <= rightValue + delta;
	}

	public double getRightAnswer() {
		return rightAnswer;
	}

	@Override
	public String serialize() {
		// TODO Auto-generated method stub
		return "value" 
		+ "\t" + getNumber() 
		+ "\t" + getWeight() 
		+ "\t" + getRightAnswer(); 
	}

}
