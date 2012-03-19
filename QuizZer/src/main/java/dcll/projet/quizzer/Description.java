package dcll.projet.quizzer;

import java.util.ArrayList;

/**
 * This class contains definition of Description questions
 * 
 * @author Eros Luce, Clement Bardou, Christelle Lacan, Thierno Bah
 * 
 */
public class Description extends Question {

	public String getQuestionText() {
		return questionText;
	}

	public void setQuestionText(String questionText) {
		this.questionText = questionText;
	}

	public String getFormat() {
		return format;
	}

	public void setFormat(String format) {
		this.format = format;
	}

	public int getDefaultGrade() {
		return defaultGrade;
	}

	public void setDefaultGrade(int defaultGrade) {
		this.defaultGrade = defaultGrade;
	}

	public double getPenalty() {
		return penalty;
	}

	public void setPenalty(double penalty) {
		this.penalty = penalty;
	}

	public boolean isHidden() {
		return hidden;
	}

	public void setHidden(boolean hidden) {
		this.hidden = hidden;
	}

	public boolean isShuffleAnswers() {
		return shuffleAnswers;
	}

	public void setShuffleAnswers(boolean shuffleAnswers) {
		this.shuffleAnswers = shuffleAnswers;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getImage_64() {
		return image_64;
	}

	public void setImage_64(String image_64) {
		this.image_64 = image_64;
	}

	private String questionText;
	private String format;
	private int defaultGrade;
	private double penalty;
	private boolean hidden;
	private boolean shuffleAnswers;
	private String type;
	private String image;
	private String image_64;
	private String generalfeedback;
	private ArrayList<Answer> answers = new ArrayList<Answer>();
	private ArrayList<Unit> units = new ArrayList<Unit>();

	public ArrayList<Answer> getAnswers() {
		return answers;
	}

	public void setAnswers(ArrayList<Answer> answers) {
		this.answers = answers;
	}

	public ArrayList<Unit> getUnits() {
		return units;
	}

	public void setUnits(ArrayList<Unit> units) {
		this.units = units;
	}

	public String getGeneralfeedback() {
		return generalfeedback;
	}

	public void setGeneralfeedback(String generalfeedback) {
		this.generalfeedback = generalfeedback;
	}

	/**
	 * Constructor :
	 * 
	 * @param mName
	 * @param mQuestionText
	 * @param mDefaultgrade
	 * @param mPenalty
	 * @param mShuffleanswers
	 * @param mHidden
	 * @param mFormat
	 * @param mImage
	 * @param mImage_64
	 */
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

	/**
	 * toString
	 */
	public String toString() {
		return "\n----Ceci est : une " + type + "  \n" + super.toString()
				+ "format : " + format + "defaultgrade : " + defaultGrade
				+ "\n" + "penalty : " + penalty + "\n" + "shuffleanswers : "
				+ shuffleAnswers + "\n" + "hidden : " + hidden + "\n"
				+ "questionsText : " + questionText + "\n" + "image : " + image
				+ "\n" + "image_64 : " + image_64;
	}
}
