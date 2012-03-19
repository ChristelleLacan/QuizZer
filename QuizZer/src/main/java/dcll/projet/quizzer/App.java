package dcll.projet.quizzer;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        XmlToJava myXmlToJavaparser = new XmlToJava();
        myXmlToJavaparser.loadDocument();
        myXmlToJavaparser.run();
    }
}
