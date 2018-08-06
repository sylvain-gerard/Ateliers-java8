package dma;

import java.util.Arrays;
import java.util.List;

public class Main {
  public static void main(String[] args) {
     
    List<Integer> entiers = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
    //int somme = FonctionUtils.collect(entiers, (x,y)->x + y, 0);
    int somme = FonctionUtils.collect(entiers, Integer::sum, 0);
    System.out.printf("Somme de %s : %s%n", entiers, somme);
    
    List<String> lettres = Arrays.asList("0","1","2","3","4","5","6","7","8","9", "a", "b", "c", "d", "e", "f");
    
    //String hexa = FonctionUtils.collect(lettres, (x,y)-> x + y, "chiffres héxadécimaux: ");
    String hexa = FonctionUtils.collect(lettres, String::concat, "chiffres héxadécimaux: ");
    System.out.printf("%s%n", hexa);
    
    List<Double> decimaux = Arrays.asList(1.2, -2.3, 4.5, -5.6, 9.7, 12.1);
    //double maxi = FonctionUtils.collect(decimaux, (x,y)->Double.max(x,y), Double.MIN_VALUE);
    double maxi = FonctionUtils.collect(decimaux, Double::max, Double.MIN_VALUE);
    System.out.printf("Max de %s : %s%n", decimaux, maxi);
  }
}
