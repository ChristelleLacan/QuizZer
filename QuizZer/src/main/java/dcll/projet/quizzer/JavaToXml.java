package dcll.projet.quizzer;

import java.io.FileOutputStream;
import java.io.IOException;

import org.jdom.Attribute;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.output.Format;
import org.jdom.output.XMLOutputter;

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
import dcll.projet.quizzer.typesQuestions.element.SubQuestion;

/**.
 * This class contains the definition of the xmlToJava Parser used to parse xml
 * document into java objects
 * @author Eros Luce, Clement Bardou, Christelle Lacan, Thierno Bah
 */
public class JavaToXml implements IjavaToXml {

	/**.
	 * This method is used to parse the java object to xml document
	 * @param quiz
	 *            : the xml questionnaire
	 * @param fichier
	 *            : The xml Document
	 * @return quiz
	 * 			  : The java object questionnaire
	 */
	public final void run(Questionnaire quiz, String fichier) {
		Element racine = new Element(quiz.getRacine());
		Document document = new Document(racine);
		for (int i = 0; i < quiz.getQuestions().size(); i++) {
			Element question = new Element("question");
			racine.addContent(question);
			Question q = quiz.getQuestions().get(i);
			if (q instanceof Cloze) {
				convertCloze((Cloze) q, question);
			} else if (q instanceof MultipleChoice) {
				convertMultipleChoice((MultipleChoice) q,
						question);
			} else if (q instanceof ShortAnswer) {
				convertShortAnswer((ShortAnswer) q, question);
			} else if (q instanceof Category) {
				convertCategory((Category) q, question);
			} else if (q instanceof Calculated) {
				convertCalculated((Calculated) q, question);
			} else if (q instanceof Matching) {
				convertMatching((Matching) q, question);
			} else if (q instanceof Essay) {
				convertEssay((Essay) q, question);
			} else if (q instanceof TrueFalse) {
				convertTrueFalse((TrueFalse) q, question);
			} else if (q instanceof Numerical) {
				convertNumerical((Numerical) q, question);
			} else if (q instanceof Description) {
				convertDescription((Description) q, question);
			}
		}

		affiche(document);
		enregistre(fichier, document);
	}

	/**.
	 * this method used to parse an element description and add to the XML
	 * document
	 * @param q
	 *            object java, have to convert in XML
	 * @param question
	 *            element parent
	 */
	private static void convertDescription(Description q,
			Element question) {
		Attribute type = new Attribute("type", q.getType());
		question.setAttribute(type);

		Element name = new Element("name");
		question.addContent(name);
		Element text = new Element("text");
		name.addContent(text);
		text.addContent(q.getName());

		Element questiontext = new Element("questionText");
		question.addContent(questiontext);
		Attribute format = new Attribute("format", q.getFormat());
		questiontext.setAttribute(format);
		text = new Element("text");
		questiontext.addContent(text);
		text.addContent(q.getQuestionText());

		Element image = new Element("image");
		question.addContent(image);
		image.addContent(q.getImage());

		Element generalfeedback = new Element("generalfeedback");
		question.addContent(generalfeedback);
		text = new Element("text");
		generalfeedback.addContent(text);
		text.addContent(q.getGeneralfeedback());

		Element defaultgradre = new Element("defaultgrade");
		question.addContent(defaultgradre);
		defaultgradre.addContent("" + q.getDefaultGrade());

		Element penalty = new Element("penalty");
		question.addContent(penalty);
		penalty.addContent("" + q.getPenalty());

		Element hidden = new Element("hidden");
		question.addContent(hidden);
		hidden.addContent("" + q.getHidden());

		Element shuffleanswers = new Element("shuffleanswer");
		question.addContent(shuffleanswers);
		shuffleanswers.addContent("" + q.getShuffleAnswers());

	}

	/**.
	 * this method used to parse an element Calculated and add to the XML
	 * document
	 * @param q
	 *            calculated object java, have to convert in XML
	 * @param question
	 *            element parent
	 */
	private static void convertCalculated(Calculated q, Element question) {
		Attribute type = new Attribute("type", q.getType());
		question.setAttribute(type);

		Element name = new Element("name");
		question.addContent(name);
		Element text = new Element("text");
		name.addContent(text);
		text.addContent(q.getName());

		Element questiontext = new Element("questionText");
		question.addContent(questiontext);
		Attribute format = new Attribute("format", q.getFormat());
		questiontext.setAttribute(format);
		text = new Element("text");
		questiontext.addContent(text);
		text.addContent(q.getQuestionText());

		Element image = new Element("image");
		question.addContent(image);
		image.addContent(q.getImage());

		Element generalfeedback = new Element("generalfeedback");
		question.addContent(generalfeedback);
		text = new Element("text");
		generalfeedback.addContent(text);
		text.addContent(q.getGeneralfeedback());

		Element defaultgradre = new Element("defaultgrade");
		question.addContent(defaultgradre);
		defaultgradre.addContent("" + q.getDefaultGrade());

		Element penalty = new Element("penalty");
		question.addContent(penalty);
		penalty.addContent("" + q.getPenalty());

		Element hidden = new Element("hidden");
		question.addContent(hidden);
		hidden.addContent("" + q.isHidden());

		Element shuffleanswers = new Element("shuffleanswer");
		question.addContent(shuffleanswers);
		shuffleanswers.addContent("" + q.isShuffleAnswers());

		Element answer, feedback;
		Attribute fraction;
		Answer current;
		for (int i = 0; i < q.getAnswers().size(); i++) {
			current = q.getAnswers().get(i);
			answer = new Element("answer");
			question.addContent(answer);
			fraction = new Attribute("fraction",
					current.getFraction());
			answer.setAttribute(fraction);

			text = new Element("text");
			answer.addContent(text);
			text.addContent(current.getText());

			Element tolerance = new Element("tolerance");
			answer.addContent(tolerance);
			tolerance.addContent(current.getTolerance());

			Element tolerancetype = new Element("tolerancetype");
			answer.addContent(tolerancetype);
			tolerancetype.addContent(current.getToleranceType());

			Element correctanswerformat =
					new Element("correctanswerformat");
			answer.addContent(correctanswerformat);
			correctanswerformat.addContent(current.getCorrectAnswerFormat());

			Element correctanswerlength =
					new Element("correctanswerlength");
			answer.addContent(correctanswerlength);
			correctanswerlength.addContent(current.getCorrectAnswerLength());

			feedback = new Element("feedback");
			answer.addContent(feedback);
			text = new Element("text");
			feedback.addContent(text);
			text.addContent(current.getFeedback());
		}

		Element units = new Element("units");
		question.addContent(units);

		for (int i = 0; i < q.getUnits().size(); i++) {
			Element unit = new Element("unit");
			units.addContent(unit);

			Element multiplier = new Element("multiplier");
			Element unitName = new Element("unit_name");
			unit.addContent(multiplier);
			unit.addContent(unitName);
			multiplier.addContent(q.getUnits().get(i).getMultiplier());
			unitName.addContent(q.getUnits().get(i).getUnitName());
		}

		Element dataset_definitions = new Element("dataset_definitions");
		question.addContent(dataset_definitions);

		Element status, datasetDefinition;
		Element typ, distribution, minimum, maximum;
		Element decimals, itemcount, datasetItems;
		Element datasetItem, number, value;
		for (int i = 0; i < q.getDatasetDefinitions().size(); i++) {
			DatasetDefinition datasetDef =
					q.getDatasetDefinitions().get(i);
			datasetDefinition = new Element("dataset_definition");
			dataset_definitions.addContent(datasetDefinition);

			status = new Element("status");
			datasetDefinition.addContent(status);
			text = new Element("text");
			status.addContent(text);
			text.addContent(datasetDef.getStatus());

			name = new Element("name");
			datasetDefinition.addContent(name);
			text = new Element("text");
			name.addContent(text);
			text.addContent(datasetDef.getName());

			typ = new Element("type");
			datasetDefinition.addContent(typ);
			typ.addContent(datasetDef.getType());

			distribution = new Element("distribution");
			datasetDefinition.addContent(distribution);
			text = new Element("text");
			distribution.addContent(text);
			text.addContent(datasetDef.getDistribution());

			minimum = new Element("minimum");
			datasetDefinition.addContent(minimum);
			text = new Element("text");
			minimum.addContent(text);
			text.addContent(datasetDef.getMinimum());

			maximum = new Element("maximum");
			datasetDefinition.addContent(maximum);
			text = new Element("text");
			maximum.addContent(text);
			text.addContent(q.getDatasetDefinitions().
					get(i).getMaximum());

			decimals = new Element("decimals");
			datasetDefinition.addContent(decimals);
			text = new Element("text");
			decimals.addContent(text);
			text.addContent(q.getDatasetDefinitions().
					get(i).getDecimals());

			itemcount = new Element("itemcount");
			datasetDefinition.addContent(itemcount);
			itemcount.addContent(q.getDatasetDefinitions().get(i)
					.getItemCount());

			datasetItems = new Element("dataset_items");
			datasetDefinition.addContent(datasetItems);

			for (int j = 0; j < q.getDatasetDefinitions().get(i)
					.getDatasetItems().size(); j++) {
				DatasetItem dataItem = datasetDef.getDatasetItems().get(j);
				datasetItem = new Element("dataset_item");
				datasetItems.addContent(datasetItem);

				number = new Element("number");
				datasetItem.addContent(number);
				number.addContent(dataItem.getNumber());

				value = new Element("value");
				datasetItem.addContent(value);
				value.addContent(dataItem.getValue());

			}

			Element numberOfItems =
					new Element("number_of_items");
			datasetDefinition.addContent(numberOfItems);
			numberOfItems.addContent(datasetDef.getNumberOfItems());
		}
	}

	/**.
	 * this method used to parse an element Cloze
	 * and add to the XML document
	 * @param q
	 *            Cloze object java, have to convert in XML
	 * @param question
	 *            element parent
	 */
	private static void convertCloze(Cloze q, Element question) {
		Attribute type = new Attribute("type", q.getType());
		question.setAttribute(type);

		Element name = new Element("name");
		question.addContent(name);
		Element text = new Element("text");
		name.addContent(text);
		text.addContent(q.getName());

		Element questiontext = new Element("questionText");
		question.addContent(questiontext);
		text = new Element("text");
		questiontext.addContent(text);
		text.addContent(q.getQuestiontext());

		Element generalfeedback = new Element("generalfeedback");
		question.addContent(generalfeedback);
		text = new Element("text");
		generalfeedback.addContent(text);
		text.addContent(q.getGeneralfeedback());

		Element shuffleanswers = new Element("shuffleanswer");
		question.addContent(shuffleanswers);
		shuffleanswers.addContent("" + q.isShuffleanswers());

	}

	/**.
	 * this method used to parse an element category
	 * and add to the XML document
	 * @param q
	 *            category object java, have to convert in XML
	 * @param question
	 *            element parent
	 */
	private static void convertCategory(Category q, Element question) {
		Attribute type = new Attribute("type", q.getType());
		question.setAttribute(type);

		Element category = new Element("category");
		question.addContent(category);
		Element text = new Element("text");
		category.addContent(text);
		text.addContent(q.getCategory());
	}

	/**.
	 * this method used to parse an element TrueFalse and add to the XML
	 * document
	 * @param q
	 *            TrueFalse object java, have to convert in XML
	 * @param question
	 *            element parent
	 */
	private static void convertTrueFalse(TrueFalse q, Element question) {
		Attribute type = new Attribute("type", q.getType());
		question.setAttribute(type);

		Element name = new Element("name");
		question.addContent(name);
		Element text = new Element("text");
		name.addContent(text);
		text.addContent(q.getName());

		Element questiontext = new Element("questionText");
		question.addContent(questiontext);
		Attribute format = new Attribute("format", q.getFormat());
		questiontext.setAttribute(format);
		text = new Element("text");
		questiontext.addContent(text);
		text.addContent(q.getQuestionText());

		Element image = new Element("image");
		question.addContent(image);
		image.addContent(q.getImage());

		Element generalfeedback = new Element("generalfeedback");
		question.addContent(generalfeedback);
		text = new Element("text");
		generalfeedback.addContent(text);
		text.addContent(q.getGeneralfeedback());

		Element defaultgradre = new Element("defaultgrade");
		question.addContent(defaultgradre);
		defaultgradre.addContent("" + q.getDefaultGrade());

		Element penalty = new Element("penalty");
		question.addContent(penalty);
		penalty.addContent("" + q.getPenalty());

		Element hidden = new Element("hidden");
		question.addContent(hidden);
		hidden.addContent("" + q.getHidden());

		Element shuffleanswers = new Element("shuffleanswer");
		question.addContent(shuffleanswers);
		shuffleanswers.addContent("" + q.getShuffleAnswers());

		Element answer, feedback;
		Attribute fraction;
		Answer current;
		for (int i = 0; i < q.getAnswers().size(); i++) {
			current = q.getAnswers().get(i);
			answer = new Element("answer");
			question.addContent(answer);
			fraction = new Attribute("fraction",
					current.getFraction());
			answer.setAttribute(fraction);

			text = new Element("text");
			answer.addContent(text);
			text.addContent(current.getText());

			feedback = new Element("feedback");
			answer.addContent(feedback);
			text = new Element("text");
			feedback.addContent(text);
			text.addContent(current.getFeedback());
		}

	}

	/**.
	 * this method used to parse an element Essay
	 * and add to the XML document
	 * @param q
	 *            Essay object java, have to convert in XML
	 * @param question
	 *            element parent
	 */
	private static void convertEssay(Essay q, Element question) {
		Attribute type = new Attribute("type", q.getType());
		question.setAttribute(type);

		Element name = new Element("name");
		question.addContent(name);
		Element text = new Element("text");
		name.addContent(text);
		text.addContent(q.getName());

		Element questiontext = new Element("questionText");
		question.addContent(questiontext);
		Attribute format = new Attribute("format", q.getFormat());
		questiontext.setAttribute(format);
		text = new Element("text");
		questiontext.addContent(text);
		text.addContent(q.getQuestionText());

		Element image = new Element("image");
		question.addContent(image);
		image.addContent(q.getImage());

		Element generalfeedback = new Element("generalfeedback");
		question.addContent(generalfeedback);
		text = new Element("text");
		generalfeedback.addContent(text);
		text.addContent(q.getGeneralfeedback());

		Element defaultgradre = new Element("defaultgrade");
		question.addContent(defaultgradre);
		defaultgradre.addContent("" + q.getDefaultGrade());

		Element penalty = new Element("penalty");
		question.addContent(penalty);
		penalty.addContent("" + q.getPenalty());

		Element hidden = new Element("hidden");
		question.addContent(hidden);
		hidden.addContent("" + q.isHidden());

		Element shuffleanswers = new Element("shuffleanswer");
		question.addContent(shuffleanswers);
		shuffleanswers.addContent("" + q.isShuffleAnswers());

		Element answer, feedback;
		Attribute fraction;
		Answer current;
		for (int i = 0; i < q.getAnswers().size(); i++) {
			current = q.getAnswers().get(i);
			answer = new Element("answer");
			question.addContent(answer);
			fraction = new Attribute("fraction",
					current.getFraction());
			answer.setAttribute(fraction);

			text = new Element("text");
			answer.addContent(text);
			text.addContent(current.getText());

			feedback = new Element("feedback");
			answer.addContent(feedback);
			text = new Element("text");
			feedback.addContent(text);
			text.addContent(current.getFeedback());
		}

	}

	/**.
	 * this method used to parse an element Matching
	 * and add to the XML document
	 * @param q
	 *            matching object java, have to convert in XML
	 * @param question
	 *            element parent
	 */
	private static void convertMatching(Matching q, Element question) {
		Attribute type = new Attribute("type", q.getType());
		question.setAttribute(type);

		Element name = new Element("name");
		question.addContent(name);
		Element text = new Element("text");
		name.addContent(text);
		text.addContent(q.getName());

		Element questiontext = new Element("questionText");
		question.addContent(questiontext);
		Attribute format = new Attribute("format", q.getFormat());
		questiontext.setAttribute(format);
		text = new Element("text");
		questiontext.addContent(text);
		text.addContent(q.getQuestionText());

		Element image = new Element("image");
		question.addContent(image);
		image.addContent(q.getImage());

		Element generalfeedback = new Element("generalfeedback");
		question.addContent(generalfeedback);
		text = new Element("text");
		generalfeedback.addContent(text);
		text.addContent(q.getGeneralfeedback());

		Element defaultgradre = new Element("defaultgrade");
		question.addContent(defaultgradre);
		defaultgradre.addContent("" + q.getDefaultGrade());

		Element penalty = new Element("penalty");
		question.addContent(penalty);
		penalty.addContent("" + q.getPenalty());

		Element hidden = new Element("hidden");
		question.addContent(hidden);
		hidden.addContent("" + q.isHidden());

		Element shuffleanswers = new Element("shuffleanswer");
		question.addContent(shuffleanswers);
		shuffleanswers.addContent("" + q.isShuffleAnswers());

		Element answer, subquestion;
		SubQuestion current;
		for (int i = 0; i < q.getSubQuestions().size(); i++) {
			current = q.getSubQuestions().get(i);

			subquestion = new Element("subquestion");
			question.addContent(subquestion);

			text = new Element("text");
			subquestion.addContent(text);
			text.addContent(current.getSubQuestionName());

			answer = new Element("answer");
			subquestion.addContent(answer);

			text = new Element("text");
			answer.addContent(text);
			text.addContent(current.getAnswerName());
		}
	}

	/**.
	 * this method used to parse an element Numerical and add to the XML
	 * document
	 * @param q
	 *            numerical object java, have to convert in XML
	 * @param question
	 *            element parent
	 */
	private static void convertNumerical(Numerical q, Element question) {
		Attribute type = new Attribute("type", q.getType());
		question.setAttribute(type);

		Element name = new Element("name");
		question.addContent(name);
		Element text = new Element("text");
		name.addContent(text);
		text.addContent(q.getName());

		Element questiontext = new Element("questionText");
		question.addContent(questiontext);
		Attribute format = new Attribute("format", q.getFormat());
		questiontext.setAttribute(format);
		text = new Element("text");
		questiontext.addContent(text);
		text.addContent(q.getQuestionText());

		Element image = new Element("image");
		question.addContent(image);
		image.addContent(q.getImage());

		Element generalfeedback = new Element("generalfeedback");
		question.addContent(generalfeedback);
		text = new Element("text");
		generalfeedback.addContent(text);
		text.addContent(q.getGeneralfeedback());

		Element defaultgradre = new Element("defaultgrade");
		question.addContent(defaultgradre);
		defaultgradre.addContent("" + q.getDefaultGrade());

		Element penalty = new Element("penalty");
		question.addContent(penalty);
		penalty.addContent("" + q.getPenalty());

		Element hidden = new Element("hidden");
		question.addContent(hidden);
		hidden.addContent("" + q.getHidden());

		Element shuffleanswers = new Element("shuffleanswer");
		question.addContent(shuffleanswers);
		shuffleanswers.addContent("" + q.getShuffleAnswers());

		Element answer, feedback;
		Attribute fraction;
		Answer current;
		for (int i = 0; i < q.getAnswers().size(); i++) {
			current = q.getAnswers().get(i);
			answer = new Element("answer");
			question.addContent(answer);
			fraction = new Attribute("fraction",
					current.getFraction());
			answer.setAttribute(fraction);

			text = new Element("text");
			answer.addContent(text);
			text.addContent(current.getText());

			Element tolerance = new Element("tolerance");
			answer.addContent(tolerance);
			tolerance.addContent(current.getTolerance());

			feedback = new Element("feedback");
			answer.addContent(feedback);
			text = new Element("text");
			feedback.addContent(text);
			text.addContent(current.getFeedback());
		}

	}

	/**.
	 * this method used to parse
	 * an element Multiple Choice and add to the XML
	 * document
	 *
	 * @param q
	 *          MultipleChoice calculated object java,
	 *          have to convert in XML
	 * @param question
	 *            element parent
	 */
	private static void convertMultipleChoice(MultipleChoice q,
			Element question) {
		Attribute type = new Attribute("type", q.getType());
		question.setAttribute(type);

		Element name = new Element("name");
		question.addContent(name);
		Element text = new Element("text");
		name.addContent(text);
		text.addContent(q.getName());

		Element questiontext = new Element("questionText");
		question.addContent(questiontext);
		Attribute format = new Attribute("format", q.getFormat());
		questiontext.setAttribute(format);
		text = new Element("text");
		questiontext.addContent(text);
		text.addContent(q.getQuestionText());

		Element image = new Element("image");
		question.addContent(image);
		image.addContent(q.getImage());
		Element image64 = new Element("image_base64");
		question.addContent(image64);
		image64.addContent(q.getImage_64());

		Element generalfeedback = new Element("generalfeedback");
		question.addContent(generalfeedback);
		text = new Element("text");
		generalfeedback.addContent(text);
		text.addContent(q.getGeneralfeedback());

		Element defaultgradre = new Element("defaultgrade");
		question.addContent(defaultgradre);
		defaultgradre.addContent("" + q.getDefaultGrade());

		Element penalty = new Element("penalty");
		question.addContent(penalty);
		penalty.addContent("" + q.getPenalty());

		Element hidden = new Element("hidden");
		question.addContent(hidden);
		hidden.addContent("" + q.getHidden());

		Element single = new Element("single");
		question.addContent(single);
		single.addContent(q.isSingle() + "");

		Element shuffleanswers = new Element("shuffleanswer");
		question.addContent(shuffleanswers);
		shuffleanswers.addContent("" + q.getShuffleAnswers());

		Element correctfeedback = new Element("correctfeedback");
		question.addContent(correctfeedback);
		text = new Element("text");
		correctfeedback.addContent(text);
		text.addContent(q.getCorrectFeedback());

		Element partiallycorrectfeedback = new Element(
				"partiallycorrectfeedback");
		question.addContent(partiallycorrectfeedback);
		text = new Element("text");
		partiallycorrectfeedback.addContent(text);
		text.addContent(q.getPartiallyCorrectFeedback());

		Element incorrectfeedback = new Element("incorrectfeedback");
		question.addContent(incorrectfeedback);
		text = new Element("text");
		incorrectfeedback.addContent(text);
		text.addContent(q.getIncorrectFeedback());

		Element answernumbering = new Element("answernumbering");
		question.addContent(answernumbering);
		answernumbering.addContent(q.getAnswerNumbering());

		Element answer, feedback;
		Attribute fraction;
		Answer current;
		for (int i = 0; i < q.getAnswers().size(); i++) {
			current = q.getAnswers().get(i);
			answer = new Element("answer");
			question.addContent(answer);
			fraction = new Attribute("fraction",
					current.getFraction());
			answer.setAttribute(fraction);

			text = new Element("text");
			answer.addContent(text);
			text.addContent(current.getText());

			feedback = new Element("feedback");
			answer.addContent(feedback);
			text = new Element("text");
			feedback.addContent(text);
			text.addContent(current.getFeedback());
		}

	}

	/**.
	 * this method used to parse an element Short Answer
	 * and add to the XML document
	 *
	 * @param q
	 *            ShortAnswer object java, have to convert in XML
	 * @param question
	 *            element parent
	 */
	private static void convertShortAnswer(ShortAnswer q,
			Element question) {
		Attribute type = new Attribute("type", q.getType());
		question.setAttribute(type);

		Element name = new Element("name");
		question.addContent(name);
		Element text = new Element("text");
		name.addContent(text);
		text.addContent(q.getName());

		Element questiontext = new Element("questionText");
		question.addContent(questiontext);
		Attribute format = new Attribute("format", q.getFormat());
		questiontext.setAttribute(format);
		text = new Element("text");
		questiontext.addContent(text);
		text.addContent(q.getQuestiontext());

		Element image = new Element("image");
		question.addContent(image);
		image.addContent(q.getImage());

		Element generalfeedback = new Element("generalfeedback");
		question.addContent(generalfeedback);
		text = new Element("text");
		generalfeedback.addContent(text);
		text.addContent(q.getGeneralfeedback());

		Element defaultgradre = new Element("defaultgrade");
		question.addContent(defaultgradre);
		defaultgradre.addContent("" + q.getDefaultgrade());

		Element penalty = new Element("penalty");
		question.addContent(penalty);
		penalty.addContent("" + q.getPenalty());

		Element hidden = new Element("hidden");
		question.addContent(hidden);
		hidden.addContent("" + q.isHidden());

		Element shuffleanswers = new Element("shuffleanswer");
		question.addContent(shuffleanswers);
		shuffleanswers.addContent("" + q.isShuffleanswers());

		Element usecase = new Element("usecase");
		question.addContent(usecase);
		usecase.addContent("" + q.getUsecase());

		Element answer, feedback;
		Attribute fraction;
		Answer current;
		for (int i = 0; i < q.getAnswers().size(); i++) {
			current = q.getAnswers().get(i);
			answer = new Element("answer");
			question.addContent(answer);
			fraction = new Attribute("fraction",
					current.getFraction());
			answer.setAttribute(fraction);

			text = new Element("text");
			answer.addContent(text);
			text.addContent(current.getText());

			feedback = new Element("feedback");
			answer.addContent(feedback);
			text = new Element("text");
			feedback.addContent(text);
			text.addContent(current.getFeedback());
		}
	}

	/**.
	 * Record the document XML in a file
	 *
	 * @param fichier
	 *            name of the file
	 * @param document
	 *            , the document XML
	 */
	private static void enregistre(String fichier, Document document) {
		XMLOutputter sortie =
				new XMLOutputter(Format.getPrettyFormat());
		try {
			FileOutputStream fic = new FileOutputStream(fichier);
			sortie.output(document, fic);
		} catch (Exception e) {
			System.err.println("Probleme au niveau"
					+ " de l'enregistrement");
			e.printStackTrace();
		}
	}

	/**.
	 * Show the document XML
	 *
	 * @param document
	 *            , the document XML
	 */
	private static void affiche(Document document) {
		XMLOutputter sortie =
				new XMLOutputter(Format.getPrettyFormat());
		try {
			sortie.output(document, System.out);
		} catch (IOException e) {
			System.err.println("Probleme au niveau de l'affichage");
			e.printStackTrace();
		}
	}

}
