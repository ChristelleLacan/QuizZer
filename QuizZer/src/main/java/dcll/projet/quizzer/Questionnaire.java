package dcll.projet.quizzer;

import java.util.ArrayList;

/**
 * This class contains the definition of a Questionary
 * 
 * @author Eros Luce, Clement Bardou, Christelle Lacan, Thierno Bah
 * 
 */
public class Questionnaire {
	private String quizName;
	private String racine;
	private ArrayList<Question> questions = new ArrayList<Question>();

	/**
	 * Constructor :
	 * 
	 * @param quizName
	 * @param questions
	 */
	public Questionnaire(String quizName, ArrayList<Question> questions, String racine) {
		this.quizName = quizName;
		this.questions = questions;
		this.racine = racine;
	}

	public ArrayList<Question> getQuestions() {
		return questions;
	}

	
	public String getRacine() {
		return racine;
	}

	/**
	 * toString
	 */
	public String toString() {
		return "Quiz name : " + quizName + " \n\nQuestions : \n"
				+ questions.toString();
	}

}
