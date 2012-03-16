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
	private String type;
	private String image;
	private String image_64;
	private String correctFeedback;
	private String partiallyCorrectFeedback;
	private String incorrectFeedback;
	private String answerNumbering;

	public MultipleChoice(String mName, String mQuestionText,
			int mDefaultgrade, double mPenalty, boolean mShuffleanswers,
			boolean mHidden, List<Answer> mAnswers, String mFormat,
			String mImage, String mImage_64, String mCorrectFeedback,
			String mPartiallyCorrectFeedback, String mIncorrectFeedback,
			String mAnswerNumbering) {
		super(mName);
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
		return "\n----Ceci est une MultipleChoice : \n" + super.toString()
				+ "format : " + format + "defaultgrade : " + defaultGrade
				+ "\n" + "penalty : " + penalty + "\n" + "shuffleanswers : "
				+ shuffleAnswers + "\n" + "hidden : " + hidden + "\n"
				+ "questionsText : " + questionText + "\n" + "image : " + image
				+ "\n" + "answers : " + answers.toString() + "\n";
	}
}
