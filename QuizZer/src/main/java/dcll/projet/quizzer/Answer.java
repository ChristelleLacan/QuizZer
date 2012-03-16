package dcll.projet.quizzer;

public class Answer {
	private String type;
	private String question;
	private float fraction;
	private String feedback;
	private String text;
	
	public Answer(String text, float fraction, String feedback) {
		this.text = text;
		this.fraction = fraction;
		this.feedback = feedback;
	}
	
	public String toString(){
		return "\n--Text : "+ text + 
				"\t Fraction : "+fraction + 
				"\t Feedback : "+feedback;
	}
}
