package dcll.projet.quizzer;

import java.util.ArrayList;
//
//
//  @ Project : QuizZer
//  @ File Name : Questionnaire.java
//  @ Date : 05/03/2012
//  @ Author : Clement Bardou
//
//

public class Questionnaire {
	private String quizName;
	private ArrayList<Question> questions = new ArrayList<Question>();

	public Questionnaire(String quizName, ArrayList<Question> questions) {
		this.quizName = quizName;
		this.questions = questions;
	}

	public ArrayList<Question> getQuestions() {
		return questions;
	}
	
	public String toString() {
		return "Quiz name : "+quizName +" \n\nQuestions : \n"+questions.toString();
	}
	

}
