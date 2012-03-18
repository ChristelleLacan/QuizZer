package dcll.projet.quizzer;

/**
 * This class contains the definition of Cloze Questions
 * 
 * @author Eros Luce, Clement Bardou, Christelle Lacan, Thierno Bah
 * 
 */
public class Cloze extends Question {

	private String questiontext;
	private boolean shuffleanswers;
	private String type;

	/**
	 * Constructor :
	 * 
	 * @param mName
	 * @param mQuestionText
	 * @param mShuffleanswers
	 */
	public Cloze(String mName, String mQuestionText, boolean mShuffleanswers) {
		super(mName);
		questiontext = mQuestionText;
		shuffleanswers = mShuffleanswers;
		type = "Cloze";
	}

	/**
	 * toString
	 */
	public String toString() {
		return "\n----Ceci est une " + type + " : \n" + super.toString()
				+ "questionsText : " + questiontext + "\n"
				+ "shuffleanswers : " + shuffleanswers + "\n";

	}
}
