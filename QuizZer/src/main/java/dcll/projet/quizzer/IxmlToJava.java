package dcll.projet.quizzer;

/**
 * This class contains the definition of the xmlToJava Parser used to parse xml
 * document into java objects
 *
 * @author Eros Luce, Clement Bardou, Christelle Lacan, Thierno Bah
 *
 */
public interface IxmlToJava {

	/**
	 * This method is used to load xml document myFile and launch the
	 * parsing of the xml document.
	 *
	 * @param myFile : Le fichier a parser
	 * @return quiz
	 */
	Questionnaire run(String myFile);
}
