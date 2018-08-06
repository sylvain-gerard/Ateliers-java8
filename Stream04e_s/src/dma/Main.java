package dma;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;

public class Main {
	public static void main(String[] args) {

		System.out.println("---------------------------------------------------------------------------------------------");
		System.out.print("taille du ForkJoinPool:" );
		// peut être modifiée par l'option -Djava.util.concurrent.ForkJoinPool.common.parallelism=5 de la JVM
		
		ForkJoinPool commonPool = ForkJoinPool.commonPool();
		System.out.println(commonPool.getParallelism());    // 7

		System.out.println("---------------------------------------------------------------------------------------------");
		int max = 10_000_000;
		System.out.println("comparaison des tris séquentiel et parallèle sur "+ max + " éléments:" );
		
		List<String> values = new ArrayList<>(max);
		for (int i = 0; i < max; i++) {
		    UUID uuid = UUID.randomUUID();
		    values.add(uuid.toString());
		}
		{
			// Tri parallèle
			long t0 = System.nanoTime();
			values.stream().parallel().sorted();
			long t1 = System.nanoTime();
			long millis = (t1 - t0) / 1000;
			System.out.println(String.format("durée du tri séquentiel: %d ms", millis)); // 26 ms
			System.gc();
		}
		{
			// Tri séquentiel
			long t0 = System.nanoTime();
			values.stream().sorted();
			long t1 = System.nanoTime();
			long millis = (t1 - t0) / 1000;
			System.out.println(String.format("durée du tri séquentiel: %d ms", millis)); // 3128 ms
			System.gc();
		}

		System.out.println("---------------------------------------------------------------------------------------------");
		System.out.println("threads au travail (filter, map, forEach) sur une collection de 7 objets:" );
		
		Arrays.asList("a1", "a2", "b1", "b2", "c1", "c2", "c3")
			.stream()
			.filter(s -> s.length() < 4)
			.map(s -> s.toUpperCase())
			.forEach(s -> System.out.format(s + " "));

		
		Arrays.asList("a1", "a2", "b1", "b2", "c1", "c2", "c3")
	    	.parallelStream()
	    	.filter(s -> {
	    			System.out.format("filter: %s [%s]\n",s, Thread.currentThread().getName());
	    			return s.length() < 4;
	    			})
	    	.map(s -> {
	    			System.out.format("map: %s [%s]\n",s, Thread.currentThread().getName());
	    			return s.toUpperCase();
	    			})
	    	.forEach(s -> {
	    			System.out.format("forEach: %s [%s]\n",s, Thread.currentThread().getName());
	    			System.out.format(s + " ");
	    			});

	}
}