package dcll.projet.quizzer;

import java.util.List;

/**
 * 
 * @author etu2
 * 
 */
public class ShortAnswer extends Question {

	private String questiontext;
	private String format;
	private String image;
	private String generalfeedback;
	private int defaultgrade;
	private double penalty;
	private boolean hidden;
	private boolean shuffleanswers;
	private int usecase;
	private List<Answer> answers;
	private String type;

	public ShortAnswer(String mName, String mQuestionText, String mFormat,
			String mImage, String mGeneralFeedback, int mDefaultgrade,
			double mPenalty, boolean mHidden, boolean mShuffleanswers,
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

	public boolean isHidden() {
		return hidden;
	}

	public boolean isShuffleanswers() {
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
