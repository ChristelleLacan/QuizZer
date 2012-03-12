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
			document = sxb.build(this.getClass().getResourceAsStream("../xmldoc/quiz.xml"));
			// Le parsing est terminé ;)
		} catch (Exception e) {
		}

		// On initialise un nouvel élément racine avec l'élément racine du
		// document.
		racine = document.getRootElement();
	}
	public void run() {
		
	}

}
