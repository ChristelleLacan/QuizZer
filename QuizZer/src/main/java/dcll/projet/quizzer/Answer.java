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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public float getFraction() {
		return fraction;
	}

	public void setFraction(float fraction) {
		this.fraction = fraction;
	}

	public String getFeedback() {
		return feedback;
	}

	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
}
