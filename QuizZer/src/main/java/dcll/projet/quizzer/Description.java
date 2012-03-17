package dcll.projet.quizzer;


//
//
//  @ Project : QuizZer
//  @ File Name : Description.java
//  @ Date : 15/03/2012
//  @ Author : Eros Luce
//
//

public class Description extends Question {

	private String questionText;
	private String format;
	private int defaultGrade;
	private double penalty;
	private boolean hidden;
	private boolean shuffleAnswers;
	private String type;
	private String image;
	private String image_64;

	public Description(String mName, String mQuestionText, int mDefaultgrade,
			double mPenalty, boolean mShuffleanswers, boolean mHidden,
			String mFormat, String mImage, String mImage_64) {
		super(mName);
		type = "Description";
		questionText = mQuestionText;
		format = mFormat;
		defaultGrade = mDefaultgrade;
		penalty = mPenalty;
		hidden = mHidden;
		image = mImage;
		image_64 = mImage_64;

	}

	public String toString() {
		return "\n----Ceci est : une " + type + "  \n" + super.toString()
				+ "format : " + format + "defaultgrade : " + defaultGrade
				+ "\n" + "penalty : " + penalty + "\n" + "shuffleanswers : "
				+ shuffleAnswers + "\n" + "hidden : " + hidden + "\n"
				+ "questionsText : " + questionText + "\n" + "image : " + image
				+ "\n" + "image_64 : " + image_64;
	}
}