package dcll.projet.quizzer;

/**
 * This class contains definition of Categoty Questions
 * 
 * @author Eros Luce, Clement Bardou, Christelle Lacan, Thierno Bah
 * 
 */
public class Category extends Question {

	private String category;
	private String type;
	private static String name = "Category";

	/**
	 * Constructor :
	 * 
	 * @param Ctext
	 */
	public Category(String Ctext) {
		super(name);
		category = Ctext;
		type = "Category";
	}

	/**
	 * toString
	 */
	public String toString() {
		return "\n----Ceci est une " + type + " : \n" + "category : "
				+ category + "\n";
	}

	public String getCategory() {
		return category;
	}

}
