package dma;

import java.util.Arrays;
import java.util.List;

public class Main {
	public static void main(String[] args) {

		List<String> mots = Arrays.asList("bonjour", "hello", "hola", "aurevoir", "goodbye", "adios");
		System.out.printf("mots de la liste d'origine: %s.%n", mots);
		
		System.out.println("------------------------------------------------------------------------------");
    	// Produire une chaine de caractères unique qui concatène tous les mots 
		// en majuscules, en utilisant reduce une seule fois, sans utiliser map
		
		String chaineUniqueMaj  = mots.stream().reduce("",
				(s1, s2) -> s1.toUpperCase() + s2.toUpperCase());
		System.out.printf("Chaine unique en majuscules: %s.%n", chaineUniqueMaj);

		System.out.println("------------------------------------------------------------------------------");
		// Produire le même résultat que précédemment, mais via une opération map
		// qui transforme les mots en majuscules puis les concatène avec reduce
		
		String chaineUniqueMaj2 = mots.stream().map(String::toUpperCase)
				.reduce("", String::concat);
		System.out.printf("Chaine unique en majuscules: %s.%n", chaineUniqueMaj2);


		System.out.println("------------------------------------------------------------------------------");
		// Produire une chaine unique qui concatène tous les mots mais avec une virgule 
		// entre chacun. Il ne doit pas y avoir de virgule avant le premier mot, 
		// ni après le dernier
		
		String motsAvecVirgule = mots.stream()
				.reduce((s1, s2) -> s1 + "," + s2)
				.orElse("il faut au moins deux chaines");
		
		//OU: String motsAvecVirgule = mots.stream().collect(Collectors.joining(","));
		System.out.printf("mots séparés par une virgule: %s.%n", motsAvecVirgule);

		System.out.println("------------------------------------------------------------------------------");
		// Créer dans une classe StreamUtils une méthode static ransomNumberList qui 
		// produit une liste de type java.util.List de n nombres aléatoires, n étant passé 
		// en argument (faire appel à generate et limit)
		// List<Double> nums = StreamUtils.randomNumberList(someSize);
		// le résultat ressemble à:  [0.7096867136897776, 0.09894202723079482, ...]
		System.out.printf("3 nombres aléatoires: %s.%n", StreamUtils.randomNumberList(3));

		System.out.println("------------------------------------------------------------------------------");
		// Créer dans une classe StreamUtils une méthode static orderedNumberList qui 
		// produit une liste de type java.util.List de n nombres croissants à partir 
		// d'une valeur donnée, et dont l'increment est fixé (faire appel à iterate et limit)
		// List<Integer> nombres = StreamUtils.orderedNumberList(50, 5, 10);
		// le résultat ressemble à:  [50, 55, 60, ...]
		System.out.printf("10 nombres à partir de 50, avec increment de 5 : %s.%n",
				StreamUtils.orderedNumberList(50, 5, 10));

		System.out.println("------------------------------------------------------------------------------");
		// Calculer la somme séquentielle des nombres entiers d'un tableau d'une 
		// dizaine d'entiers
		List<Integer> nombres1 = Arrays.asList(1, 2, 3, 4, 5);
		int somme1 = nombres1.stream().reduce(0, Integer::sum);
		System.out.printf("la somme (calcul séquentiel) des nombres %s est %s.%n", nombres1, somme1);

		System.out.println("------------------------------------------------------------------------------");
		// ré-éffectuer ce calcul en profitant du parallélisme des Streams
		int somme2 = nombres1.stream().parallel().reduce(0, Integer::sum);
		System.out.printf("la somme (calcul parallèle) des nombres %s est %s.%n", nombres1, somme2);

		System.out.println("------------------------------------------------------------------------------");
		// Calculer le produit séquentiel d'une dizaine de nombres de type 
		// double d'un tableau
		List<Double> nombres2 = Arrays.asList(0.000000000001, 200000000000.0,
				0.000000000003, 400000000000.0);
		
		double produit1 = nombres2.stream().reduce(1.0, (n1, n2) -> n1 * n2);
		System.out.printf("le produit (calcul séquentiel) des nombres %s est %s.%n", nombres2, produit1);
		
		System.out.println("------------------------------------------------------------------------------");
		// ré-éffectuer ce calcul en profitant du parallélisme des Streams
		// (le résultat n'est pas toujours le même selon que le calcul est séquentiel
		// ou parallèle(la différence n'apparaît que sur une machine multi-cores) 
		double produit2 = nombres2.stream().parallel().reduce(1.0, (n1, n2) -> n1 * n2);
		System.out.printf("le produit (calcul parallèle) des nombres %s est %s.%n", nombres2, produit2);
		
	}
}
