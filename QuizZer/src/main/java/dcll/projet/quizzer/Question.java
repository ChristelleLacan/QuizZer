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
	 * @param mName : Name of the question
	 */
	public Question(final String mName) {
		name = mName;
	}

	/**
	 * Getters.
	 * @return the name
	 */
	public final String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


	/**
	 * toString
	 */
	public String toString() {
		return "name : " + name + "\n";
	}

}
