package dma;

import java.util.Arrays;
import java.util.List;

public class Main {
  public static void main(String[] args) {
  
    List<String> mots = Arrays.asList("bonjour", "hello", "hola", "aurevoir", "goodbye", "adios" );
    
    System.out.printf("mots de la liste d'origine: %s.%n", mots);
    
    // liste des mots de moins de 5 lettres
    int longueurMax=5;
    List<String> motsCourts = ElementUtils.allMatches(mots, s -> s.length() < longueurMax);
    System.out.printf("mots courts (moins de %s lettres): %s.%n", longueurMax, motsCourts);
    
    // liste des mots comportant la lettre 'b'
    String alpha = "b";
    List<String> motsAvecB = ElementUtils.allMatches(mots, s -> s.contains(alpha));
    System.out.printf("mots avec la lettre %s: %s.%n", alpha, motsAvecB);
    
    // liste des mots ne comportant pas la lettre 'e'
    String beta = "e";
    List<String> motsSansE = ElementUtils.allMatches(mots, s -> !s.contains(beta));
    System.out.printf("mots ne comportant pas la lettre %s: %s.%n", beta, motsSansE);
    
    // liste des mots de longueur paire
    List<String> motsLongueurPaire = ElementUtils.allMatches(mots, s -> (s.length() % 2) == 0);
    System.out.printf("mots de longueur paire: %s.%n", motsLongueurPaire);
    
    System.out.println();
    
    Voiture veyron = new Voiture("Veyron", "Bugatti", 2000_000.0, 407);
    Voiture agera = new Voiture("Agera", "Koenigsegg", 1500_000.0, 420);
    Voiture aventador = new Voiture("Aventador", "Lamborghini", 350_000.0, 350);
    List<Voiture> voitures = Arrays.asList(veyron, agera, aventador );
    
    System.out.println("Liste des voitures de rêve:");
    /*
    for(Voiture v: voitures){
    	System.out.println(v);
    }
    */
    voitures.forEach(System.out::println);
    System.out.println();
    
    // liste des voitures dont le prix dépasse 1M€
    double prix = 1000_000;
    List<Voiture> voituresCheres = ElementUtils.allMatches(voitures, v -> (v.getPrix() > prix));
    System.out.printf("voiture(s) de plus de %s €: %s.%n", prix, voituresCheres);
    
    // liste des voitures dont la vitesse maxi dépasse 400 km/h
    double vitesseMax = 400;
    List<Voiture> voituresRapides = ElementUtils.allMatches(voitures, v -> (v.getVitesseMax() > vitesseMax));
    System.out.printf("voiture(s) dépassant %s km/h: %s.%n", vitesseMax, voituresRapides);  
  }
}
