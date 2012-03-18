package dcll.projet.quizzer;

import java.util.ArrayList;
import java.util.List;

/**
 * This class contains definition of Matching questions
 * 
 * @author Eros Luce, Clement Bardou, Christelle Lacan, Thierno Bah
 * 
 */
public class Matching extends Question {

	private String questionText;
	private String format;
	private int defaultGrade;
	private double penalty;
	private boolean hidden;
	private boolean shuffleAnswers;
	private String generalfeedback;
	private String type;
	private String image;
	private String image_64;
	private List<SubQuestion> subQuestions = new ArrayList<SubQuestion>();

	/**
	 * Constructor :
	 * 
	 * @param mName
	 * @param mQuestionText
	 * @param mDefaultgrade
	 * @param mPenalty
	 * @param mShuffleanswers
	 * @param mHidden
	 * @param mFormat
	 * @param mImage
	 * @param mImage_64
	 * @param mSubQuestions
	 */
	public Matching(String mName, String mQuestionText, int mDefaultgrade,
			double mPenalty, boolean mShuffleanswers, boolean mHidden,
			String mFormat, String mGeneralfeedback, String mImage,
			String mImage_64, List<SubQuestion> mSubQuestions) {
		super(mName);
		type = "Matching";
		questionText = mQuestionText;
		format = mFormat;
		defaultGrade = mDefaultgrade;
		penalty = mPenalty;
		hidden = mHidden;
		generalfeedback = mGeneralfeedback;
		image = mImage;
		image_64 = mImage_64;
		subQuestions = mSubQuestions;
	}

	/**
	 * toString
	 */
	public String toString() {
		return "\n----Ceci est : une " + type + "  \n" + super.toString()
				+ "format : " + format + "defaultgrade : " + defaultGrade
				+ "\n" + "penalty : " + penalty + "\n" + "shuffleanswers : "
				+ shuffleAnswers + "\n" + "hidden : " + hidden + "\n"
				+ "questionsText : " + questionText + "\n" + "image : " + image
				+ "\n" + "image_64 : " + image_64 + "\nsubQuestions : "
				+ subQuestions.toString() + "\n";
	}

	public String getGeneralfeedback() {
		return generalfeedback;
	}

	public String getQuestionText() {
		return questionText;
	}

	public String getFormat() {
		return format;
	}

	public int getDefaultGrade() {
		return defaultGrade;
	}

	public double getPenalty() {
		return penalty;
	}

	public boolean isHidden() {
		return hidden;
	}

	public boolean isShuffleAnswers() {
		return shuffleAnswers;
	}

	public String getType() {
		return type;
	}

	public String getImage() {
		return image;
	}

	public String getImage_64() {
		return image_64;
	}

	public List<SubQuestion> getSubQuestions() {
		return subQuestions;
	}

}
