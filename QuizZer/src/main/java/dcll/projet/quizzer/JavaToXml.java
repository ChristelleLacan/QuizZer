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
import dcll.projet.quizzer.typesQuestions.element.SubQuestion;

public class JavaToXml implements IjavaToXml {

	public void run(Questionnaire quiz, String fichier) {
		Element racine = new Element(quiz.getRacine());
		Document document = new Document(racine);
		for (int i = 0; i < quiz.getQuestions().size(); i++) {
			Element question = new Element("question");
			racine.addContent(question);
			Question q = quiz.getQuestions().get(i);
			if (q instanceof Cloze) {
				convertCloze((Cloze) q, question);
			} else if (q instanceof MultipleChoice) {
				convertMultipleChoice((MultipleChoice) q, question);
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

	private static void convertDescription(Description q, Element question) {
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
			fraction = new Attribute("fraction", current.getFraction());
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

			Element correctanswerformat = new Element("correctanswerformat");
			answer.addContent(correctanswerformat);
			correctanswerformat.addContent(current.getCorrectAnswerFormat());

			Element correctanswerlength = new Element("correctanswerlength");
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
			Element unit_name = new Element("unit_name");
			unit.addContent(multiplier);
			unit.addContent(unit_name);
			multiplier.addContent(q.getUnits().get(i).getMultiplier());
			unit_name.addContent(q.getUnits().get(i).getUnitName());
		}

		Element dataset_definitions = new Element("dataset_definitions");
		question.addContent(dataset_definitions);

		Element status, dataset_definition, typ, distribution, minimum, maximum;
		Element decimals, itemcount, dataset_items, dataset_item, number, value;
		for (int i = 0; i < q.getDatasetDefinitions().size(); i++) {
			dataset_definition = new Element("dataset_definition");
			dataset_definitions.addContent(dataset_definition);

			status = new Element("status");
			dataset_definition.addContent(status);
			text = new Element("text");
			status.addContent(text);
			text.addContent(q.getDatasetDefinitions().get(i).getStatus());

			name = new Element("name");
			dataset_definition.addContent(name);
			text = new Element("text");
			name.addContent(text);
			text.addContent(q.getDatasetDefinitions().get(i).getName());

			typ = new Element("type");
			dataset_definition.addContent(typ);
			typ.addContent(q.getDatasetDefinitions().get(i).getType());

			distribution = new Element("distribution");
			dataset_definition.addContent(distribution);
			text = new Element("text");
			distribution.addContent(text);
			text.addContent(q.getDatasetDefinitions().get(i).getDistribution());

			minimum = new Element("minimum");
			dataset_definition.addContent(minimum);
			text = new Element("text");
			minimum.addContent(text);
			text.addContent(q.getDatasetDefinitions().get(i).getMinimum());

			maximum = new Element("maximum");
			dataset_definition.addContent(maximum);
			text = new Element("text");
			maximum.addContent(text);
			text.addContent(q.getDatasetDefinitions().get(i).getMaximum());

			decimals = new Element("decimals");
			dataset_definition.addContent(decimals);
			text = new Element("text");
			decimals.addContent(text);
			text.addContent(q.getDatasetDefinitions().get(i).getDecimals());

			itemcount = new Element("itemcount");
			dataset_definition.addContent(itemcount);
			itemcount.addContent(q.getDatasetDefinitions().get(i)
					.getItemCount());

			dataset_items = new Element("dataset_items");
			dataset_definition.addContent(dataset_items);

			for (int j = 0; j < q.getDatasetDefinitions().get(i)
					.getDatasetItems().size(); j++) {
				dataset_item = new Element("dataset_item");
				dataset_items.addContent(dataset_item);

				number = new Element("number");
				dataset_item.addContent(number);
				number.addContent(q.getDatasetDefinitions().get(i)
						.getDatasetItems().get(j).getNumber());

				value = new Element("value");
				dataset_item.addContent(value);
				value.addContent(q.getDatasetDefinitions().get(i)
						.getDatasetItems().get(j).getValue());

			}

			Element number_of_items = new Element("number_of_items");
			dataset_definition.addContent(number_of_items);
			number_of_items.addContent(q.getDatasetDefinitions().get(i)
					.getNumberOfItems());
		}
	}

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

	private static void convertCategory(Category q, Element question) {
		Attribute type = new Attribute("type", q.getType());
		question.setAttribute(type);

		Element category = new Element("category");
		question.addContent(category);
		Element text = new Element("text");
		category.addContent(text);
		text.addContent(q.getCategory());
	}

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
			fraction = new Attribute("fraction", current.getFraction());
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
			fraction = new Attribute("fraction", current.getFraction());
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
			fraction = new Attribute("fraction", current.getFraction());
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

	private static void convertMultipleChoice(MultipleChoice q, Element question) {
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
			fraction = new Attribute("fraction", current.getFraction());
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

	private static void convertShortAnswer(ShortAnswer q, Element question) {
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
			fraction = new Attribute("fraction", current.getFraction());
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

	private static void enregistre(String fichier, Document document) {
		XMLOutputter sortie = new XMLOutputter(Format.getPrettyFormat());
		try {
			FileOutputStream fic = new FileOutputStream(fichier);
			sortie.output(document, fic);
		} catch (Exception e) {
			System.err.println("Probleme au niveau de l'enregistrement");
			e.printStackTrace();
		}
	}

	private static void affiche(Document document) {
		XMLOutputter sortie = new XMLOutputter(Format.getPrettyFormat());
		try {
			sortie.output(document, System.out);
		} catch (IOException e) {
			System.err.println("Probleme au niveau de l'affichage");
			e.printStackTrace();
		}
	}

}
