package dcll.projet.quizzer;

public class NumericalAnswer {
	private float fraction;
	private String numericalAnswerText;
	private float tolerance;
	private String feedback;

	public NumericalAnswer(float mFraction, String mNumeraicalAnswerText,
			float mTolerance, String mFeedback) {
		fraction = mFraction;
		numericalAnswerText = mNumeraicalAnswerText;
		tolerance = mTolerance;
		feedback = mFeedback;
	}

	public String toString() {
		return "\nNumericalAnswerText : " + numericalAnswerText + "\n\t\t"
				+ "Fraction : " + fraction + "\n\t\t" + "Tolerance : " + tolerance
				+ "\n\t\t" + "Feedback : " + feedback + "\n";
	}
}
