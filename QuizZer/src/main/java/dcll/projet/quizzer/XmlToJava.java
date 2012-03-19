package dcll.projet.quizzer;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.jdom.Element;
import org.jdom.input.SAXBuilder;

import dcll.projet.quizzer.typesQuestions.Calculated;
import dcll.projet.quizzer.typesQuestions.Category;
import dcll.projet.quizzer.typesQuestions.Cloze;
import dcll.projet.quizzer.typesQuestions.Description;
import dcll.projet.quizzer.typesQuestions.Essay;
import dcll.projet.quizzer.typesQuestions.Matching;
import dcll.projet.quizzer.typesQuestions.MultipleChoice;
import dcll.projet.quizzer.typesQuestions.Numerical;
import dcll.projet.quizzer.typesQuestions.ShortAnswer;
import dcll.projet.quizzer.typesQuestions.TrueFalse;
import dcll.projet.quizzer.typesQuestions.element.Answer;
import dcll.projet.quizzer.typesQuestions.element.DatasetDefinition;
import dcll.projet.quizzer.typesQuestions.element.DatasetItem;
import dcll.projet.quizzer.typesQuestions.element.Unit;

/**
 * This class contains the definition of the xmlToJava Parser used to parse xml
 * document into java objects
 * 
 * @author Eros Luce, Clement Bardou, Christelle Lacan, Thierno Bah
 * 
 */
public class XmlToJava implements IxmlToJava {

	/**
	 * This method is used to load xml document and launch the parsing of the
	 * xml document
	 * 
	 * @param myFile
	 *            : The xml Document
	 * @return quiz : The java object questionary
	 */
	public Questionnaire run(String myFile) {
		org.jdom.Document document = null;
		Element racine;
		// creation of SAXBuilder instance :
		SAXBuilder sxb = new SAXBuilder();
		try {
			// creation of JDOM document with xmlDoc as input
			document = sxb.build(this.getClass().getResourceAsStream(myFile));
			// Le parsing is over
		} catch (Exception e) {
			System.out
					.println("Can't find the spcified emplacement for the XML Document");
		}

		// Initialisation of racine with the root of the XML doc
		racine = document.getRootElement();

		List<?> questionsXML = racine.getChildren("question");

		ArrayList<Question> questions = new ArrayList<Question>();
		Questionnaire quiz = new Questionnaire("MyQuiz", questions);

		// On crée un Iterator sur notre liste
		Iterator<?> i = questionsXML.iterator();
		while (i.hasNext()) {
			// On recrée l'Element courant à chaque tour de boucle afin de
			// pouvoir utiliser les méthodes propres aux Element comme :
			// selectionner un noeud fils, modifier du texte, etc...
			Element courant = (Element) i.next();
			String type = courant.getAttributeValue("type").trim();
			if (type.equals("numerical")) {
				xmlNumericalToJava(courant, quiz);
			}
			if (type.equals("multichoice")) {
				xmlMultipleChoiceToJava(courant, quiz);
			}
			if (type.equals("shortanswer")) {
				xmlShortAnswerToJava(courant, quiz);
			}
			if (type.equals("essay")) {
				xmlEssayToJava(courant, quiz);
			}
			if (type.equals("matching")) {
				xmlMatchingToJava(courant, quiz);
			}
			if (type.equals("category")) {
				xmlCategoryToJava(courant, quiz);
			}
			if (type.equals("description")) {
				xmlDescriptionToJava(courant, quiz);
			}
			if (type.equals("cloze")) {
				xmlClozeToJava(courant, quiz);
			}
			if (type.equals("calculated")) {
				xmlCalcultatedToJava(courant, quiz);
			}
			if (type.equals("truefalse")) {
				xmlTrueFalseToJava(courant, quiz);
			}
		}

		return quiz;
	}

	/**
	 * This method take an element of type <answer> and return the parsed
	 * element
	 * 
	 * @param e
	 *            : <answer>
	 * @return a : The parsed answer.
	 */
	private Answer xmlAnswerToJava(Element e) {
		String text = null;
		String fraction = null;
		String feedback = null;
		String tolerance = null;
		String toleranceType = null;
		String correctAnswerFormat = null;
		String correctAnswerLength = e.getChildTextTrim("correctanswerlength");

		try {
			tolerance = e.getChildTextTrim("tolerance").trim();
		} catch (Exception e2) {
			tolerance = null;
		}

		if (e.getChildTextTrim("text") != null) {
			text = e.getChildTextTrim("text");
		}
		if (e.getAttributeValue("fraction").trim() != null) {
			fraction = e.getAttributeValue("fraction").trim();
		}
		if (e.getChild("feedback").getChildTextTrim("text") != null) {
			feedback = e.getChild("feedback").getChildTextTrim("text");
		}

		if (e.getChildTextTrim("tolerancetype") != null) {
			toleranceType = e.getChildTextTrim("tolerancetype");
		}
		if (e.getChildTextTrim("correctanswerformat") != null) {
			correctAnswerFormat = e.getChildTextTrim("correctanswerformat");
		}
		if (e.getChildTextTrim("correctanswerlength") != null) {
			correctAnswerLength = e.getChildTextTrim("correctanswerlength");
		}

		Answer a = new Answer(text, fraction, feedback, tolerance,
				toleranceType, correctAnswerFormat, correctAnswerLength);
		return a;
	}

	/**
	 * This method take an element of type <unit> and return the parsed unit
	 * 
	 * @param e
	 *            : <unit>.
	 * @return u : The parsed unit.
	 */
	private Unit xmlUnitToJava(Element e) {
		String multiplier = e.getChildTextTrim("multiplier");
		String unitName = e.getChildTextTrim("unit_name");

		Unit u = new Unit(multiplier, unitName);
		return u;
	}

	/**
	 * This method take an element of type <dataset_item> and return the parsed
	 * datasetItem
	 * 
	 * @param e
	 *            : <dataset_item>
	 * @return d : The parsed datasetItem
	 */
	private DatasetItem xmlDatasetItemToJava(Element e) {
		String value = e.getChildTextTrim("value");
		String number = e.getChildTextTrim("number");

		DatasetItem d = new DatasetItem(value, number);
		return d;
	}

	/**
	 * This method take an element of type <dataset_definition> and return the
	 * parsed datasetDefinition
	 * 
	 * @param e
	 *            : <dataset_definition>
	 * @return d : The parse datasetDefinition
	 */
	private DatasetDefinition xmlDatasetDefinitionToJava(Element e) {
		String name = e.getChild("name").getChildTextTrim("text");
		String status = e.getChild("status").getChildTextTrim("text");
		String type = e.getChildTextTrim("type");
		String distribution = e.getChild("distribution").getChildTextTrim(
				"text");
		String minimum = e.getChild("minimum").getChildTextTrim("text");
		;
		String maximum = e.getChild("maximum").getChildTextTrim("text");
		;
		String decimals = e.getChild("decimals").getChildTextTrim("text");
		;
		String itemCount = e.getChildTextTrim("itemcount");
		;
		ArrayList<DatasetItem> datasetItems = new ArrayList<DatasetItem>();
		List<?> datasetItemsRes = e.getChild("dataset_items").getChildren(
				"dataset_item");
		Iterator<?> j = datasetItemsRes.iterator();
		// parcours toutes les réponses
		while (j.hasNext()) {
			Element courant = (Element) j.next();
			datasetItems.add(xmlDatasetItemToJava(courant));
		}

		String numberOfItems = e.getChildTextTrim("number_of_items");

		DatasetDefinition d = new DatasetDefinition(name, status, type,
				distribution, minimum, maximum, decimals, itemCount,
				datasetItems, numberOfItems);
		return d;
	}

	/**
	 * This method parse an element <question> of type Category and add it to
	 * the Quiz Java Object
	 * 
	 * @param e
	 * @param quiz
	 */
	private void xmlCategoryToJava(Element e, Questionnaire quiz) {
		String category = e.getChild("category").getChildTextTrim("text");

		Category myQuestion = new Category(category);
		quiz.getQuestions().add(myQuestion);
	}

	/**
	 * This method parse an element <question> of type Description and add it to
	 * the Quiz Java Object
	 * 
	 * @param e
	 * @param quiz
	 */
	private void xmlDescriptionToJava(Element e, Questionnaire quiz) {
		String name = e.getChild("name").getChildTextTrim("text");
		String questionText = e.getChild("questiontext").getChildTextTrim(
				"text");
		String format = e.getChild("questiontext").getAttributeValue("format")
				.trim();
		int defaultgrade = Integer.parseInt(e.getChildTextTrim("defaultgrade"));
		double penalty = Double.parseDouble(e.getChildTextTrim("penalty"));
		int shuffleanswers = Integer.parseInt(e
				.getChildTextTrim("shuffleanswers"));
		int hidden = Integer.parseInt(e.getChildTextTrim("hidden"));
		String image = e.getChildTextTrim("image");
		String image_64 = null;
		if (image != null) {
			image_64 = e.getChildTextTrim("image_64");
		}
		String generalFeedback = e.getChild("generalfeedback")
				.getChildTextTrim("text");
		Description myQuestion = new Description(name, questionText,
				generalFeedback, defaultgrade, penalty, shuffleanswers, hidden,
				format, image, image_64);
		quiz.getQuestions().add(myQuestion);
	}

	/**
	 * This method parse an element <question> of type MultipleChoice and add it
	 * to the Quiz Java Object
	 * 
	 * @param e
	 * @param quiz
	 */
	private void xmlMultipleChoiceToJava(Element e, Questionnaire quiz) {
		String name = e.getChild("name").getChildTextTrim("text");
		String questionText = e.getChild("questiontext").getChildTextTrim(
				"text");
		String format = e.getChild("questiontext").getAttributeValue("format")
				.trim();
		int defaultgrade = Integer.parseInt(e.getChildTextTrim("defaultgrade"));
		double penalty = Double.parseDouble(e.getChildTextTrim("penalty"));
		int shuffleanswers = Integer.parseInt(e
				.getChildTextTrim("shuffleanswers"));
		int hidden = Integer.parseInt(e.getChildTextTrim("hidden"));

		List<Answer> answers = new ArrayList<Answer>();
		List<?> answersRes = e.getChildren("answer");
		Iterator<?> i = answersRes.iterator();
		// parcours toutes les réponses
		while (i.hasNext()) {
			Element courant = (Element) i.next();
			answers.add(xmlAnswerToJava(courant));
		}
		String image = e.getChildTextTrim("image");
		String image_64 = null;
		if (!(image.equals(""))) {
			image_64 = e.getChildText("image_64");
		}
		boolean single = Boolean.valueOf(e.getChildTextTrim("single"))
				.booleanValue();
		String correctFeedback = e.getChild("correctfeedback")
				.getChildTextTrim("text");
		String partiallyCorrectFeedback = e
				.getChild("partiallycorrectfeedback").getChildTextTrim("text");
		String incorrectFeedback = e.getChild("incorrectfeedback")
				.getChildTextTrim("text");
		String answerNumbering = e.getChildTextTrim("answernumbering");
		String generalFeedback = e.getChild("generalfeedback")
				.getChildTextTrim("text");

		MultipleChoice myQuestion = new MultipleChoice(name, questionText,
				defaultgrade, penalty, shuffleanswers, hidden, answers, format,
				image, image_64, generalFeedback, correctFeedback,
				partiallyCorrectFeedback, incorrectFeedback, answerNumbering,
				single);
		quiz.getQuestions().add(myQuestion);
	}

	/**
	 * This method parse an element <question> of type ShortAnswer and add it to
	 * the Quiz Java Object
	 * 
	 * @param e
	 * @param quiz
	 */
	private void xmlShortAnswerToJava(Element e, Questionnaire quiz) {
		String name = e.getChild("name").getChildTextTrim("text");
		String questionText = e.getChild("questiontext").getChildTextTrim(
				"text");
		String format = e.getChild("questiontext").getAttributeValue("format")
				.trim();
		int defaultgrade = Integer.parseInt(e.getChildTextTrim("defaultgrade"));
		double penalty = Double.parseDouble(e.getChildTextTrim("penalty"));
		int shuffleanswers = Integer.parseInt(e
				.getChildTextTrim("shuffleanswers"));
		int hidden = Integer.parseInt(e.getChildTextTrim("hidden"));
		List<Answer> answers = new ArrayList<Answer>();

		List<?> answersRes = e.getChildren("answer");
		Iterator<?> i = answersRes.iterator();
		// parcours toutes les réponses
		while (i.hasNext()) {
			Element courant = (Element) i.next();
			answers.add(xmlAnswerToJava(courant));
		}
		int usecase = Integer.parseInt(e.getChildTextTrim("usecase"));
		String generalFeedback = e.getChild("generalfeedback")
				.getChildTextTrim("text");
		// CREATION DE L'OBJET SHORT ANSWER
		ShortAnswer myQuestion = new ShortAnswer(name, questionText, format,
				format, generalFeedback, defaultgrade, penalty, hidden,
				shuffleanswers, usecase, answers);
		quiz.getQuestions().add(myQuestion);
	}

	/**
	 * This method parse an element <question> of type Essay and add it to the
	 * Quiz Java Object
	 * 
	 * @param e
	 * @param quiz
	 */
	private void xmlEssayToJava(Element e, Questionnaire quiz) {
		String name = e.getChild("name").getChildTextTrim("text");
		String questionText = e.getChild("questiontext").getChildTextTrim(
				"text");
		String format = e.getChild("questiontext").getAttributeValue("format")
				.trim();
		int defaultgrade = Integer.parseInt(e.getChildTextTrim("defaultgrade"));
		double penalty = Double.parseDouble(e.getChildTextTrim("penalty"));
		int shuffleanswers = Integer.parseInt(e
				.getChildTextTrim("shuffleanswers"));
		int hidden = Integer.parseInt(e.getChildTextTrim("hidden"));
		List<Answer> answers = new ArrayList<Answer>();

		List<?> answersRes = e.getChildren("answer");
		Iterator<?> i = answersRes.iterator();
		// parcours toutes les réponses
		while (i.hasNext()) {
			Element courant = (Element) i.next();
			answers.add(xmlAnswerToJava(courant));
		}
		String image = e.getChildTextTrim("image");
		String image_64 = null;
		if (image != null) {
			image_64 = e.getChildTextTrim("image_64");
		}
		String generalFeedback = e.getChild("generalfeedback")
				.getChildTextTrim("text");

		Essay myQuestion = new Essay(name, questionText, defaultgrade, penalty,
				shuffleanswers, hidden, generalFeedback, answers, format,
				image, image_64);
		quiz.getQuestions().add(myQuestion);
	}

	/**
	 * This method parse an element <question> of type Matching and add it to
	 * the Quiz Java Object
	 * 
	 * @param e
	 * @param quiz
	 */
	private void xmlMatchingToJava(Element e, Questionnaire quiz) {
		String name = e.getChild("name").getChildTextTrim("text");
		String questionText = e.getChild("questiontext").getChildTextTrim(
				"text");
		String format = e.getChild("questiontext").getAttributeValue("format")
				.trim();
		int defaultgrade = Integer.parseInt(e.getChildTextTrim("defaultgrade"));
		double penalty = Double.parseDouble(e.getChildTextTrim("penalty"));
		int shuffleanswers = Integer.parseInt(e
				.getChildTextTrim("shuffleanswers"));
		int hidden = Integer.parseInt(e.getChildTextTrim("hidden"));
		String image = e.getChildTextTrim("image");
		String image_64 = null;
		if (image != null) {
			image_64 = e.getChildTextTrim("image_64");
		}
		List<SubQuestion> subQuestions = new ArrayList<SubQuestion>();
		List<?> subQuestionRes = e.getChildren("subquestion");
		Iterator<?> i = subQuestionRes.iterator();
		String subQuestionName = null;
		String answerName = null;
		// parcours toutes les réponses
		while (i.hasNext()) {
			Element courant = (Element) i.next();
			subQuestionName = courant.getChildTextTrim("text");
			answerName = courant.getChild("answer").getChildTextTrim("text");
			subQuestions.add(new SubQuestion(subQuestionName, answerName));
		}
		String generalFeedback = e.getChild("generalfeedback")
				.getChildTextTrim("text");

		Matching myQuestion = new Matching(name, questionText, defaultgrade,
				penalty, shuffleanswers, hidden, format, generalFeedback,
				image, image_64, subQuestions);
		quiz.getQuestions().add(myQuestion);
	}

	/**
	 * This method parse an element <question> of type Cloze and add it to the
	 * Quiz Java Object
	 * 
	 * @param e
	 * @param quiz
	 */
	private void xmlClozeToJava(Element e, Questionnaire quiz) {
		String name = e.getChild("name").getChildTextTrim("text");
		String questionText = e.getChild("questiontext").getChildTextTrim(
				"text");
		int shuffleanswers = Integer.parseInt(e
				.getChildTextTrim("shuffleanswers"));
		String generalFeedback = e.getChild("generalfeedback")
				.getChildTextTrim("text");

		Cloze myQuestion = new Cloze(name, questionText, shuffleanswers,
				generalFeedback);
		quiz.getQuestions().add(myQuestion);
	}

	/**
	 * This method parse an element <question> of type Numerical and add it to
	 * the Quiz Java Object
	 * 
	 * @param e
	 * @param quiz
	 */
	private void xmlNumericalToJava(Element e, Questionnaire quiz) {
		String name = e.getChild("name").getChildTextTrim("text");
		String questionText = e.getChild("questiontext").getChildTextTrim(
				"text");
		String format = e.getChild("questiontext").getAttributeValue("format")
				.trim();
		int defaultgrade = Integer.parseInt(e.getChildTextTrim("defaultgrade"));
		double penalty = Double.parseDouble(e.getChildTextTrim("penalty"));
		int shuffleanswers = Integer.parseInt(e
				.getChildTextTrim("shuffleanswers"));
		int hidden = Integer.parseInt(e.getChildTextTrim("hidden"));
		List<Answer> answers = new ArrayList<Answer>();

		List<?> answersRes = e.getChildren("answer");
		Iterator<?> i = answersRes.iterator();

		// parcours toutes les réponses
		while (i.hasNext()) {
			Element courant = (Element) i.next();
			answers.add(xmlAnswerToJava(courant));
		}
		String image = e.getChildTextTrim("image");
		String image_64 = null;
		if (image != null) {
			image_64 = e.getChildTextTrim("image_64");
		}
		String mGeneralfeedback = e.getChild("generalfeedback")
				.getChildTextTrim("text");
		Numerical myQuestion = new Numerical(name, questionText, defaultgrade,
				penalty, shuffleanswers, mGeneralfeedback, hidden, answers,
				format, image, image_64);
		quiz.getQuestions().add(myQuestion);
	}

	/**
	 * This method parse an element <question> of type Calculated and add it to
	 * the Quiz Java Object
	 * 
	 * @param e
	 * @param quiz
	 */
	private void xmlCalcultatedToJava(Element e, Questionnaire quiz) {
		String name = e.getChild("name").getChildTextTrim("text");
		String questionText = e.getChild("questiontext").getChildTextTrim(
				"text");
		String format = e.getChild("questiontext").getAttributeValue("format")
				.trim();
		int defaultgrade = Integer.parseInt(e.getChildTextTrim("defaultgrade"));
		double penalty = Double.parseDouble(e.getChildTextTrim("penalty"));
		int shuffleanswers = Integer.parseInt(e
				.getChildTextTrim("shuffleanswers"));
		int hidden = Integer.parseInt(e.getChildTextTrim("hidden"));
		ArrayList<Answer> answers = new ArrayList<Answer>();

		List<?> answersRes = e.getChildren("answer");
		Iterator<?> i = answersRes.iterator();

		// parcours toutes les réponses
		while (i.hasNext()) {
			Element courant = (Element) i.next();
			answers.add(xmlAnswerToJava(courant));
		}
		String image = e.getChildTextTrim("image");
		String image_64 = null;
		if (image != null) {
			image_64 = e.getChildTextTrim("image_64");
		}

		ArrayList<Unit> units = new ArrayList<Unit>();
		List<?> unitsRes = e.getChild("units").getChildren("unit");
		Iterator<?> j = unitsRes.iterator();
		// parcours toutes les réponses
		while (j.hasNext()) {
			Element courant = (Element) j.next();
			units.add(xmlUnitToJava(courant));
		}

		ArrayList<DatasetDefinition> datasetDefinitions = new ArrayList<DatasetDefinition>();
		List<?> datasetDefinitionsRes = e.getChild("dataset_definitions")
				.getChildren("dataset_definition");
		Iterator<?> k = datasetDefinitionsRes.iterator();
		while (k.hasNext()) {
			Element courant = (Element) k.next();
			datasetDefinitions.add(xmlDatasetDefinitionToJava(courant));
		}
		String generalFeedback = e.getChild("generalfeedback")
				.getChildTextTrim("text");

		Calculated myQuestion = new Calculated(name, questionText, format,
				image, image_64, defaultgrade, generalFeedback, penalty,
				hidden, shuffleanswers, answers, units, datasetDefinitions);
		quiz.getQuestions().add(myQuestion);
	}

	/**
	 * This method parse an element <question> of type Calculated and add it to
	 * the Quiz Java Object
	 * 
	 * @param e
	 * @param quiz
	 */
	private void xmlTrueFalseToJava(Element e, Questionnaire quiz) {
		String name = e.getChild("name").getChildTextTrim("text");
		String questionText = e.getChild("questiontext").getChildTextTrim(
				"text");
		String format = e.getChild("questiontext").getAttributeValue("format")
				.trim();
		int defaultgrade = Integer.parseInt(e.getChildTextTrim("defaultgrade"));
		double penalty = Double.parseDouble(e.getChildTextTrim("penalty"));
		int shuffleanswers = Integer.parseInt(e
				.getChildTextTrim("shuffleanswers"));
		int hidden = Integer.parseInt(e.getChildTextTrim("hidden"));
		String image = e.getChildTextTrim("image");
		String image_64 = null;
		if (image != null) {
			image_64 = e.getChildTextTrim("image_64");
		}
		String generalFeedback = e.getChild("generalfeedback")
				.getChildTextTrim("text");
		ArrayList<Answer> answers = new ArrayList<Answer>();

		List<?> answersRes = e.getChildren("answer");
		Iterator<?> i = answersRes.iterator();

		// parcours toutes les réponses
		while (i.hasNext()) {
			Element courant = (Element) i.next();
			answers.add(xmlAnswerToJava(courant));
		}

		TrueFalse myQuestion = new TrueFalse(name, questionText, defaultgrade,
				penalty, shuffleanswers, hidden, generalFeedback, answers,
				format, image, image_64);
		quiz.getQuestions().add(myQuestion);

	}

}
