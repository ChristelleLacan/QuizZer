package dcll.projet.quizzer;

/**
 * This class contains the definition of an abstract question.
 * 
 * @author Eros Luce, Clement Bardou, Christelle Lacan, Thierno Bah
 * 
 */
public abstract class Question {
	/**
	 * Name of the question.
	 */
	private String name;

	/**
	 * Contructor.
	 * 
	 * @param mName
	 *            : Name of the question
	 */
	public Question(final String mName) {
		name = mName;
	}

	/**
	 * @return the name
	 */
	public final String getName() {
		return name;
	}

	/**
	 * @param mName the name
	 */
	public final void setName(final String mName) {
		this.name = mName;
	}

	/**
	 * @return a string
	 */
	public String toString() {
		return "name : " + name + "\n";
	}

}
