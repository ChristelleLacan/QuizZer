package dcll.projet.quizzer;

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


	public MultipleChoice(String mName, String mQuestionText,
			int mDefaultgrade, double mPenalty, boolean mShuffleanswers,
			boolean mHidden, List<Answer> mAnswers, String mFormat) {
		super(mName, mQuestionText, mDefaultgrade, mPenalty, mShuffleanswers,
				mHidden, mAnswers, mFormat);
		type="MultipleChoice";
		// TODO Auto-generated constructor stub
	}
	
	public String toString(){
		return "Ceci est : une MultipleChoice  \n";
	}

}
