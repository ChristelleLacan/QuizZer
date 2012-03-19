package dcll.projet.quizzer;

import java.util.ArrayList;

/**
 * This class contains definition of Calculated Questions
 * 
 * @author Eros Luce, Clement Bardou, Christelle Lacan, Thierno Bah
 * 
 */
public class Calculated extends Question {

	private String type;
	private String questionText;
	private String format;
	private String image;
	private String image_64;
	private String generalfeedback;
	private int defaultGrade;
	private double penalty;
	private int hidden;
	private int shuffleAnswers;
	private ArrayList<Answer> answers = new ArrayList<Answer>();
	private ArrayList<Unit> units = new ArrayList<Unit>();
	private ArrayList<DatasetDefinition> datasetDefinitions = new ArrayList<DatasetDefinition>();

	/**
	 * Constructor :
	 * 
	 * @param mName
	 * @param mQuestionText
	 * @param mFormat
	 * @param mImage
	 * @param mImage_64
	 * @param mDefaultGrade
	 * @param mPenalty
	 * @param mHidden
	 * @param mShuffleAnswers
	 * @param mAnswers
	 * @param mUnits
	 * @param mDatasetDefinitions
	 */
	public Calculated(String mName, String mQuestionText, String mFormat,
			String mImage, String mImage_64, int mDefaultGrade,
			String mGeneralfeedback,
			double mPenalty, int mHidden, int mShuffleAnswers,
			ArrayList<Answer> mAnswers, ArrayList<Unit> mUnits,
			ArrayList<DatasetDefinition> mDatasetDefinitions) {
		super(mName);
		questionText = mQuestionText;
		format = mFormat;
		type = "calculated";
		image = mImage;
		image_64 = mImage_64;
		generalfeedback = mGeneralfeedback;
		defaultGrade = mDefaultGrade;
		penalty = mPenalty;
		hidden = mHidden;
		shuffleAnswers = mShuffleAnswers;
		answers = mAnswers;
		units = mUnits;
		datasetDefinitions = mDatasetDefinitions;
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
				+ "\n" + "image_64 : " + image_64 + "\nAnswers : " + answers
				+ "\nUnits : " + units + "\nDataset Definitions : "
				+ datasetDefinitions;

	}

	public String getGeneralfeedback() {
		return generalfeedback;
	}

	public String getType() {
		return type;
	}

	public String getQuestionText() {
		return questionText;
	}

	public String getFormat() {
		return format;
	}

	public String getImage() {
		return image;
	}

	public String getImage_64() {
		return image_64;
	}

	public int getDefaultGrade() {
		return defaultGrade;
	}

	public double getPenalty() {
		return penalty;
	}

	public int isHidden() {
		return hidden;
	}

	public int isShuffleAnswers() {
		return shuffleAnswers;
	}

	public ArrayList<Answer> getAnswers() {
		return answers;
	}

	public ArrayList<Unit> getUnits() {
		return units;
	}

	public ArrayList<DatasetDefinition> getDatasetDefinitions() {
		return datasetDefinitions;
	}

}
