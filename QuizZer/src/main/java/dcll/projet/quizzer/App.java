package dcll.projet.quizzer;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        XmlToJava myParser = new XmlToJava();
        myParser.loadDocument();
        myParser.run();
    }
}
