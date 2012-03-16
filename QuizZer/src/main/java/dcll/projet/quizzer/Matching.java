package dcll.projet.quizzer;

import java.util.ArrayList;
import java.util.List;
//
//  @ Project : QuizZer
//  @ File Name : Matching.java
//  @ Date : 05/03/2012
//  @ Author : Clement Bardou
//
//

public class Matching extends Question {

	private String questionText;
	private String format;
	private int defaultGrade;
	private double penalty;
	private boolean hidden;
	private boolean shuffleAnswers;
	private String type;
	private String image;
	private String image_64;
	private List<SubQuestion> subQuestions = new ArrayList<SubQuestion>();

	public Matching(String mName, String mQuestionText, int mDefaultgrade,
			double mPenalty, boolean mShuffleanswers, boolean mHidden,
			String mFormat, String mImage, String mImage_64,
			List<SubQuestion> mSubQuestions) {
		super(mName);
		type = "Matching";
		questionText = mQuestionText;
		format = mFormat;
		defaultGrade = mDefaultgrade;
		penalty = mPenalty;
		hidden = mHidden;
		image = mImage;
		image_64 = mImage_64;
		subQuestions = mSubQuestions;
	}

	public String toString() {
		return "\n----Ceci est : une "+ type +"  \n" + super.toString()
				+ "format : " + format + "defaultgrade : " + defaultGrade
				+ "\n" + "penalty : " + penalty + "\n" + "shuffleanswers : "
				+ shuffleAnswers + "\n" + "hidden : " + hidden + "\n"
				+ "questionsText : " + questionText + "\n" + "image : " + image
				+ "\n" + "image_64 : " + image_64 + "\nsubQuestions : "
				+ subQuestions.toString() + "\n";
	}
}
