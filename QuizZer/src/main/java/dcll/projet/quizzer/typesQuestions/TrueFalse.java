package dcll.projet.quizzer.typesQuestions;

import java.util.ArrayList;
import java.util.List;

import dcll.projet.quizzer.Question;
import dcll.projet.quizzer.typesQuestions.element.Answer;

/**
 * This class contains definition of True/False questions
 * 
 * @author Eros Luce, Clement Bardou, Christelle Lacan, Thierno Bah
 * 
 */
public class TrueFalse extends Question {

	private String questionText;
	private String format;
	private int defaultGrade;
	private double penalty;
	private int hidden;
	private int shuffleAnswers;
	private String generalfeedback;
	private List<Answer> answers = new ArrayList<Answer>();
	/**
	 * The type
	 */
	private String type;
	private String image;
	private String image_64;

	/**
	 * Constructor :
	 * 
	 * @param mName
	 * @param mQuestionText
	 * @param mDefaultgrade
	 * @param mPenalty
	 * @param mShuffleanswers
	 * @param mHidden
	 * @param mAnswers
	 * @param mFormat
	 * @param mImage
	 * @param mImage_64
	 */
	public TrueFalse(String mName, String mQuestionText, int mDefaultgrade,
			double mPenalty, int mShuffleanswers, int mHidden,
			String mGeneralfeedback, List<Answer> mAnswers, String mFormat,
			String mImage, String mImage_64) {
		super(mName);
		type = "TrueFalse";
		questionText = mQuestionText;
		format = mFormat;
		defaultGrade = mDefaultgrade;
		generalfeedback = mGeneralfeedback;
		penalty = mPenalty;
		shuffleAnswers = mShuffleanswers;
		hidden = mHidden;
		answers = mAnswers;
		image = mImage;
		image_64 = mImage_64;
	}

	/**
	 * toString
	 */
	public final String toString() {
		return "\n----Ceci est : une " + type + "  \n" + super.toString()
				+ "format : " + format + "defaultgrade : " + defaultGrade
				+ "\n" + "penalty : " + penalty + "\n" + "shuffleanswers : "
				+ shuffleAnswers + "\n" + "hidden : " + hidden + "\n"
				+ "questionsText : " + questionText + "\n" + "image : " + image
				+ "\n" + "image_64 : " + image_64 + "\n" + "answers : "
				+ answers.toString() + "\n";
	}

	public final String getGeneralfeedback() {
		return generalfeedback;
	}

	public final String getQuestionText() {
		return questionText;
	}

	public final String getFormat() {
		return format;
	}

	public final int getDefaultGrade() {
		return defaultGrade;
	}

	public final double getPenalty() {
		return penalty;
	}

	public final int getHidden() {
		return hidden;
	}

	public final int getShuffleAnswers() {
		return shuffleAnswers;
	}

	public final List<Answer> getAnswers() {
		return answers;
	}

	public final String getType() {
		return type;
	}

	public final String getImage() {
		return image;
	}

	public final String getImage_64() {
		return image_64;
	}

}
