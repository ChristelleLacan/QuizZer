package dcll.projet.quizzer;

/**
 * This class contains definition of Answers used in questions
 * 
 * @author Eros Luce, Clement Bardou, Christelle Lacan, Thierno Bah
 * 
 */
public class Answer {
	private String fraction;
	private String tolerance;
	private String toleranceType;
	private String correctAnswerFormat;
	private String correctAnswerLength;
	private String feedback;
	private String text;

	/**
	 * Constructor :
	 * 
	 * @param mText
	 * @param mFraction
	 * @param mFeedback
	 * @param mTolerance
	 * @param mToleranceType
	 * @param mCorrectAnswerFormat
	 * @param mCorrectAnswerLenght
	 */
	public Answer(String mText, String mFraction, String mFeedback,
			String mTolerance, String mToleranceType,
			String mCorrectAnswerFormat, String mCorrectAnswerLenght) {
		text = mText;
		fraction = mFraction;
		feedback = mFeedback;
		tolerance = mTolerance;
		toleranceType = mToleranceType;
		correctAnswerFormat = mCorrectAnswerFormat;
		correctAnswerLength = mCorrectAnswerLenght;
	}

	/**
	 * toString
	 */
	public String toString() {
		return "\n--Text : " + text + "\n\t\tFraction : " + fraction
				+ "\n\t\tFeedback : " + feedback + "\n\t\tTolerance : "
				+ tolerance + "\n\t\tTolerance type : " + toleranceType
				+ "\n\t\tCorrect Answer Format : " + correctAnswerFormat
				+ "\n\t\tCorrect Answer Lenght : " + correctAnswerLength;
	}

	public String getFraction() {
		return fraction;
	}

	public String getFeedback() {
		return feedback;
	}

	public String getText() {
		return text;
	}

	public String getTolerance() {
		return tolerance;
	}

	public String getToleranceType() {
		return toleranceType;
	}

	public String getCorrectAnswerFormat() {
		return correctAnswerFormat;
	}

	public String getCorrectAnswerLength() {
		return correctAnswerLength;
	}

}
