package dma;

import java.util.function.Consumer;
import java.util.function.Supplier;

public class Achat {

	public static void main(String[] args) {
		Personne gaston = new Personne("LAGAFFE", "Gaston", 30 );
		Achat achat = new Achat();

		/*
		achat.achatCompulsif(
				new Supplier<Voiture>(){
					@Override
					public Voiture get() {
						return new Voiture("2Chevaux","Citroen",100,80);
					}
				},
				new Consumer<Voiture>(){
					@Override
					public void accept(Voiture v){
	                     gaston.achete(v);
	                }
				});
				
		*/
		
		achat.achatCompulsif(()-> new Voiture("2Chevaux","Citroen",1000,80), 
				gaston::achete);
		System.out.println(gaston);
	}
	
	public <T> void achatCompulsif(Supplier<T> producteur, Consumer<T> consommateur) {
		consommateur.accept(producteur.get());
	}      
}
