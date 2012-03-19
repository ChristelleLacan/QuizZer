package dcll.projet.quizzer.typesQuestions.element;

/**
 * This class contains definition of DatasetItem used in DatasetDefinition
 * 
 * @author Eros Luce, Clement Bardou, Christelle Lacan, Thierno Bah
 * 
 */
public class DatasetItem {
	private String value;
	private String number;

	/**
	 * Contructor :
	 * 
	 * @param mValue
	 * @param mNumber
	 */
	public DatasetItem(String mValue, String mNumber) {
		value = mValue;
		number = mNumber;
	}

	/**
	 * toString
	 */
	public String toString() {
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
