package dcll.projet.quizzer;


import java.io.File;
import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;



public class JavaToXml extends DefaultHandler{

	private boolean inQuestion,inAnswer,inText,inFeedback;
	Answer answer;
	String lecture;
	int fract;
	
	public void startDocument() {
		System.out.println("******** DEBUT DOCUMENT *************");
	}

	public void endDocument() {
		System.out.println("********* FIN DOCUMENT *************");
	}

	public void startElement(String uri,
			String localName,
			String qName,
			Attributes attributes)
					throws SAXException {
		if(qName.equals("question") )
			{
			inQuestion=true;
			answer=new Answer();
			try{
				String typ = attributes.getValue("truefalse");
				//if()
				answer.setType(typ);
				System.out.println(qName+""+typ+""+answer.getQuestion());
			}catch(Exception e){
				System.out.println("la question n'est pas de type truefalse");
				throw new SAXException(e);
			}
			
		
			} 
		else if(qName.equals("answer") && inQuestion){
			inAnswer=true;	
			try{
				 fract = Integer.parseInt(attributes.getValue("fraction"));
				answer.setFraction(fract);
				System.out.println(qName+""+fract);
			}catch(Exception e){
				System.out.println("le contenu n'est pas un entier");
				throw new SAXException(e);
			}
		
			
			}
		else if(qName.equals("text") && inQuestion){
			inText=true;	
			System.out.println(qName+""+answer.getText());
			
			}
		else if(qName.equals("feedback") && inQuestion){
			inFeedback=true;	
			System.out.println(qName+""+answer.getFeedback());
			}
		
			
			}

	public void endElement(String uri,
			String localName,
			String qName)
					throws SAXException {
		if(qName.equals("question"))
		{
			inQuestion=false;
		}
     
		else if(qName.equals("answer") && inQuestion){
		
	inAnswer=false;	
	}
		else if(qName.equals("text") && inQuestion){
		inText=false;	
		}
		else if(qName.equals("feedback") && inQuestion){
		inFeedback=false;	
		}
	//on passe à  la ligne
		System.out.println(""); 
	}

	@SuppressWarnings("static-access")
	public void characters(char[] ch, int start, int length) throws SAXException{
	    lecture=new String(ch,start,length);
		System.out.print(" ( " + lecture.copyValueOf(ch,start,length)+ " ) ");
		
		if(inQuestion){
			answer=new Answer();
			answer.setQuestion(lecture);
		}
		else if(inAnswer && inQuestion){
			answer.setText(lecture);
		}
		else if(inAnswer && inQuestion){
			answer.setType(lecture);
			
		}
		else if(inAnswer && inQuestion){
			answer.setFeedback(lecture);

		}
	}
	/**
	 * @param args
	 * @throws SAXException 
	 * @throws ParserConfigurationException 
	 * @throws IOException 
	 */
	public static void main(String[] args)
			throws ParserConfigurationException, SAXException, IOException {
		SAXParserFactory spf = SAXParserFactory.newInstance();
		SAXParser saxParser = spf.newSAXParser();
		//URL refFic = new URL("http://www.irit.fr/~Guillaume.Cabanac/docs/etu/yslav/EB_IS_2009.xml");
    File fic=new File("quiz.xml");
		saxParser.parse(fic, new JavaToXml());

	}

}
