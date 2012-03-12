package dcll.projet.quizzer;

import java.util.List;
//
//
//  @ Project : QuizZer
//  @ File Name : Essay.java
//  @ Date : 05/03/2012
//  @ Author : Clement Bardou
//
//




public class Essay extends Question {

	public Essay(String mName, String mQuestionText, int mDefaultgrade,
			double mPenalty, boolean mShuffleanswers, boolean mHidden,
			List<Answer> mAnswers, String mFormat) {
		super(mName, mQuestionText, mDefaultgrade, mPenalty, mShuffleanswers, mHidden,
				mAnswers, mFormat);
		
	}
}
