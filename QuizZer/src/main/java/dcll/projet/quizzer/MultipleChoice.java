package dcll.projet.quizzer;

import java.util.ArrayList;
import java.util.List;

//
//
//  @ Project : QuizZer
//  @ File Name : MultipleChoice.java
//  @ Date : 05/03/2012
//  @ Author : Clement Bardou
//
//

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
	private String generalfeedback;
	private String correctFeedback;
	private String partiallyCorrectFeedback;
	private String incorrectFeedback;
	private String answerNumbering;

	public MultipleChoice(String mName, String mQuestionText,
			int mDefaultgrade, double mPenalty, boolean mShuffleanswers,
			boolean mHidden, List<Answer> mAnswers, String mFormat,
			String mImage, String mImage_64, String mGeneralfeedback,
			String mCorrectFeedback, String mPartiallyCorrectFeedback,
			String mIncorrectFeedback, String mAnswerNumbering, boolean mSingle) {
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
		generalfeedback = mGeneralfeedback;
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

	public String getType() {
		return type;
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

	public List<Answer> getAnswers() {
		return answers;
	}

	public boolean isSingle() {
		return single;
	}

	public String getImage() {
		return image;
	}

	public String getImage_64() {
		return image_64;
	}

	public String getCorrectFeedback() {
		return correctFeedback;
	}

	public String getPartiallyCorrectFeedback() {
		return partiallyCorrectFeedback;
	}

	public String getIncorrectFeedback() {
		return incorrectFeedback;
	}

	public String getAnswerNumbering() {
		return answerNumbering;
	}

	public String getGeneralfeedback() {
		return generalfeedback;
	}

}
