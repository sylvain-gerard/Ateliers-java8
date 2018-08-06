package dma;

import java.util.Arrays;

public class TriChaines {
  public static void main(String[] args) {
	String[] mots = { "bonjour", "hello", "hola", "aurevoir", "goodbye", "adios" };
    
	System.out.println("tableau d'origine: " + 
    			Arrays.asList(mots));
    
	Arrays.sort(mots, (s1, s2)->(s1.length()-s2.length()));
	System.out.println("longueur croissante des chaines: " + 
			Arrays.asList(mots));
	
	Arrays.sort(mots, (s1, s2)->(s2.length()-s1.length()));
	System.out.println("longueur décroissante des chaines: " + 
			Arrays.asList(mots));
	
	Arrays.sort(mots, (s1, s2)->(s1.charAt(0)-s2.charAt(0)));
	System.out.println("order alphabétique sur 1e lettre: " + 
			Arrays.asList(mots));
	
	//TODO
	System.out.println("chaînes contenant la lettre 'e' suivi de celles ne la contenant pas: " + 
			Arrays.asList(mots));
	
	
  }
}
