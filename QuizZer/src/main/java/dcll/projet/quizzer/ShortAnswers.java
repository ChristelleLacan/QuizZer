package dcll.projet.quizzer;

import java.util.List;

/**
 * 
 * @author etu2
 *
 */
public class ShortAnswer extends Question {
	
	private String questiontext;
	private String generalfeedback;
	private int defaultgrade;
	private double penalty;
	private boolean hidden;
	private boolean shuffleanswers;
	private int usecase;
	private Answer answers;
	private String type;

	public ShortAnswer(String mName, String mQuestionText,String mGeneralFeedback, int mDefaultgrade,
			double mPenalty, boolean mHidden,boolean mShuffleanswers, int mUsecase, 
			Answer mAnswers) {
		super(mName);
		questiontext=mQuestionText;
		generalfeedback=mDefaultgrade;
		penalty=mPenalty;
		shuffleanswers=mShuffleanswers;
		hidden=mHidden;
	    answers=mAnswers;
		type = "ShortAnswer";
	}
	
	public String toString(){
		return "\n----Ceci est une shortAnswer : \n"+super.toString()+
				"questionsText : "+questiontext+"\n"+
				"generalfeedback: "+generalfeedback+"\n"+
				"penalty : "+penalty+"\n"+
				"shuffleanswers : "+shuffleanswers+"\n"+
				"hidden : "+hidden+"\n"+
				"answers: "+answers+"\n";
	}
	
}
