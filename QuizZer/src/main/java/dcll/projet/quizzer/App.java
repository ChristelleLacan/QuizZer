package dcll.projet.quizzer;

/**
 * Hello world!
 * 
 */
public class App {
	public static void main(String[] args) {
		String myFile = "../xmldoc/quiz.xml";
		XmlToJava myXmlToJavaParser = new XmlToJava();
		Questionnaire myQuiz = myXmlToJavaParser.run(myFile);

		System.out.println(myQuiz);
	}
}
