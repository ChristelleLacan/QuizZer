package dcll.projet.quizzer;

import java.util.ArrayList;
import java.util.List;

/**
 * This class contains definition of MultipleChoice questions.
 * 
 * @author Eros Luce, Clement Bardou, Christelle Lacan, Thierno Bah
 * 
 */
public class MultipleChoice extends Question {

	private String questionText;
	private String format;
	private int defaultGrade;
	private double penalty;
	private boolean hidden;
	private boolean shuffleAnswers;
	private List<Answer> answers = new ArrayList<Answer>();
	private boolean single;
	private String type;
	private String image;
	private String image_64;
	private String correctFeedback;
	private String partiallyCorrectFeedback;
	private String incorrectFeedback;
	private String answerNumbering;

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
	 * @param mCorrectFeedback
	 * @param mPartiallyCorrectFeedback
	 * @param mIncorrectFeedback
	 * @param mAnswerNumbering
	 * @param mSingle
	 */
	public MultipleChoice(String mName, String mQuestionText,
			int mDefaultgrade, double mPenalty, boolean mShuffleanswers,
			boolean mHidden, List<Answer> mAnswers, String mFormat,
			String mImage, String mImage_64, String mCorrectFeedback,
			String mPartiallyCorrectFeedback, String mIncorrectFeedback,
			String mAnswerNumbering, boolean mSingle) {
		super(mName);
		single = mSingle;
		type = "MultipleChoice";
		questionText = mQuestionText;
		format = mFormat;
		defaultGrade = mDefaultgrade;
		penalty = mPenalty;
		hidden = mHidden;
		answers = mAnswers;
		image = mImage;
		image_64 = mImage_64;
		correctFeedback = mCorrectFeedback;
		partiallyCorrectFeedback = mPartiallyCorrectFeedback;
		incorrectFeedback = mIncorrectFeedback;
		answerNumbering = mAnswerNumbering;
	}

	public String toString() {
		return "\n----Ceci est une " + type + " : \n" + super.toString()
				+ "format : " + format + "defaultgrade : " + defaultGrade
				+ "\n" + "penalty : " + penalty + "\n" + "shuffleanswers : "
				+ shuffleAnswers + "\n" + "hidden : " + hidden + "\n"
				+ "correct feedback : " + correctFeedback + "\n"
				+ "partially correct feedback : " + partiallyCorrectFeedback
				+ "\n" + "Single : " + single + "\n" + "incorrect feedback : "
				+ incorrectFeedback + "\n" + "answer numbering : "
				+ answerNumbering + "\n" + "questionsText : " + questionText
				+ "\n" + "image : " + image + "\n" + "image_64 : " + image_64
				+ "\n" + "answers : " + answers.toString() + "\n";
	}
}
