package dma;

import java.util.Arrays;
import java.util.List;

public class Main {
  public static void main(String[] args) {
  
    List<String> mots = Arrays.asList("bonjour", "hello", "hola", "aurevoir", "goodbye", "adios" );
    
    System.out.printf("mots de la liste d'origine: %s.%n", mots);
    
    // liste des mots de moins de 5 lettres
    int longueurMax=5;
    List<String> motsCourts = StringUtils.allMatches(mots, s -> s.length() < longueurMax);
    System.out.printf("mots courts (moins de %s lettres): %s%n", longueurMax, motsCourts);
    
    // liste des mots comportant la lettre 'b'
    String alpha = "b";
    List<String> motsAvecB = StringUtils.allMatches(mots, s -> s.contains(alpha));
    System.out.printf("mots avec la lettre %s: %s%n", alpha, motsAvecB);
    
    // liste des mots ne comportant pas la lettre 'e'
    String beta = "e";
    List<String> motsSansE = StringUtils.allMatches(mots, s -> !s.contains(beta));
    System.out.printf("mots ne comportant pas la lettre %s: %s%n", beta, motsSansE);
    
    // liste des mots de longueur paire
    List<String> motsLongueurPaire = StringUtils.allMatches(mots, s -> (s.length() % 2) == 0);
    System.out.printf("mots de longueur paire: %s%n", motsLongueurPaire);
  }
}
