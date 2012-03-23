package dcll.projet.quizzer.typesQuestions;

import dcll.projet.quizzer.Question;

/**
 * This class contains definition of Categoty Questions.
 *
 * @author Eros Luce, Clement Bardou, Christelle Lacan, Thierno Bah
 *
 */
public class Category extends Question {

	/**
	 * The category name.
	 */
	private String category;
	/**
	 * The type : category.
	 */
	private String type;
	/**
	 * the name.
	 */
	private static String name;

	/**
	 * Constructor.
	 *
	 * @param cText the category text
	 */
	public Category(final String cText) {
		super(name);
		category = cText;
		type = "category";
	}

	/**
	 * @return a string
	 */
	public final String toString() {
		return "\n----Ceci est une " + type + " : \n" + "category : "
				+ category + "\n";
	}

	/**
	 * @return the category text
	 */
	public final String getCategory() {
		return category;
	}

	/**
	 * @return the category type
	 */
	public final String getType() {
		return type;
	}

}
