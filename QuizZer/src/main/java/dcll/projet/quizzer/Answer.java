package dcll.projet.quizzer;

public class Answer {
	private String type;
	private String question;

	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	private String text;
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public int getFraction() {
		return fraction;
	}
	public void setFraction(int fraction) {
		this.fraction = fraction;
	}
	public String getFeedback() {
		return feedback;
	}
	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
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
