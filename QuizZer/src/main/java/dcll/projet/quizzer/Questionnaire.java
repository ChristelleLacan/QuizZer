package dcll.projet.quizzer;

import java.util.List;
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
	private List<Question> questions;
	
	public Questionnaire(String quizName,List<Question> questions) {
		this.quizName=quizName;
		this.questions=questions;
	}
}
