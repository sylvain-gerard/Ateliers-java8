package dma;

import java.util.Arrays;
import java.util.List;

public class Main {
	public static void main(String[] args) {

		List<String> mots = Arrays.asList("bonjour", "hello", "hola", "aurevoir", "goodbye", "adios");
		System.out.printf("mots de la liste d'origine: %s.%n", mots);
		
		System.out.println("------------------------------------------------------------------------------");
    	// Produire une chaine de caract�res unique qui concat�ne tous les mots 
		// en majuscules, en utilisant reduce une seule fois, sans utiliser map
		
		String chaineUniqueMaj  = mots.stream().reduce("",
				(s1, s2) -> s1.toUpperCase() + s2.toUpperCase());
		System.out.printf("Chaine unique en majuscules: %s.%n", chaineUniqueMaj);

		System.out.println("------------------------------------------------------------------------------");
		// Produire le m�me r�sultat que pr�c�demment, mais via une op�ration map
		// qui transforme les mots en majuscules puis les concat�ne avec reduce
		
		String chaineUniqueMaj2 = mots.stream().map(String::toUpperCase)
				.reduce("", String::concat);
		System.out.printf("Chaine unique en majuscules: %s.%n", chaineUniqueMaj2);


		System.out.println("------------------------------------------------------------------------------");
		// Produire une chaine unique qui concat�ne tous les mots mais avec une virgule 
		// entre chacun. Il ne doit pas y avoir de virgule avant le premier mot, 
		// ni apr�s le dernier
		
		String motsAvecVirgule = mots.stream()
				.reduce((s1, s2) -> s1 + "," + s2)
				.orElse("il faut au moins deux chaines");
		
		//OU: String motsAvecVirgule = mots.stream().collect(Collectors.joining(","));
		System.out.printf("mots s�par�s par une virgule: %s.%n", motsAvecVirgule);

		System.out.println("------------------------------------------------------------------------------");
		// Cr�er dans une classe StreamUtils une m�thode static ransomNumberList qui 
		// produit une liste de type java.util.List de n nombres al�atoires, n �tant pass� 
		// en argument (faire appel � generate et limit)
		// List<Double> nums = StreamUtils.randomNumberList(someSize);
		// le r�sultat ressemble �:  [0.7096867136897776, 0.09894202723079482, ...]
		System.out.printf("3 nombres al�atoires: %s.%n", StreamUtils.randomNumberList(3));

		System.out.println("------------------------------------------------------------------------------");
		// Cr�er dans une classe StreamUtils une m�thode static orderedNumberList qui 
		// produit une liste de type java.util.List de n nombres croissants � partir 
		// d'une valeur donn�e, et dont l'increment est fix� (faire appel � iterate et limit)
		// List<Integer> nombres = StreamUtils.orderedNumberList(50, 5, 10);
		// le r�sultat ressemble �:  [50, 55, 60, ...]
		System.out.printf("10 nombres � partir de 50, avec increment de 5 : %s.%n",
				StreamUtils.orderedNumberList(50, 5, 10));

		System.out.println("------------------------------------------------------------------------------");
		// Calculer la somme s�quentielle des nombres entiers d'un tableau d'une 
		// dizaine d'entiers
		List<Integer> nombres1 = Arrays.asList(1, 2, 3, 4, 5);
		int somme1 = nombres1.stream().reduce(0, Integer::sum);
		System.out.printf("la somme (calcul s�quentiel) des nombres %s est %s.%n", nombres1, somme1);

		System.out.println("------------------------------------------------------------------------------");
		// r�-�ffectuer ce calcul en profitant du parall�lisme des Streams
		int somme2 = nombres1.stream().parallel().reduce(0, Integer::sum);
		System.out.printf("la somme (calcul parall�le) des nombres %s est %s.%n", nombres1, somme2);

		System.out.println("------------------------------------------------------------------------------");
		// Calculer le produit s�quentiel d'une dizaine de nombres de type 
		// double d'un tableau
		List<Double> nombres2 = Arrays.asList(0.000000000001, 200000000000.0,
				0.000000000003, 400000000000.0);
		
		double produit1 = nombres2.stream().reduce(1.0, (n1, n2) -> n1 * n2);
		System.out.printf("le produit (calcul s�quentiel) des nombres %s est %s.%n", nombres2, produit1);
		
		System.out.println("------------------------------------------------------------------------------");
		// r�-�ffectuer ce calcul en profitant du parall�lisme des Streams
		// (le r�sultat n'est pas toujours le m�me selon que le calcul est s�quentiel
		// ou parall�le(la diff�rence n'appara�t que sur une machine multi-cores) 
		double produit2 = nombres2.stream().parallel().reduce(1.0, (n1, n2) -> n1 * n2);
		System.out.printf("le produit (calcul parall�le) des nombres %s est %s.%n", nombres2, produit2);
		
	}
}
