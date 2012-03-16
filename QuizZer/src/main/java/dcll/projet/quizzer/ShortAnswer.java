package dcll.projet.quizzer;

import java.util.List;

/**
 * 
 * @author etu2
 *
 */
public class ShortAnswer extends Question {

	public ShortAnswer(String mName, String mQuestionText, int mDefaultgrade,
			double mPenalty, boolean mShuffleanswers, boolean mHidden,
			List<Answer> mAnswers, String mFormat) {
		super(mName, mQuestionText, mDefaultgrade, mPenalty, mShuffleanswers, mHidden,
				mAnswers, mFormat);
		type = "ShortAnswer";
	}
	
	public String toString(){
		return "\n----Ceci est une shortAnswer : \n"+super.toString();
	}
	
}
