package dcll.projet.quizzer;

import java.io.File;
import java.text.NumberFormat;
import java.text.ParseException;
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
	private Element racine;

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
		List questions = racine.getChildren("question");

		Questionnaire quiz = new Questionnaire("MyQuiz", questions);

		// On crée un Iterator sur notre liste
		Iterator i = questions.iterator();
		i.next();//on saute le premier element catégorie
		while (i.hasNext()) {
			// On recrée l'Element courant à chaque tour de boucle afin de
			// pouvoir utiliser les méthodes propres aux Element comme :
			// selectionner un noeud fils, modifier du texte, etc...
			Element courant = (Element) i.next();
			if( courant.getAttributeValue("type").trim().equals("cloze")) {
				
			}
			else xmlToJavaQuestion(courant, quiz);
		}

	}

	public void xmlToJavaQuestion(Element e, Questionnaire quiz) {
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
		String type = e.getAttributeValue("type").trim();
		System.out.println(type);
		if (type.equals("multichoice")) {
			xmlMultipleChoiceToJava(name, questionText, format, defaultgrade,
					penalty, shuffleanswers, hidden, answers, type, quiz);
		}
		if (type.equals("shortanswer")) {
			xmlShortAnswer(name, questionText, format, defaultgrade,
					penalty, shuffleanswers, hidden, answers, type, quiz);
		} else {
			System.out.println("Ce type de question n'est pas encore supporté");
		}
	}

	public void xmlMultipleChoiceToJava(String name, String questionText, String format, int defaultgrade, double penalty, boolean shuffleanswers, boolean hidden, List<Answer> answers, String type, Questionnaire quiz) {
		// MultipleChoice myQuestion = new MultipleChoice();

		System.out.println("Traitement de MultipleChoice");

		// quiz.getQuestions().add(myQuestion);
	}

	public void xmlShortAnswer(String name, String questionText, String format, int defaultgrade, double penalty, boolean shuffleanswers, boolean hidden, List<Answer> answers, String type, Questionnaire quiz) {

		ShortAnswer myQuestion = new ShortAnswer(name, questionText,
				defaultgrade, penalty, shuffleanswers, hidden, answers, format);
		System.out.println(myQuestion);
	}

}
