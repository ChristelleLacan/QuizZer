package dcll.projet.quizzer;

import java.util.List;
//
//  @ Project : QuizZer
//  @ File Name : Matching.java
//  @ Date : 05/03/2012
//  @ Author : Clement Bardou
//
//




public class Matching extends Question {

	public Matching(String mName, String mQuestionText, int mDefaultgrade,
			double mPenalty, boolean mShuffleanswers, boolean mHidden,
			List<Answer> mAnswers, String mFormat) {
		super(mName, mQuestionText, mDefaultgrade, mPenalty, mShuffleanswers, mHidden,
				mAnswers, mFormat);
		type="Matching";
		// TODO Auto-generated constructor stub
	}
	
	public String toString(){
		return "\n----Ceci est : une Matching  \n"+super.toString();
	}
}
