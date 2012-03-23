package dcll.projet.quizzer;

/**
 * API running.
 */
public final class App {

	/**
	 * @param args
	 *            arguments
	 */
	public static void main(final String[] args) {
		String myFile = "../xmldoc/quiz.xml";
		IxmlToJava myXmlToJavaParser = new XmlToJava();
		Questionnaire myQuiz = myXmlToJavaParser.run(myFile);

		System.out.println(myQuiz);

		String fichier = "src/main/java/dcll/projet/xmldoc/JavaToXml.xml";
		IjavaToXml myJavaToXmlParser = new JavaToXml();
		myJavaToXmlParser.run(myQuiz, fichier);
	}

	/**
	 * Private Constructor (Utilitary class).
	 */
	private App() {

	}
}
