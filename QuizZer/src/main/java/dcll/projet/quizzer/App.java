package dcll.projet.quizzer;

/**
 * API running
 * 
 */
public class App {
	public static void main(String[] args) {
		String myFile = "../xmldoc/quiz.xml";
		IxmlToJava myXmlToJavaParser = new XmlToJava();
		Questionnaire myQuiz = myXmlToJavaParser.run(myFile);

		System.out.println(myQuiz);

		String fichier = "src/main/java/dcll/projet/xmldoc/JavaToXml.xml";
		IjavaToXml myJavaToXmlParser = new JavaToXml();
		myJavaToXmlParser.run(myQuiz, fichier);
	}
}
