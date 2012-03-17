package dcll.projet.quizzer;

public class DatasetItem {
	private String value;
	private String number;

	public DatasetItem(String mValue, String mNumber) {
		value = mValue;
		number = mNumber;
	}

	public String toString() {
		return "\n--Dataset Item : " + "\n\t\tValue : " + value
				+ "\n\t\tNumber : " + number;
	}
}
