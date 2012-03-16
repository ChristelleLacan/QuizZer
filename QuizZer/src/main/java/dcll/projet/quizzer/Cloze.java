package dcll.projet.quizzer;

public class Cloze extends Question {

	private String questiontext;
	private boolean shuffleanswers;
	private String type;

	public Cloze(String mName, String mQuestionText, boolean mShuffleanswers) {
		super(mName);
		questiontext = mQuestionText;
		shuffleanswers = mShuffleanswers;
		type = "Cloze";
	}

	public String toString() {
		return "\n----Ceci est une " + type + " : \n" + super.toString()
				+ "questionsText : " + questiontext + "\n"
				+ "shuffleanswers : " + shuffleanswers + "\n";

	}
}
