package dma;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class Main {
  public static void main(String[] args) {
  
    List<String> mots = Arrays.asList("bonjour", "hello", "hola", "aurevoir", "goodbye", "adios" );
    
    System.out.printf("mots de la liste d'origine: %s.%n", mots);
    
    System.out.println("------------------------------------------------------------------------------");
    // Afficher chaque mot de la liste sur une ligne, précédé de deux 
    // caractères espace (utiliser une expression Lambda)
    
    System.out.println("liste des mots, un par ligne, précédé de deux espaces:");
    mots.stream().forEach(s -> System.out.println("  " + s));
    
    System.out.println("------------------------------------------------------------------------------");
    // Afficher chaque mot de la liste sur une ligne, sans espace avant
	// (utiliser une référence de méthode)
    
    System.out.println("liste des mots, un par ligne, sans espace avant:");
    mots.stream().forEach(System.out::println);
    
    System.out.println("------------------------------------------------------------------------------");    
    // remplacer les transformations suivantes (en commentaires) effectuées dans les projets 
    // précédents par l'utilisation des méthodes map et collect sur un stream
	
	// List<String> exclamation = ElementUtils.transformedList(mots, s -> s + "!");
    List<String> exclamation = mots.stream()
                                   .map(s -> s + "!")
                                   .collect(Collectors.toList());
    System.out.printf("mots avec point d'exclamation: %s.%n", exclamation);

    System.out.println("------------------------------------------------------------------------------");
    // List<String> motsAvec_i = ElementUtils.transformedList(mots, s -> s.replace("i", "y"));
    List<String> motsAvec_i = mots.stream()
                                 .map(s -> s.replace("i", "y"))
                                 .collect(Collectors.toList());
    System.out.printf("mots avec le caractère i remplacé par y: %s.%n", motsAvec_i);
    
    System.out.println("------------------------------------------------------------------------------");
    // List<String> majuscules = ElementUtils.transformedList(mots, String::toUpperCase);
    List<String> majuscules = mots.stream()
                                       .map(String::toUpperCase)
                                       .collect(Collectors.toList());
    System.out.printf("mots en majuscules: %s.%n", majuscules);
    
    System.out.println("------------------------------------------------------------------------------");
	// remplacer les transformations suivantes (en commentaires) effectuées dans les projets 
    // précédents par l'utilisation des méthodes filter et collect sur un Stream

	
    // List<String> motsCourts = ElementUtils.allMatches(mots, s -> s.length() < longueurMax); 
    List<String> motsCourts = mots.stream()
                                   .filter(s -> s.length() < 5)
                                   .collect(Collectors.toList());
    System.out.printf("mots courts: %s.%n", motsCourts);
    
    System.out.println("------------------------------------------------------------------------------");
    // List<String> motsAvecB = ElementUtils.allMatches(mots, s -> s.contains(alpha));
    List<String> motsAvecB = mots.stream()
                                   .filter(s -> s.contains("b"))
                                   .collect(Collectors.toList());
    System.out.printf("mots avec lettre b: %s.%n", motsAvecB);
    
    System.out.println("------------------------------------------------------------------------------");
    // List<String> motsLongueurPaire = ElementUtils.allMatches(mots, s -> (s.length() % 2) == 0);
    List<String> motsLongueurPaire = mots.stream()
                                   .filter(s -> (s.length() % 2) == 0)
                                   .collect(Collectors.toList());
    System.out.printf("mots de longueur paire: %s.%n", motsLongueurPaire);
    
    System.out.println("------------------------------------------------------------------------------");
    // transformer les mots en majuscules, ne conserver que ceux de moins de 5
    // lettres, et parmi ces derniers, ne conserver que ceux qui contiennent 
    // la lettre 'O', puis afficher le résultat.
    
    List<String> resultat1 = streamSurString(mots, "O");
    System.out.println("mot court en majuscules avec lettre 'O': " + resultat1);
    

    System.out.println("------------------------------------------------------------------------------");
    // Recommencer l'opération, mais avec le caractère 'L' 
    List<String> resultat2 = streamSurString(mots, "L");
    System.out.println("mot court en majuscules avec lettre 'L': " + resultat2);
    
    
    System.out.println("------------------------------------------------------------------------------");
    
    // montrer qu'en modifiant l'ordre des instructions ci-dessus, il apparaît que 
    // l'évaluation est de type lazy 
    //(chercher quels mots sont changés en majuscules)                                     
    
    String resultat3 = mots.stream()
    	    			  .map(String::toUpperCase)
    					  .peek(System.out::println)
    	    			  .filter(s -> s.length() < 5)
    	    			  .filter(s -> s.contains("L"))
                          .findFirst().orElse("Pas de correspondance");
    System.out.println("mot court en majuscules avec lettre  'L': " + resultat3);
    
    System.out.println("------------------------------------------------------------------------------");
    // Placer chaque mot de la liste dans un tableau, lequel sera ensuite affiché 
    // comme un tableau
    
    String[] exclamation2 = mots.stream()
                           .map(s -> s + "!")
                           .toArray(String[]::new);
    System.out.printf("mots avec point d'exclamation dans tableau: %s.%n", Arrays.asList(exclamation2));
  }
  
  public static List<String> streamSurString(List<String> mots, String chaine) {
	    return mots.stream()
	           .map(String::toUpperCase)
	           .peek(System.out::println)
	           .filter(s -> s.length() < 5)
	           .filter(s -> s.contains(chaine))
	           .collect(Collectors.toList());
  }  
  
  public static String streamSurStringFirst(List<String> mots, String chaine) {
    String resultat = mots.stream()
           .map(String::toUpperCase)
           .peek(System.out::println)
           .filter(s -> s.length() < 5)
           .filter(s -> s.contains(chaine))
           .findFirst().orElse("Pas de correspondance");
    return(resultat);
  }   
}
