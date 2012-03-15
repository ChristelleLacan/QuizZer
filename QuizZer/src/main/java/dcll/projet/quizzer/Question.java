package dcll.projet.quizzer;

//
//  @ Project : QuizZer
//  @ File Name : Question.java
//  @ Date : 05/03/2012
//  @ Author : Clement Bardou
//
//
import java.util.List;

public abstract class  Question {
	private String name;
	private String questionText;
	private int defaultgrade;
	private double penalty;
	private boolean shuffleanswers;
	private boolean hidden;
	private List<Answer> answers;
	protected String type;
	private String format;

	@SuppressWarnings("unused")
	private List<TrueFalse> truefalse;
	public List<TrueFalse> getTruefalse() {
		return truefalse;
	}

	public void setTruefalse(List<TrueFalse> truefalse) {
		this.truefalse = truefalse;
	}


	public Question(String mName, String mQuestionText, int mDefaultgrade,
			double mPenalty, boolean mShuffleanswers, boolean mHidden,
			List<Answer> mAnswers, String mFormat) {
		name = mName;
		questionText = mQuestionText;
		defaultgrade = mDefaultgrade;
		penalty = mPenalty;
		shuffleanswers = mShuffleanswers;
		hidden = mHidden;
		answers = mAnswers;
		format = mFormat;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getDefaultgrade() {
		return defaultgrade;
	}

	public void setDefaultgrade(int defaultgrade) {
		this.defaultgrade = defaultgrade;
	}

	public List<Answer> getAnswers() {
		return answers;
	}

	public void setAnswers(List<Answer> answers) {
		this.answers = answers;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Question() {
		// TODO Auto-generated constructor stub

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
