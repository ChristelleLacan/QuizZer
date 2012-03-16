package dcll.projet.quizzer;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

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
		List questionsXML = racine.getChildren("question");

		ArrayList<Question> questions = new ArrayList<Question>();
		Questionnaire quiz = new Questionnaire("MyQuiz", questions);

		// On crée un Iterator sur notre liste
		Iterator i = questionsXML.iterator();
		i.next();// on saute le premier element catégorie
		while (i.hasNext()) {
			// On recrée l'Element courant à chaque tour de boucle afin de
			// pouvoir utiliser les méthodes propres aux Element comme :
			// selectionner un noeud fils, modifier du texte, etc...
			Element courant = (Element) i.next();
			String type = courant.getAttributeValue("type").trim();
			//System.out.println(type);
			if (type.equals("cloze")) {

			}
			if (type.equals("multichoice")) {
				xmlMultipleChoiceToJava(courant, quiz);
			}
			if (type.equals("shortanswer")) {
				xmlShortAnswerJava(courant, quiz);
			}
		}
		System.out.println(quiz.toString());

	}

	// Gestion des reponses
	public Answer xmlToJavaAnswer(Element e) {
		String text = e.getChildTextTrim("text");
		float fraction = Float.parseFloat(e.getAttributeValue("fraction").trim());
		String feedback = e.getChild("feedback").getChildTextTrim("text");
		Answer a = new Answer(text, fraction, feedback);
		//System.out.println("Voici les reponces : " + a);
		return a;
	}
	
	//Gestion de xml vers java : DESCRIPTION
	public void xmlDescriptionToJava(Element e, Questionnaire quizz) {
		
	}

	// Gestion de xml vers java : MULTIPLE CHOICE
	public void xmlMultipleChoiceToJava(Element e, Questionnaire quiz) { 
		String name = e.getChild("name").getChildTextTrim("text");
		String questionText = e.getChild("questiontext").getChildTextTrim(
				"text");
		String format = e.getChild("questiontext").getAttributeValue("format")
				.trim();
		int defaultgrade = Integer.parseInt(e.getChildTextTrim("defaultgrade"));
		NumberFormat myFormat = NumberFormat.getInstance();
		double penalty = 0;
		try {
			penalty = myFormat.parse(e.getChildTextTrim("penalty"))
					.doubleValue();
		} catch (ParseException e1) {
			System.out.println("Erreur Format de penalty : " + e1);
		}

		boolean shuffleanswers = Boolean.valueOf(
				e.getChildTextTrim("shuffleanswers")).booleanValue();
		boolean hidden = Boolean.valueOf(e.getChildTextTrim("hidden"))
				.booleanValue();
		
		List<Answer> answers = new ArrayList<Answer>();
		List answersRes = e.getChildren("answer");
		System.out.println(answersRes);

		Iterator i = answersRes.iterator();
		// parcours toutes les réponses
		while (i.hasNext()) {
			Element courant = (Element) i.next();
			answers.add(xmlToJavaAnswer(courant));
		}
		
		MultipleChoice myQuestion = new MultipleChoice(name, questionText, defaultgrade, penalty, shuffleanswers, hidden, answersRes, format);
		
		quiz.getQuestions().add(myQuestion);
	}

	// Gestion de xml vers java : SHORT ANSWER
	public void xmlShortAnswerJava(Element e, Questionnaire quiz) {
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

		List answersRes = e.getChildren("answer");
		System.out.println(answersRes);

		Iterator i = answersRes.iterator();
		// parcours toutes les réponses
		while (i.hasNext()) {
			Element courant = (Element) i.next();
			answers.add(xmlToJavaAnswer(courant));
		}

		// CREATION DE L'OBJET SHORT ANSWER
		ShortAnswer myQuestion = new ShortAnswer(name, questionText,
				defaultgrade, penalty, shuffleanswers, hidden, answers, format);

		// AFFICHAGE DE CET OBJET
		//System.out.println(myQuestion);

		quiz.getQuestions().add(myQuestion);
		
	}

}
