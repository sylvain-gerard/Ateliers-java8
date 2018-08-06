package dma;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class AfficheListe {
	public static void main(String[] args){
		List<Integer> liste = Arrays.asList(34,76,98,23,62,59,84,47,21);
		
		System.out.println("--------------------------------------------------");
		System.out.println("affichage via une classe interne anonyme:");
		liste.forEach(new Consumer<Integer>(){
			@Override
			public void accept(Integer arg0) {
				System.out.println(arg0);	
			}		
		});
		
		System.out.println("--------------------------------------------------");
		System.out.println("affichage via une expression Lambda:");
		liste.forEach( p -> System.out.println(p) );
				
		
		System.out.println("--------------------------------------------------");
		System.out.println("affichage via une reference sur méthode:");
		liste.forEach(System.out::println);
		
	}
}
