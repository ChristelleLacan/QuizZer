package dcll.projet.quizzer;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.jdom.Element;
import org.jdom.input.SAXBuilder;

//
//
//  @ Project : QuizZer
//  @ File Name : XmlToJava.java
//  @ Date : 05/03/2012
//  @ Author : Clement Bardou
//
//

public class XmlToJava {

	private org.jdom.Document document;
	private static Element racine;

	public void loadDocument() {
		// On crée une instance de SAXBuilder
		SAXBuilder sxb = new SAXBuilder();
		try {
			// On crée un nouveau document JDOM avec en argument le fichier XML
			document = sxb.build(this.getClass().getResourceAsStream(
					"../xmldoc/quiz.xml"));
			// Le parsing est terminé ;)
		} catch (Exception e) {
		}

		// On initialise un nouvel élément racine avec l'élément racine du
		// document.
		racine = document.getRootElement();
	}

	public void run() {
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
			// System.out.println(type);
			if (type.equals("numerical")) {
				xmlNumericalToJava(courant, quiz);
			}
			if (type.equals("multichoice")) {
				xmlMultipleChoiceToJava(courant, quiz);
			}
			if (type.equals("shortanswer")) {
				// xmlShortAnswerToJava(courant, quiz);
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
		}
		System.out.println(quiz.toString());

	}

	// Gestion des reponses
	public Answer xmlAnswerToJava(Element e) {
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

	public Unit xmlUnitToJava(Element e) {
		String multiplier = e.getChildTextTrim("multiplier");
		String unitName = e.getChildTextTrim("unit_name");

		Unit u = new Unit(multiplier, unitName);
		return u;
	}

	public DatasetItem xmlDatasetItemToJava(Element e) {
		String value = e.getChildTextTrim("value");
		String number = e.getChildTextTrim("number");

		DatasetItem d = new DatasetItem(value, number);
		return d;
	}

	public DatasetDefinition xmlDatasetDefinitionToJava(Element e) {
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

	public void xmlCategoryToJava(Element e, Questionnaire quiz) {
		String category = e.getChild("category").getChildTextTrim("text");

		Category myQuestion = new Category(category);
		quiz.getQuestions().add(myQuestion);
	}

	// Gestion de xml vers java : DESCRIPTION
	public void xmlDescriptionToJava(Element e, Questionnaire quiz) {
		String name = e.getChild("name").getChildTextTrim("text");
		String questionText = e.getChild("questiontext").getChildTextTrim(
				"text");
		String format = e.getChild("questiontext").getAttributeValue("format")
				.trim();
		int defaultgrade = Integer.parseInt(e.getChildTextTrim("defaultgrade"));
		double penalty = Double.parseDouble(e.getChildTextTrim("penalty"));
		boolean shuffleanswers = Boolean.valueOf(
				e.getChildTextTrim("shuffleanswers")).booleanValue();
		boolean hidden = Boolean.valueOf(e.getChildTextTrim("hidden"))
				.booleanValue();
		String image = e.getChildTextTrim("image");
		String image_64 = null;
		if (image != null) {
			image_64 = e.getChildTextTrim("image_64");
		}

		Description myQuestion = new Description(name, questionText,
				defaultgrade, penalty, shuffleanswers, hidden, format, image,
				image_64);
		quiz.getQuestions().add(myQuestion);
	}

	// Gestion de xml vers java : MULTIPLE CHOICE
	public void xmlMultipleChoiceToJava(Element e, Questionnaire quiz) {
		String name = e.getChild("name").getChildTextTrim("text");
		String questionText = e.getChild("questiontext").getChildTextTrim(
				"text");
		String format = e.getChild("questiontext").getAttributeValue("format")
				.trim();
		int defaultgrade = Integer.parseInt(e.getChildTextTrim("defaultgrade"));
		double penalty = Double.parseDouble(e.getChildTextTrim("penalty"));
		boolean shuffleanswers = Boolean.valueOf(
				e.getChildTextTrim("shuffleanswers")).booleanValue();
		boolean hidden = Boolean.valueOf(e.getChildTextTrim("hidden"))
				.booleanValue();

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

		MultipleChoice myQuestion = new MultipleChoice(name, questionText,
				defaultgrade, penalty, shuffleanswers, hidden, answers, format,
				image, image_64, correctFeedback, partiallyCorrectFeedback,
				incorrectFeedback, answerNumbering, single);
		quiz.getQuestions().add(myQuestion);
	}

	// Gestion de xml vers java : SHORT ANSWER
	public void xmlShortAnswerToJava(Element e, Questionnaire quiz) {
		String name = e.getChild("name").getChildTextTrim("text");
		String questionText = e.getChild("questiontext").getChildTextTrim(
				"text");
		String format = e.getChild("questiontext").getAttributeValue("format")
				.trim();
		int defaultgrade = Integer.parseInt(e.getChildTextTrim("defaultgrade"));
		NumberFormat myFormat = NumberFormat.getInstance();
		double penalty = Double.parseDouble(e.getChildTextTrim("penalty"));
		boolean shuffleanswers = Boolean.valueOf(
				e.getChildTextTrim("shuffleanswers")).booleanValue();
		boolean hidden = Boolean.valueOf(e.getChildTextTrim("hidden"))
				.booleanValue();
		List<Answer> answers = new ArrayList<Answer>();

		List<?> answersRes = e.getChildren("answer");
		Iterator<?> i = answersRes.iterator();
		// parcours toutes les réponses
		while (i.hasNext()) {
			Element courant = (Element) i.next();
			answers.add(xmlAnswerToJava(courant));
		}

		// // CREATION DE L'OBJET SHORT ANSWER
		// ShortAnswer myQuestion = new ShortAnswer(name, questionText,
		// defaultgrade, penalty, shuffleanswers, hidden, answers, format);
		// quiz.getQuestions().add(myQuestion);
	}

	private void xmlEssayToJava(Element e, Questionnaire quiz) {
		String name = e.getChild("name").getChildTextTrim("text");
		String questionText = e.getChild("questiontext").getChildTextTrim(
				"text");
		String format = e.getChild("questiontext").getAttributeValue("format")
				.trim();
		int defaultgrade = Integer.parseInt(e.getChildTextTrim("defaultgrade"));
		double penalty = Double.parseDouble(e.getChildTextTrim("penalty"));
		boolean shuffleanswers = Boolean.valueOf(
				e.getChildTextTrim("shuffleanswers")).booleanValue();
		boolean hidden = Boolean.valueOf(e.getChildTextTrim("hidden"))
				.booleanValue();
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

		Essay myQuestion = new Essay(name, questionText, defaultgrade, penalty,
				shuffleanswers, hidden, answers, format, image, image_64);
		quiz.getQuestions().add(myQuestion);
	}

	private void xmlMatchingToJava(Element e, Questionnaire quiz) {
		String name = e.getChild("name").getChildTextTrim("text");
		String questionText = e.getChild("questiontext").getChildTextTrim(
				"text");
		String format = e.getChild("questiontext").getAttributeValue("format")
				.trim();
		int defaultgrade = Integer.parseInt(e.getChildTextTrim("defaultgrade"));
		double penalty = Double.parseDouble(e.getChildTextTrim("penalty"));
		boolean shuffleanswers = Boolean.valueOf(
				e.getChildTextTrim("shuffleanswers")).booleanValue();
		boolean hidden = Boolean.valueOf(e.getChildTextTrim("hidden"))
				.booleanValue();
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

		Matching myQuestion = new Matching(name, questionText, defaultgrade,
				penalty, shuffleanswers, hidden, format, image, image_64,
				subQuestions);
		quiz.getQuestions().add(myQuestion);
	}

	private void xmlClozeToJava(Element e, Questionnaire quiz) {
		String name = e.getChild("name").getChildTextTrim("text");
		String questionText = e.getChild("questiontext").getChildTextTrim(
				"text");
		boolean shuffleanswers = Boolean.valueOf(
				e.getChildTextTrim("shuffleanswers")).booleanValue();

		Cloze myQuestion = new Cloze(name, questionText, shuffleanswers);
		quiz.getQuestions().add(myQuestion);
	}

	private void xmlNumericalToJava(Element e, Questionnaire quiz) {
		String name = e.getChild("name").getChildTextTrim("text");
		String questionText = e.getChild("questiontext").getChildTextTrim(
				"text");
		String format = e.getChild("questiontext").getAttributeValue("format")
				.trim();
		int defaultgrade = Integer.parseInt(e.getChildTextTrim("defaultgrade"));
		double penalty = Double.parseDouble(e.getChildTextTrim("penalty"));
		boolean shuffleanswers = Boolean.valueOf(
				e.getChildTextTrim("shuffleanswers")).booleanValue();
		boolean hidden = Boolean.valueOf(e.getChildTextTrim("hidden"))
				.booleanValue();
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

		Numerical myQuestion = new Numerical(name, questionText, defaultgrade,
				penalty, shuffleanswers, hidden, answers, format, image,
				image_64);
		quiz.getQuestions().add(myQuestion);
	}

	private void xmlCalcultatedToJava(Element e, Questionnaire quiz) {
		String name = e.getChild("name").getChildTextTrim("text");
		String questionText = e.getChild("questiontext").getChildTextTrim(
				"text");
		String format = e.getChild("questiontext").getAttributeValue("format")
				.trim();
		int defaultgrade = Integer.parseInt(e.getChildTextTrim("defaultgrade"));
		double penalty = Double.parseDouble(e.getChildTextTrim("penalty"));
		boolean shuffleanswers = Boolean.valueOf(
				e.getChildTextTrim("shuffleanswers")).booleanValue();
		boolean hidden = Boolean.valueOf(e.getChildTextTrim("hidden"))
				.booleanValue();
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

		Calculated myQuestion = new Calculated(name, questionText, format,
				image, image_64, defaultgrade, penalty, hidden, shuffleanswers,
				answers, units, datasetDefinitions);
		quiz.getQuestions().add(myQuestion);
	}

}
