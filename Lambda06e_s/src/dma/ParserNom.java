package dma;

public class ParserNom {
    
    public static void main(String[] atgs0){
    	ParserNom parser = new ParserNom();

    	Personne pers1 = parser.parse("Eric CLAPTON 1945", 
    			(s1, s2, age) -> new Personne(s1,s2, age));     	
    	System.out.println(pers1);
    	
    	Personne pers3 = parser.parse("Mark Knopfler 1949", 
    			(s1, s2, age) -> PersonneFactory.create(s1, s2, age)); 
    	System.out.println(pers3);
    	
    	Personne pers4 = parser.parse("Robbie Williams 1974",
    			(s1, s2, age) -> new PersonneFactory().build(s1, s2, age) );
    	System.out.println(pers4);
    	
    }
    
    public Personne parse(String personne, PersonneBuilder builder) {
        String[] tokens = personne.split(" ");
        String nom="", prenom="";
        int age=0;
        if(tokens.length == 3){
        	prenom = tokens[0];
        	nom = tokens[1];
        	age = 2014 - Integer.parseInt(tokens[2]);	
        }else{
        	System.err.println("l'information passée doit comporter: prénom nom dateNaisance");
        	System.exit(1);
        }
        return builder.create(nom, prenom, age);      
    }
}

interface PersonneBuilder {
    Personne create(String nom, String prenom, int age);
}

class PersonneFactory {
    public static Personne create(String nom, String prenom, int age) {
        return new Personne(nom, prenom, age);
    }
    
    public Personne build(String nom, String prenom, int age) {
        return new Personne(nom, prenom, age);
    }
}
