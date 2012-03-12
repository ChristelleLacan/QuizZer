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
			List<Answer> mAnswers) {
		super(mName, mQuestionText, mDefaultgrade, mPenalty, mShuffleanswers, mHidden,
				mAnswers);
		type = "ShortAnswer";
	}
	
}
