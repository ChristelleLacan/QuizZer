package dcll.projet.quizzer;

/**
 * This class contains the definition of subQuestions used in matching questions
 * 
 * @author Eros Luce, Clement Bardou, Christelle Lacan, Thierno Bah
 * 
 */
public class SubQuestion {
	private String subQuestionName;
	private String answerName;

	/**
	 * Constructor :
	 * 
	 * @param mSubQuestionName
	 * @param mAnswerName
	 */
	public SubQuestion(String mSubQuestionName, String mAnswerName) {
		subQuestionName = mSubQuestionName;
		answerName = mAnswerName;
	}

	/**
	 * toString
	 */
	public String toString() {
		return "\nSubquestion Name : " + subQuestionName + "\n"
				+ "Answer Name : " + answerName + "\n";
	}
}
