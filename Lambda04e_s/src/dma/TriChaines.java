package dma;

import java.util.Arrays;

public class TriChaines {
  public static void main(String[] args) {
	String[] mots = { "bonjour", "hello", "hola", "aurevoir", "goodbye", "adios" };
    
	System.out.println("tableau d'origine: " + 
    			Arrays.asList(mots));
    
	Arrays.sort(mots, (s1, s2) -> s1.length() - s2.length());
    System.out.println("tableau tri� par longueur croissante des cha�nes: " + 
    			Arrays.asList(mots));
    
    Arrays.sort(mots, (s1, s2) -> s2.length() - s1.length());
    System.out.println("tableau tri� par longueur d�croissante des cha�nes: " + 
    			Arrays.asList(mots));
    
    Arrays.sort(mots, (s1, s2) -> s1.charAt(0) - s2.charAt(0));
    System.out.println("tableau tri� dans l'ordre alphab�tique sur la premi�re lettre:" + 
    			Arrays.asList(mots));
    

    Arrays.sort(mots, (s1, s2) -> 
	    { if(s1.contains("e") && !s2.contains("e")) return -1;
	      else if(s2.contains("e") && !s1.contains("e")) return 1;
	      else return 0;
	    });
 
    System.out.println("tableau tri� par cha�nes contenant la lettre 'e' suivi de celles ne la contenant pas [v1] : "+ 
                Arrays.asList(mots));
    
  }
}
