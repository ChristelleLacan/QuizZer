package dcll.projet.quizzer;

//
//  @ Project : QuizZer
//  @ File Name : Question.java
//  @ Date : 05/03/2012
//  @ Author : Clement Bardou
//
//

public abstract class  Question {
	private String name;

	public Question(String mName) {
		name = mName;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String toString(){
		return "name : "+name+"\n";
	}

}
