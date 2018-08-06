package dma;

import util.RepUtils;

public class Main {
	public static void main(String[] args) {
	
		System.out.println("===================================================");
		System.out.println("fichiers présents à la racine du projet:");
	    RepUtils.afficheTousLesCheminsDansRepertoire(".");
	    
	    System.out.println("===================================================");
	    System.out.println("fichiers texte présents à la racine du projet:");
	    RepUtils.afficheCheminsDansRepertoire(".", 
	                                p -> p.toString().endsWith(".txt"));
	  
	    System.out.println("===================================================");
	    System.out.println("fichiers se trouvant dans le projet:");
	    RepUtils.afficheTousLesCheminsDansArborescence(".");
	    
	    System.out.println("===================================================");
	    System.out.println("fichiers java présents dans le projet:");
	    RepUtils.afficheCheminsDansArborescence(".", 
	              p -> p.toString().endsWith(".java"));
	  
	    System.out.println("===================================================");
	    System.out.println("fichiers java présents dans le projet:");
	    RepUtils.rechercheCheminsDansArborescence(".", 
	        (path,attrs) -> path.toString().endsWith(".java"));
	    
	    System.out.println("===================================================");
	    System.out.println("répertoires présents dans le projet:");
	    RepUtils.rechercheCheminsDansArborescence(".", 
	        (path,attrs) -> attrs.isDirectory());
	    
	    System.out.println("===================================================");
	    System.out.println("petits fichiers (<100 octets) présents dans le projet:");
	    RepUtils.rechercheCheminsDansArborescence(".", 
	        (path,attrs) -> attrs.size() < 100);	
	}
}