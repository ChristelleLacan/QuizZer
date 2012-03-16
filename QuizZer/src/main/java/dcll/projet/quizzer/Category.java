package dcll.projet.quizzer;


public class Category extends Question {
	
	private String category;
	private String type;
	private static String name = "Category";
			
		public Category(String Ctext) {
			super(name);
			category=Ctext;
			type="Category";
			// TODO Auto-generated constructor stub
		}

		public String toString(){
			return "\n----Ceci est une "+ type +" : \n"+
					"category : "+category+"\n";
		}

		public String getCategory() {
			return category;
		}
	


}
