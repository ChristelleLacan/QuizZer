package dcll.projet.quizzer;

import java.util.ArrayList;

public class Calculated extends Question {

	private String type;
	private String questionText;
	private String format;
	private String image;
	private String image_64;
	private int defaultGrade;
	private double penalty;
	private boolean hidden;
	private boolean shuffleAnswers;
	private ArrayList<Answer> answers = new ArrayList<Answer>();
	private ArrayList<Unit> units = new ArrayList<Unit>();
	private ArrayList<DatasetDefinition> datasetDefinitions = new ArrayList<DatasetDefinition>();

	public Calculated(String mName, String mQuestionText,
			String mFormat, String mImage, String mImage_64, int mDefaultGrade,
			double mPenalty, boolean mHidden, boolean mShuffleAnswers,
			ArrayList<Answer> mAnswers, ArrayList<Unit> mUnits,
			ArrayList<DatasetDefinition> mDatasetDefinitions) {
		super(mName);
		questionText = mQuestionText;
		format = mFormat;
		type = "Calculated";
		image = mImage;
		image_64 = mImage_64;
		defaultGrade = mDefaultGrade;
		penalty = mPenalty;
		hidden = mHidden;
		shuffleAnswers = mShuffleAnswers;
		answers = mAnswers;
		units = mUnits;
		datasetDefinitions = mDatasetDefinitions;
	}

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

}