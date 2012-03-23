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
	 * The type.
	 */
	private String type;
	/**
	 * Question text.
	 */
	private String questionText;
	/**
	 * The Format.
	 */
	private String format;
	/**
	 * The image path.
	 */
	private String image;
	/**
	 * The image.
	 */
	private String image_64;
	/**
	 * General Feedback.
	 */
	private String generalfeedback;
	/**
	 * The default grade.
	 */
	private int defaultGrade;
	/**
	 * The penalty.
	 */
	private double penalty;
	/**
	 * Hidden or not ?
	 */
	private int hidden;
	/**
	 * Shuffle or not ?
	 */
	private int shuffleAnswers;
	/**
	 * The answer list.
	 */
	private ArrayList<Answer> answers = new ArrayList<Answer>();
	/**
	 * The unit list.
	 */
	private ArrayList<Unit> units = new ArrayList<Unit>();
	/**
	 * The Dataset definition list.
	 */
	private ArrayList<DatasetDefinition> datasetDefinitions = new ArrayList<DatasetDefinition>();

	/**
	 * Constructor.
	 * 
	 * @param mName
	 *            ..
	 * @param mQuestionText
	 *            ..
	 * @param mFormat
	 *            ..
	 * @param mImage
	 *            ..
	 * @param mImage_64
	 *            ..
	 * @param mDefaultGrade
	 *            ..
	 * @param mPenalty
	 *            ..
	 * @param mHidden
	 *            ..
	 * @param mShuffleAnswers
	 *            ..
	 * @param mAnswers
	 *            ..
	 * @param mUnits
	 *            ..
	 * @param mDatasetDefinitions
	 *            ..
	 * @param mGeneralfeedback
	 *            ..
	 */
	public Calculated(final String mName, final String mQuestionText,
			final String mFormat, final String mImage, final String mImage_64,
			final int mDefaultGrade, final String mGeneralfeedback,
			final double mPenalty, final int mHidden,
			final int mShuffleAnswers, final ArrayList<Answer> mAnswers,
			final ArrayList<Unit> mUnits,
			final ArrayList<DatasetDefinition> mDatasetDefinitions) {
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

	/**
	 * @return question text
	 */
	public final String getQuestionText() {
		return questionText;
	}

	/**
	 * @return format
	 */
	public final String getFormat() {
		return format;
	}

	/**
	 * @return image
	 */
	public final String getImage() {
		return image;
	}

	/**
	 * @return image_64
	 */
	public final String getImage_64() {
		return image_64;
	}

	/**
	 * @return default grade
	 */
	public final int getDefaultGrade() {
		return defaultGrade;
	}

	/**
	 * @return penalty
	 */
	public final double getPenalty() {
		return penalty;
	}

	/**
	 * @return hidden
	 */
	public final int isHidden() {
		return hidden;
	}

	/**
	 * @return shuffle answers
	 */
	public final int isShuffleAnswers() {
		return shuffleAnswers;
	}

	/**
	 * @return Answers
	 */
	public final ArrayList<Answer> getAnswers() {
		return answers;
	}

	/**
	 * @return units
 	 */
	public final ArrayList<Unit> getUnits() {
		return units;
	}

	/**
	 * @return datasetDefinitions
	 */
	public final ArrayList<DatasetDefinition> getDatasetDefinitions() {
		return datasetDefinitions;
	}

}
