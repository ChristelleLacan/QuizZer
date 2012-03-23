package dcll.projet.quizzer.typesQuestions.element;

/**.
 * This class contains the definition of subQuestions used in matching questions
 *
 * @author Eros Luce, Clement Bardou, Christelle Lacan, Thierno Bah
 *
 */
public class SubQuestion {
	/**
	 * Complement of the answer
	 */
	private String subQuestionName;

	/**.
	 * Name of the answer
	 */
	private String answerName;

	/**.
	 * Constructor :
	 *
	 * @param mSubQuestionName complement of the answer
	 * @param mAnswerName name of the answer
	 */
	public SubQuestion(final String mSubQuestionName,
			final String mAnswerName) {
		subQuestionName = mSubQuestionName;
		answerName = mAnswerName;
	}

	/**.
	 * toString
	 *
	 * @return the format of SubQuestion
	 */
	public final String toString() {
		return "\nSubquestion Name : " + subQuestionName + "\n"
				+ "Answer Name : " + answerName + "\n";
	}

	/**
	 *
	 * @return the complement to answer
	 */
	public final String getSubQuestionName() {
		return subQuestionName;
	}

	/**
	 *
	 * @return answer
	 */
	public final String getAnswerName() {
		return answerName;
	}
	
}
