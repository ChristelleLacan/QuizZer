package dcll.projet.quizzer;

import java.util.ArrayList;
import java.util.List;

/**
 * This class contains definition of Numerical questions.
 * 
 * @author Eros Luce, Clement Bardou, Christelle Lacan, Thierno Bah
 * 
 */
public class Numerical extends Question {

	private String questionText;
	private String format;
	private int defaultGrade;
	private double penalty;
	private boolean hidden;
	private boolean shuffleAnswers;
	private List<Answer> answers = new ArrayList<Answer>();
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
	public Numerical(String mName, String mQuestionText, int mDefaultgrade,
			double mPenalty, boolean mShuffleanswers, boolean mHidden,
			List<Answer> mAnswers, String mFormat, String mImage,
			String mImage_64) {
		super(mName);
		questionText = mQuestionText;
		format = mFormat;
		defaultGrade = mDefaultgrade;
		penalty = mPenalty;
		hidden = mHidden;
		answers = mAnswers;
		image = mImage;
		image_64 = mImage_64;
		type = "Numerical";
	}

	/**
	 * toString
	 */
	public String toString() {
		return "\n----Ceci est : une " + type + "  \n" + super.toString()
				+ "format : " + format + "\n" + "defaultgrade : "
				+ defaultGrade + "\n" + "penalty : " + penalty + "\n"
				+ "shuffleanswers : " + shuffleAnswers + "\n" + "hidden : "
				+ hidden + "\n" + "questionsText : " + questionText + "\n"
				+ "image : " + image + "\n" + "image_64 : " + image_64 + "\n"
				+ "answers : " + answers.toString() + "\n";
	}

}

