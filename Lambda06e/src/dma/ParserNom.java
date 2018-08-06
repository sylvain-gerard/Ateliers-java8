package dma;

public class ParserNom {
    
    public static void main(String[] atgs0){
    	ParserNom parser = new ParserNom();

    	Personne pers1 = parser.parse("Eric Clapton 1945", new PersonneBuilder() {
    	    @Override
    	    public Personne create(String firstName, String lastName, int age) {
    	        return new Personne(firstName, lastName, age);
    	    }
    	});
    	System.out.println(pers1);
    	
       	Personne pers2 = parser.parse("Mark Knopfler 1949", new PersonneBuilder() {
    	    @Override
    	    public Personne create(String firstName, String lastName, int age) {
    	        return new Personne(firstName, lastName, age);
    	    }
    	});
    	System.out.println(pers2);

      	Personne pers3 = parser.parse("Robbie Williams 1974", new PersonneBuilder() {
    	    @Override
    	    public Personne create(String firstName, String lastName, int age) {
    	        return new Personne(firstName, lastName, age);
    	    }
    	});
    	System.out.println(pers3);
    	
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
