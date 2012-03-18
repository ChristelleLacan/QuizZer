package dcll.projet.quizzer;

/**
 * This class contains the definition of an abstract question
 * 
 * @author Eros Luce, Clement Bardou, Christelle Lacan, Thierno Bah
 * 
 */
public abstract class Question {
	private String name;

	/**
	 * Contructor :
	 * 
	 * @param mName
	 */
	public Question(String mName) {
		name = mName;
	}

	public String getName() {
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
