package dcll.projet.quizzer;

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
private String quiz ,text, name,question;

	private String questionText,generalfeedback;
	private int defaultgrade;
	private double penalty;
	private boolean shuffleanswers;
	private boolean hidden;
	private String comment;


	public TrueFalse(String mName, String mQuestionText, int mDefaultgrade,
			double mPenalty, boolean mShuffleanswers, boolean mHidden,
			List<Answer> mAnswers, String mFormat) {
		super(mName, mQuestionText, mDefaultgrade, mPenalty, mShuffleanswers, mHidden,
				mAnswers, mFormat);
		type="TrueFalse";
		// TODO Auto-generated constructor stub
	}

	
	public String toString(){
		return "Ceci est : une TrueFalse  \n";
	}
	
	
}
