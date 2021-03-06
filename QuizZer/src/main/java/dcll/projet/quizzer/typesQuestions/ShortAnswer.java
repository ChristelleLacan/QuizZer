package dcll.projet.quizzer.typesQuestions;

import java.util.List;

import dcll.projet.quizzer.Question;
import dcll.projet.quizzer.typesQuestions.element.Answer;

/**
 * 
 * @author Eros Luce, Clement Bardou, Christelle Lacan, Thierno Bah
 * 
 */
public class ShortAnswer extends Question {

	private String questiontext;
	private String format;
	private String image;
	private String generalfeedback;
	private int defaultgrade;
	private double penalty;
	private int hidden;
	private int shuffleanswers;
	private int usecase;
	private List<Answer> answers;
	/**
	 * The type
	 */
	private String type;

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
	 * @param mGeneralFeedback
	 */
	
	public ShortAnswer(String mName, String mQuestionText, String mFormat,
			String mImage, String mGeneralFeedback, int mDefaultgrade,
			double mPenalty, int mHidden, int mShuffleanswers,
			int mUsecase, List<Answer> mAnswers) {
		super(mName);
		questiontext = mQuestionText;
		format = mFormat;
		image = mImage;
		generalfeedback = mGeneralFeedback;
		penalty = mPenalty;
		shuffleanswers = mShuffleanswers;
		hidden = mHidden;
		answers = mAnswers;
		type = "ShortAnswer";
	}
	
	/**
	 * toString
	 */

	public String toString() {
		return "\n----Ceci est une shortAnswer : \n" + super.toString()
				+ "questionsText : " + questiontext + "\n"
				+ "generalfeedback: " + generalfeedback + "\n" + "penalty : "
				+ penalty + "\n" + "shuffleanswers : " + shuffleanswers + "\n"
				+ "hidden : " + hidden + "\n" + "answers: " + answers + "\n";
	}

	public String getQuestiontext() {
		return questiontext;
	}

	public String getGeneralfeedback() {
		return generalfeedback;
	}

	public int getDefaultgrade() {
		return defaultgrade;
	}

	public double getPenalty() {
		return penalty;
	}

	public int isHidden() {
		return hidden;
	}

	public int isShuffleanswers() {
		return shuffleanswers;
	}

	public int getUsecase() {
		return usecase;
	}

	public List<Answer> getAnswers() {
		return answers;
	}

	public String getType() {
		return type;
	}

	public String getFormat() {
		return format;
	}

	public String getImage() {
		return image;
	}

}
