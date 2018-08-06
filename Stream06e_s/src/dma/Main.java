package dma;

import util.RepUtils;

public class Main {
	public static void main(String[] args) {
	
		System.out.println("===================================================");
		System.out.println("fichiers pr�sents � la racine du projet:");
	    RepUtils.afficheTousLesCheminsDansRepertoire(".");
	    
	    System.out.println("===================================================");
	    System.out.println("fichiers texte pr�sents � la racine du projet:");
	    RepUtils.afficheCheminsDansRepertoire(".", 
	                                p -> p.toString().endsWith(".txt"));
	  
	    System.out.println("===================================================");
	    System.out.println("fichiers se trouvant dans le projet:");
	    RepUtils.afficheTousLesCheminsDansArborescence(".");
	    
	    System.out.println("===================================================");
	    System.out.println("fichiers java pr�sents dans le projet:");
	    RepUtils.afficheCheminsDansArborescence(".", 
	              p -> p.toString().endsWith(".java"));
	  
	    System.out.println("===================================================");
	    System.out.println("fichiers java pr�sents dans le projet:");
	    RepUtils.rechercheCheminsDansArborescence(".", 
	        (path,attrs) -> path.toString().endsWith(".java"));
	    
	    System.out.println("===================================================");
	    System.out.println("r�pertoires pr�sents dans le projet:");
	    RepUtils.rechercheCheminsDansArborescence(".", 
	        (path,attrs) -> attrs.isDirectory());
	    
	    System.out.println("===================================================");
	    System.out.println("petits fichiers (<100 octets) pr�sents dans le projet:");
	    RepUtils.rechercheCheminsDansArborescence(".", 
	        (path,attrs) -> attrs.size() < 100);	
	}
}