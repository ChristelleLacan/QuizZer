package dcll.projet.quizzer;
//
//
//  @ Project : QuizZer
//  @ File Name : NumericalReponse.java
//  @ Date : 05/03/2012
//  @ Author : Clement Bardou
//
//


public class NumericalReponse extends Question {
	
	private String text;
	private String name;
	private String questionText;
	private int defaultgrade;
	private double penalty;
	private boolean shuffleanswers;
	private boolean hidden;
	private String comment;
	private String type;
	
	public NumericalReponse(String mtype) {
		super();
		this.type=mtype;
	}
	
	public double getPenalty() {
		return penalty;
	}
	
	public int getDefaultgrade() {
		return defaultgrade;
	}
	
	public boolean isHidden() {
		return hidden;
	}
	
	public String getComment() {
		return comment;
	}
	
	public String getText() {
		return text;
	}
}
