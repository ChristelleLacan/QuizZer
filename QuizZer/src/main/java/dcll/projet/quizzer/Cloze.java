package dcll.projet.quizzer;

public class Cloze extends Question {

	private String questiontext;
	private boolean shuffleanswers;
	private String type;
	private String generalfeedback;

	public Cloze(String mName, String mQuestionText, boolean mShuffleanswers,
			String mGeneralfeedback) {
		super(mName);
		questiontext = mQuestionText;
		shuffleanswers = mShuffleanswers;
		generalfeedback = mGeneralfeedback;
		type = "Cloze";
	}

	public String toString() {
		return "\n----Ceci est une " + type + " : \n" + super.toString()
				+ "questionsText : " + questiontext + "\n"
				+ "shuffleanswers : " + shuffleanswers + "\n";

	}

	public String getGeneralfeedback() {
		return generalfeedback;
	}

	public String getType() {
		return type;
	}

	public String getQuestiontext() {
		return questiontext;
	}

	public boolean isShuffleanswers() {
		return shuffleanswers;
	}

}
