package dcll.projet.quizzer;

public class Unit {
	private String multiplier;
	private String unitName;
	
	public Unit(String mMultiplier, String mUnitName) {
		multiplier = mMultiplier;
		unitName = mUnitName;
	}
	
	public String toString() {
		return "\n--Unit : " + "\n\t\tUnit Name : " + unitName + "\n\t\tMultiplier : " + multiplier;
	}
}
