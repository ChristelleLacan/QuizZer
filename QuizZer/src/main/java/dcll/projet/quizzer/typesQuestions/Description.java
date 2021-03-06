package dcll.projet.quizzer.typesQuestions;

import java.util.ArrayList;

import dcll.projet.quizzer.Question;
import dcll.projet.quizzer.typesQuestions.element.Answer;
import dcll.projet.quizzer.typesQuestions.element.Unit;

/**
 * This class contains definition of Description questions
 * 
 * @author Eros Luce, Clement Bardou, Christelle Lacan, Thierno Bah
 * 
 */
public class Description extends Question {

	private String questionText;
	private String format;
	private int defaultGrade;
	private double penalty;
	private int hidden;
	private int shuffleAnswers;
	/**
	 * The type
	 */
	private String type;
	private String image;
	private String image_64;
	private String generalfeedback;


	private ArrayList<Answer> answers = new ArrayList<Answer>();
	private ArrayList<Unit> units = new ArrayList<Unit>();


	/**
	 * Constructor :
	 * @param mName
	 * @param mQuestionText
	 * @param mGeneralfeedback
	 * @param mDefaultgrade
	 * @param mPenalty
	 * @param mShuffleanswers
	 * @param mHidden
	 * @param mFormat
	 * @param mImage
	 * @param mImage_64
	 */
	public Description(String mName, String mQuestionText,
			String mGeneralfeedback, int mDefaultgrade, double mPenalty,
			int mShuffleanswers, int mHidden, String mFormat,
			String mImage, String mImage_64) {
		super(mName);
		type = "Description";
		questionText = mQuestionText;
		generalfeedback = mGeneralfeedback;
		format = mFormat;
		defaultGrade = mDefaultgrade;
		penalty = mPenalty;
		hidden = mHidden;
		shuffleAnswers = mShuffleanswers;
		image = mImage;
		image_64 = mImage_64;

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
				+ "\n" + "image_64 : " + image_64;
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

	public int getHidden() {
		return hidden;
	}

	public int getShuffleAnswers() {
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

	public ArrayList<Answer> getAnswers() {
		return answers;
	}

	public ArrayList<Unit> getUnits() {
		return units;
	}

}
