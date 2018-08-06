package dma;

public class Main {
  public static void main(String[] args) {
    String chaine1 = "Bonjour";
    String chaine2 = "Au Revoir";
    String message ="La meilleure des chaînes %s et %s concernant %s est %s.%n";
    
    /*
    String result1 = StringUtils.meilleureChaine(chaine1, chaine2, 
    		new PropositionChaine(){
				@Override
				public boolean estMeilleure(String s1, String s2) {
					return s1.length() > s2.length();
				}
    		});
    */
    String result1 = StringUtils.meilleureChaine(chaine1, chaine2, 
    		(s1, s2) -> s1.length() > s2.length());
    
    System.out.printf(message, chaine1, chaine2, "la longueur", result1);
    
    /*
    String result2 = StringUtils.meilleureChaine(chaine1, chaine2, 
    		new PropositionChaine(){
				@Override
				public boolean estMeilleure(String s1, String s2) {
					return true;
				}
    		});
    */
    String result2 = StringUtils.meilleureChaine(chaine1, chaine2, 
    		(s1, s2) -> true);
  	
    System.out.printf(message, chaine1, chaine2, "le premier argument", result2);
  }
}
