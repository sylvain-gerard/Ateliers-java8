package dma;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.StringJoiner;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Main {
	public static void main(String[] args) {

		List<Personne> personnes = Arrays.asList(
			        new Personne("Max", 18),
			        new Personne("Pierre", 23),
			        new Personne("Patricia", 23),
			        new Personne("David", 12)
			    );
		System.out.printf("personnes de la liste d'origine: %s.%n", personnes);
		
		System.out.println("---------------------------------------------------------------------------------------------");
		// obtenir une collection (de type List) des personnes dont le com commence par P
		// (utiliser filter, collect et Collectors.toList)
		
		System.out.println("collection (de type List) des personnes dont le nom commence par P:" );
		List<Personne> personneP = personnes
			        .stream()
			        .filter(p -> p.nom.startsWith("P"))
			        .collect(Collectors.toList());
					//.collect(Collectors.toSet()); // pour obtenir un Set

		System.out.println(personneP);    // [Pierre, Patricia]

		
		System.out.println("---------------------------------------------------------------------------------------------");
		// obtenir une collection (de type Map<Integer, List<Person>>) des personnes ayant le même age
		// (utiliser filter, collect et Collectors.groupingBy)
		
		System.out.println("collection (de type Map<Integer, List<Person>>) des personnes ayant le même age:" );
		Map<Integer, List<Personne>> personnesParAge = personnes
			    	.stream()
			    	.collect(Collectors.groupingBy(p -> p.age));

		personnesParAge.forEach((age, p) -> System.out.format("age %s: %s\n", age, p));
		

		System.out.println("---------------------------------------------------------------------------------------------");
		// obtenir une collection (de type Map<Integer, String>) des noms des personnes ayant le même age
		// (utiliser collect et Collectors.toMap)
		
		System.out.println("obtenir une collection (de type Map<Integer, String>) des noms des personnes ayant le même age:" );
		Map<Integer, String> map = personnes
			    	.stream()
			    	.collect(Collectors.toMap(
			    			p -> p.age,
			    			p -> p.nom,
			    			(nom1, nom2) -> nom1 + ";" + nom2)
			    	);

		System.out.println(map); // {18=Max, 23=Pierre;Patricia, 12=David}
		
		
		System.out.println("---------------------------------------------------------------------------------------------");
		// obtenir l'age moyen des personnes
		// (utiliser collect et Collectors.averagingInt)
		
		System.out.println("obtenir l'age moyen des personnes:");		
		Double moyenneAge = personnes
			    	.stream()
			    	.collect(Collectors.averagingInt(p -> p.age));

		System.out.println(moyenneAge);     // 19.0

		
		System.out.println("---------------------------------------------------------------------------------------------");
		// obtenir les statistiques sur l'age des personnes
		// (utiliser collect et Collectors.summarizingInt)
		
		System.out.println("obtenir les statistiques sur l'age des personnes:");		
		IntSummaryStatistics ageStats = personnes
			        .stream()
			        .collect(Collectors.summarizingInt(p -> p.age));

		System.out.println(ageStats);// IntSummaryStatistics{count=4, sum=76, min=12, average=19.000000, max=23}


		System.out.println("---------------------------------------------------------------------------------------------");
		// obtenir une chaîne de caractères indiquant que Max, Pierre, Patricia sont majeures:
		// (utiliser filter, map, collect et Collectors.joining)
		// static Collector<CharSequence,?,String> 	joining(CharSequence delimiter, CharSequence prefix, CharSequence suffix)
		
		System.out.println("obtenir une chaîne de caractères indiquant que Max, Pierre, Patricia sont majeures:");
		String phrase = personnes
			    	.stream()
			    	.filter(p -> p.age >= 18)
			    	.map(p -> p.nom)
			    	.collect(Collectors.joining(", ", "En France ", " sont majeures"));

		System.out.println(phrase); // En France Max, Pierre, Patricia sont majeures

		
		System.out.println("---------------------------------------------------------------------------------------------");
		// obtenir une chaîne de caractères contenant les noms des personnes en majuscules séparés par |
		// créer un Collector personnalisé avec Collector.of et le passer à collect 
		// static <T,R> Collector<T,R,R> of(
		// 			Supplier<R> supplier,
		// 			BiConsumer<R,T> accumulator,
		// 			BinaryOperator<R> combiner,
        // 			Collector.Characteristics... characteristics)
		
		System.out.println("obtenir une chaîne de caractères contenant les noms des personnes en majuscules séparés par |");
		Collector<Personne, StringJoiner, String> collecteurPerso =
			    Collector.of(
			        () -> new StringJoiner(" | "),          // supplier
			        (j, p) -> j.add(p.nom.toUpperCase()),   // accumulator
			        (j1, j2) -> j1.merge(j2),               // combiner
			        StringJoiner::toString);                // finisher

		String names = personnes
			    	.stream()
			    	.collect(collecteurPerso);

		System.out.println(names);  // MAX | PIERRE | PATRICIA | DAVID

		System.out.println("---------------------------------------------------------------------------------------------");
		// afficher la personne la plus agée
		// (utiliser reduce)
		System.out.print("personne la plus agée: ");
		personnes
	    		.stream()
	    		.reduce((p1, p2) -> p1.age > p2.age ? p1 : p2)
	    		.ifPresent(System.out::println);    // Patricia

		
		System.out.println("---------------------------------------------------------------------------------------------");
		// afficher la somme des ages des personnes
		// (utiliser reduce)
		System.out.println("somme des ages des personnes");
		
		/*
		Integer ageSum = personnes
			    .stream()
			    .reduce(0,
			    		new BiFunction<Integer, Personne, Integer>(){
			    			@Override
			    			public Integer apply(Integer sum, Personne p) {
			    				return sum + p.age;
			    			}
			    		},
			    		new BinaryOperator<Integer>(){
							@Override
							public Integer apply(Integer sum1, Integer sum2) {
								return sum1 + sum2;
							}
			    			
			    		});
		*/
		
		Integer ageSum = personnes
			    .stream()
			    .reduce(0, (sum, p) -> sum + p.age, (sum1, sum2) -> sum1 + sum2);
		
		System.out.println(ageSum);  // 76
		
			
		System.out.println("---------------------------------------------------------------------------------------------");
		// créer une nouvelle personne dont le nom est la concaténation des noms de toutes les personnes"
		// son age la sommes des ages de toutes les personnes"
		// (utiliser Stream.reduce)
		System.out.println("nouvelle personne dont le nom est la concaténation des noms de toutes les personnes"
				+ ", \nson age la somme des ages de toutes les personnes");

		/*
		Personne result = personnes
		        	.stream()
		        	.reduce(new Personne("", 0), new BinaryOperator<Personne>() {
		        		@Override
		        		public Personne apply(Personne p1, Personne p2){
			            	p1.age += p2.age;
			            	p1.nom += p2.nom;
			            	return p1;
		        		}
		        	});
		
		*/
		Personne result = personnes
			        .stream()
			        .reduce(new Personne("", 0), (p1, p2) -> {
			            p1.age += p2.age;
			            p1.nom += p2.nom;
			            return p1;
			        });

		System.out.format("nom=%s; age cumulé=%s", result.nom, result.age); // name=MaxPierrePatriciaDavid; age=76

	}
}
