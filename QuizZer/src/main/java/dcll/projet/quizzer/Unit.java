package dcll.projet.quizzer;

/**
 * This class contains the definition of Unit used in Calculated questions
 * 
 * @author Eros Luce, Clement Bardou, Christelle Lacan, Thierno Bah
 * 
 */
public class Unit {
	private String multiplier;
	private String unitName;

	/**
	 * Constructor :
	 * 
	 * @param mMultiplier
	 * @param mUnitName
	 */
	public Unit(String mMultiplier, String mUnitName) {
		multiplier = mMultiplier;
		unitName = mUnitName;
	}

	/**
	 * toString
	 */
	public String toString() {
		return "\n--Unit : " + "\n\t\tUnit Name : " + unitName
				+ "\n\t\tMultiplier : " + multiplier;
	}
}
