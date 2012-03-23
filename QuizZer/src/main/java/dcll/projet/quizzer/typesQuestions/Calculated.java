package dcll.projet.quizzer.typesQuestions;

import java.util.ArrayList;

import dcll.projet.quizzer.Question;
import dcll.projet.quizzer.typesQuestions.element.Answer;
import dcll.projet.quizzer.typesQuestions.element.DatasetDefinition;
import dcll.projet.quizzer.typesQuestions.element.Unit;

/**
 * This class contains definition of Calculated Questions
 * 
 * @author Eros Luce, Clement Bardou, Christelle Lacan, Thierno Bah
 * 
 */
public class Calculated extends Question {

	/**
	 * The type
	 */
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
			String mGeneralfeedback, double mPenalty, int mHidden,
			int mShuffleAnswers, ArrayList<Answer> mAnswers,
			ArrayList<Unit> mUnits,
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
	 * @return a string
	 */
	public final String toString() {
		return "\n----Ceci est : une " + type + "  \n" + super.toString()
				+ "format : " + format + "defaultgrade : " + defaultGrade
				+ "\n" + "penalty : " + penalty + "\n" + "shuffleanswers : "
				+ shuffleAnswers + "\n" + "hidden : " + hidden + "\n"
				+ "questionsText : " + questionText + "\n" + "image : " + image
				+ "\n" + "image_64 : " + image_64 + "\nAnswers : " + answers
				+ "\nUnits : " + units + "\nDataset Definitions : "
				+ datasetDefinitions;

	}

	/**
	 * @return general feedback
	 */
	public final String getGeneralfeedback() {
		return generalfeedback;
	}

	/**
	 * @return question type
	 */
	public final String getType() {
		return type;
	}

	public final String getQuestionText() {
		return questionText;
	}

	public final String getFormat() {
		return format;
	}

	public final String getImage() {
		return image;
	}

	public final String getImage_64() {
		return image_64;
	}

	public final int getDefaultGrade() {
		return defaultGrade;
	}

	public final double getPenalty() {
		return penalty;
	}

	public final int isHidden() {
		return hidden;
	}

	public final int isShuffleAnswers() {
		return shuffleAnswers;
	}

	public final ArrayList<Answer> getAnswers() {
		return answers;
	}

	public final ArrayList<Unit> getUnits() {
		return units;
	}

	public final ArrayList<DatasetDefinition> getDatasetDefinitions() {
		return datasetDefinitions;
	}

}
