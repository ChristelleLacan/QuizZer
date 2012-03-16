package dcll.projet.quizzer;

public class Cloze extends Question{
	
	private String questiontext;
	private String generalfeedback;
	private boolean shuffleanswers;
	private String type;
	
	public Cloze(String mName, String mQuestionText,String mGeneralFeedback,
			boolean mShuffleanswers) {
		
		super(mName);
		questiontext=mQuestionText;
		generalfeedback=mGeneralFeedback;
		
		shuffleanswers=mShuffleanswers;
		
		type="Cloze";
	
	}

	public String toString(){
		return "\n----Ceci est une Description : \n"+super.toString()+
				"questionsText : "+questiontext+"\n"+
				"generalfeedback : "+generalfeedback+"\n"+
				"shuffleanswers : "+shuffleanswers+"\n";
				
	}
}
