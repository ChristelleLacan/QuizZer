package dcll.projet.quizzer.typesQuestions;

import dcll.projet.quizzer.Question;

/**
 * This class contains definition of Categoty Questions
 * 
 * @author Eros Luce, Clement Bardou, Christelle Lacan, Thierno Bah
 * 
 */
public class Category extends Question {

	private String category;
	private String type;
	private static String name;

	/**
	 * Constructor :
	 * 
	 * @param Ctext
	 */
	public Category(String Ctext) {
		super(name);
		category = Ctext;
		type = "category";
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

	public String getType() {
		return type;
	}

	public String getName() {
		return name;
	}

	
}
