package dcll.projet.quizzer;

/**
 * Hello world!
 * 
 */
public class App {
	public static void main(String[] args) {
		String myFile = "../xmldoc/quiz.xml";
		IxmlToJava myXmlToJavaParser = new XmlToJava();
		Questionnaire myQuiz = myXmlToJavaParser.run(myFile);

		System.out.println(myQuiz);
		
		String fichier = "src/main/java/dcll/projet/xmldoc/JavaToXml.xml";
		JavaToXml.run(myQuiz, fichier);
	}
}
