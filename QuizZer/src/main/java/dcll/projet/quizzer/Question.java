package dcll.projet.quizzer;

//
//  @ Project : QuizZer
//  @ File Name : Question.java
//  @ Date : 05/03/2012
//  @ Author : Clement Bardou
//
//
import java.util.List;




public class Question {
	private String name;
	private String questionText;
	private int defaultgrade;
	private double penalty;
	private boolean shuffleanswers;
	private boolean hidden;
	private List<Answer> answers;
	protected String type;
	private String format;
	
	public Question(String mName, String mQuestionText,int mDefaultgrade,double mPenalty,boolean mShuffleanswers,boolean mHidden,List<Answer> mAnswers, String mFormat){
		name = mName;
		questionText = mQuestionText;
		defaultgrade = mDefaultgrade;
		penalty = mPenalty;
		shuffleanswers = mShuffleanswers;
		hidden = mHidden;
		answers = mAnswers;
		format = mFormat;
	}
	
	public String toString(){
		return "name : "+name+"\n"+
				"questionsText : "+questionText+"\n"+
				"defaultgrade : "+defaultgrade+"\n"+
				"penalty : "+penalty+"\n"+
				"shuffleanswers : "+shuffleanswers+"\n"+
				"hidden : "+hidden+"\n"+
				"answers : "+ answers.toString()+"\n"+
				"format : "+format;
	}
}
