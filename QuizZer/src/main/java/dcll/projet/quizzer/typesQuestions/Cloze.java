package dcll.projet.quizzer.typesQuestions;

import dcll.projet.quizzer.Question;

/**
 * This class contains definition of Cloze Questions
 * 
 * @author Eros Luce, Clement Bardou, Christelle Lacan, Thierno Bah
 * 
 */
public class Cloze extends Question {

	/**
	 * The question text.
	 */
	private String questiontext;
	/**
	 * The question is shuffle or not ?
	 */
	private int shuffleanswers;
	/**
	 * The type cloze.
	 */
	private String type;
	/**
	 * The question feedback.
	 */
	private String generalfeedback;

	/**
	 * Constructor.
	 * 
	 * @param mName The name of cloze
	 * @param mQuestionText The question text
	 * @param mShuffleanswers [0/1] shuffle or not shuffle
	 */
	public Cloze(final String mName, final String mQuestionText,
			final int mShuffleanswers, final String mGeneralfeedback) {
		super(mName);
		questiontext = mQuestionText;
		shuffleanswers = mShuffleanswers;
		generalfeedback = mGeneralfeedback;
		type = "Cloze";
	}

	/**
	 * @return a string
	 */
	public final String toString() {
		return "\n----Ceci est une " + type + " : \n" + super.toString()
				+ "questionsText : " + questiontext + "\n"
				+ "shuffleanswers : " + shuffleanswers + "\n";

	}

	/**
	 * @return general feedback
	 */
	public final String getGeneralfeedback() {
		return generalfeedback;
	}

	/**
	 * @return type
	 */
	public final String getType() {
		return type;
	}

	/**
	 * @return question text
	 */
	public final String getQuestiontext() {
		return questiontext;
	}

	/**
	 * @return is it shuffle or not ?
	 */
	public final int isShuffleanswers() {
		return shuffleanswers;
	}

}
