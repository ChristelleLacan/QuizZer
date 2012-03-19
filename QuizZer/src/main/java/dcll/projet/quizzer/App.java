package dcll.projet.quizzer;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	String myFile = "../xmldoc/quiz.xml";
        IxmlToJava myXmlToJavaparser = new XmlToJava();
        Questionnaire myQuiz = myXmlToJavaparser.run(myFile);
        myQuiz.toString();
        
        
    }
}
