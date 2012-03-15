package dcll.projet.quizzer;

import java.io.File;
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
		List questions = racine.getChildren("question");

		Questionnaire quiz = new Questionnaire("MyQuiz", questions);

		// On crée un Iterator sur notre liste
		Iterator i = questions.iterator();
		while (i.hasNext()) {
			// On recrée l'Element courant à chaque tour de boucle afin de
			// pouvoir utiliser les méthodes propres aux Element comme :
			// selectionner un noeud fils, modifier du texte, etc...
			Element courant = (Element) i.next();
			// On affiche le nom de l'element courant
			String typeQ = courant.getAttributeValue("type").trim();
			System.out.println(typeQ);
			if(typeQ.equals("multichoice")) {
				xmlMultipleChoiceToJava(courant, quiz);
			}
			else{
				System.out.println("Ce type de question n'est pas encore supporté");
			}
		}

	}
	
	public void xmlMultipleChoiceToJava(Element e,Questionnaire quiz){
		MultipleChoice myQuestion = new MultipleChoice(null, null, 0, 0, false, false, null, null);
		
		System.out.println("Traitement de MultipleChoice");
		
		//quiz.getQuestions().add(myQuestion);		
	}

}
