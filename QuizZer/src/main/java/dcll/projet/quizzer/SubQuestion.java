package dcll.projet.quizzer;

public class SubQuestion {
	private String subQuestionName;
	private String answerName;

	public SubQuestion(String mSubQuestionName, String mAnswerName) {
		subQuestionName = mSubQuestionName;
		answerName = mAnswerName;
	}

	public String toString() {
		return "\nSubquestion Name : " + subQuestionName + "\n" + "Answer Name : "+ answerName+"\n";
	}

	public String getSubQuestionName() {
		return subQuestionName;
	}

	public String getAnswerName() {
		return answerName;
	}
	
}
