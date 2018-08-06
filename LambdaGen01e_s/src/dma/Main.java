package dma;

public class Main {
  public static void main(String[] args) {
    String chaine1 = "Bonjour";
    String chaine2 = "Au Revoir";
    String message ="La meilleure des chaînes %s et %s concernant %s est %s.%n";
    
    String result1 = ElementUtils.meilleurElement(chaine1, chaine2, 
    		(s1, s2) -> s1.length() > s2.length());
    System.out.printf(message, chaine1, chaine2, "la longueur", result1);
    
    String result2 = ElementUtils.meilleurElement(chaine1, chaine2, 
    		(s1, s2) -> true);
    System.out.printf(message, chaine1, chaine2, "le premier argument", result2);
    
    Voiture veyron = new Voiture("Veyron", "Bugatti", 2000_000.0, 407);
    Voiture agera = new Voiture("Agera", "Koenigsegg", 1500_000.0, 420);
    
    Voiture voiturePrix = ElementUtils.meilleurElement(veyron, agera, 
    		(v1, v2) -> v1.getPrix() < v2.getPrix());
    System.out.printf("La meilleure des voitures concernant le prix est %s.%n", voiturePrix);
    
    Voiture voitureVitesse = ElementUtils.meilleurElement(veyron, agera, 
    		(v1, v2) -> v1.getVitesseMax() > v2.getVitesseMax());
    System.out.printf("La meilleure des voitures concernant la vitesse est %s.%n", voitureVitesse);
    
  }
}
