package dcll.projet.quizzer;

import java.util.List;

//
//
//  @ Project : QuizZer
//  @ File Name : Description.java
//  @ Date : 15/03/2012
//  @ Author : Eros Luce
//
//

public class Description extends Question {
	
	private String type;
	
	public Description(String mName, String mQuestionText,
			int mDefaultgrade, double mPenalty, boolean mShuffleanswers,
			boolean mHidden, List<Answer> mAnswers, String mFormat) {
		super(mName);
		type="Description";
		// @TODO : ...
	}

	public String toString(){
		return "\n----Ceci est une Description : \n"+super.toString();
	}

}
