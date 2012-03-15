package dcll.projet.quizzer;

public class Answer {

	private String text;
	private int fraction;
	private String feedback;
	
	public Answer(String text, int fraction, String feedback) {
		this.text = text;
		this.fraction = fraction;
		this.feedback = feedback;
	}
	
	public String toString(){
		return "Text : "+ text + 
				"\t Fraction : "+fraction + 
				"\t Feedback : "+feedback;
	}
}
