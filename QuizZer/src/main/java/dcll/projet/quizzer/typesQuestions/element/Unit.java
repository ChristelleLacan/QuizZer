package dcll.projet.quizzer.typesQuestions.element;

/**
 * This class contains the definition of Unit used in Calculated questions.
 *
 * @author Eros Luce, Clement Bardou, Christelle Lacan, Thierno Bah
 *
 */
public class Unit {

	/**.
	 * the multiplier factor of the unit.
	 */
	private String multiplier;
	/**
	 * The name of the unit.
	 */
	private String unitName;

	/**
	 * Constructor.
	 *
	 * @param mMultiplier the multiplier factor
	 * @param mUnitName the unit name
	 */
	public Unit(final String mMultiplier, final String mUnitName) {
		multiplier = mMultiplier;
		unitName = mUnitName;
	}

	/**
	 * @return String
	 */
	public final String toString() {
		return "\n--Unit : " + "\n\t\tUnit Name : " + unitName
				+ "\n\t\tMultiplier : " + multiplier;
	}

	/**
	 * Getter Multiplier.
	 *
	 * @return multiplier
	 */
	public final String getMultiplier() {
		return multiplier;
	}

	/**.
	 * Getter unitName
	 *
	 * @return unitName
	 */
	public final String getUnitName() {
		return unitName;
	}

}
