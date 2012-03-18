package dcll.projet.quizzer;

import java.util.ArrayList;
import java.util.List;

//
//
//  @ Project : QuizZer
//  @ File Name : TrueFalse.java
//  @ Date : 05/03/2012
//  @ Author : Clement Bardou
//
//

public class TrueFalse extends Question {

	private String questionText;
	private String format;
	private int defaultGrade;
	private double penalty;
	private boolean hidden;
	private boolean shuffleAnswers;
	private String generalfeedback;
	private List<Answer> answers = new ArrayList<Answer>();
	private String type;
	private String image;
	private String image_64;

	public TrueFalse(String mName, String mQuestionText, int mDefaultgrade,
			double mPenalty, boolean mShuffleanswers, boolean mHidden,
			String mGeneralfeedback, List<Answer> mAnswers, String mFormat,
			String mImage, String mImage_64) {
		super(mName);
		type = "TrueFalse";
		questionText = mQuestionText;
		format = mFormat;
		defaultGrade = mDefaultgrade;
		generalfeedback = mGeneralfeedback;
		penalty = mPenalty;
		hidden = mHidden;
		answers = mAnswers;
		image = mImage;
		image_64 = mImage_64;
	}

	public String toString() {
		return "\n----Ceci est : une " + type + "  \n" + super.toString()
				+ "format : " + format + "defaultgrade : " + defaultGrade
				+ "\n" + "penalty : " + penalty + "\n" + "shuffleanswers : "
				+ shuffleAnswers + "\n" + "hidden : " + hidden + "\n"
				+ "questionsText : " + questionText + "\n" + "image : " + image
				+ "\n" + "image_64 : " + image_64 + "\n" + "answers : "
				+ answers.toString() + "\n";
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

	public List<Answer> getAnswers() {
		return answers;
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

}
