package dcll.projet.quizzer.typesQuestions.element;

/**.
 * This class contains definition of DatasetItem used in DatasetDefinition
 *
 * @author Eros Luce, Clement Bardou, Christelle Lacan, Thierno Bah
 *
 */
public class DatasetItem {
	private String value;
	private String number;

	/**.
	 * Contructor :
	 *
	 * @param mValue
	 * @param mNumber
	 */
	public DatasetItem(final String mValue, final String mNumber) {
		value = mValue;
		number = mNumber;
	}

	/**.
	 * toString
	 * @return format to DatasetItem
	 */
	public final String toString() {
		return "\n--Dataset Item : " + "\n\t\tValue : " + value
				+ "\n\t\tNumber : " + number;
	}

	public String getValue() {
		return value;
	}

	public String getNumber() {
		return number;
	}
}
