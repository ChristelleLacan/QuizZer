package dcll.projet.quizzer;

/**
 * This class contains the definition of Cloze Questions
 * 
 * @author Eros Luce, Clement Bardou, Christelle Lacan, Thierno Bah
 * 
 */
public class Cloze extends Question {

	private String questiontext;
	private int shuffleanswers;
	private String type;
	private String generalfeedback;

	/**
	 * Constructor :
	 * 
	 * @param mName
	 * @param mQuestionText
	 * @param mShuffleanswers
	 */
	public Cloze(String mName, String mQuestionText, int mShuffleanswers,
			String mGeneralfeedback) {
		super(mName);
		questiontext = mQuestionText;
		shuffleanswers = mShuffleanswers;
		generalfeedback = mGeneralfeedback;
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

	public String getGeneralfeedback() {
		return generalfeedback;
	}

	public String getType() {
		return type;
	}

	public String getQuestiontext() {
		return questiontext;
	}

	public int isShuffleanswers() {
		return shuffleanswers;
	}

}
