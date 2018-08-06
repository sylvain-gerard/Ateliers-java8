package dma;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import util.StringUtils;

public class Main {
	public static void main(String[] args) {
		String nomFichier = "liste-de-mots-anglais.txt";
		System.out.println("Analyse du fichier " + nomFichier);
		System.out.println();
		
		//============================================================================
		
		System.out.println("Liste de tous les palindromes trouves:");
		try (Stream<String> s = Files.lines(Paths.get(nomFichier))) {	
			s.filter(StringUtils::isPalindrome).forEach(System.out::println);
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println();
		
		//============================================================================
		
		System.out.print("Premier palindrome de 5 lettres: ");
		try (Stream<String> s = Files.lines(Paths.get(nomFichier))) {	
			System.out.println(
				s.filter(mot -> mot.length() == 5)
				.filter(StringUtils::isPalindrome)
				.findFirst()
				.orElse("aucun palindrome de 6 lettres trouve!")
			);
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println();
		
		//============================================================================
		
		System.out.print("Liste des mots anglais de 4 lettres: ");
		String fichierResultat = "liste-de-mots-anglais-de-4-lettres.txt";
	    int longueur = 4;
	    List<String> mots = null;
		try (Stream<String> s = Files.lines(Paths.get(nomFichier))) {
			mots = s.filter(mot -> mot.length() == longueur)
	             .map(String::toUpperCase)
	             .distinct()
	             .sorted()
	             .collect(Collectors.toList());
			Files.write(Paths.get(fichierResultat), mots, Charset.defaultCharset());
			System.out.printf("%s mots ecrits dans %s%n", mots.size(), fichierResultat);
		}catch (IOException e) {
				e.printStackTrace();
		}
	    System.out.println();
	    
	    //============================================================================
	    
	    System.out.print("Nombre de mots anglais contenant la lettre q (a l'exclusion de qu): ");
	    try (Stream<String> s = Files.lines(Paths.get(nomFichier))) {		    
	    	System.out.println(
	    		s.filter(mot -> mot.contains("q"))
	    		.filter(mot -> !mot.contains("qu"))
	    		.count());
	    }catch (IOException e) {
			e.printStackTrace();
	    }
	    System.out.println();
	    
	    //============================================================================
	    
	    try (Stream<String> s = Files.lines(Paths.get(nomFichier))) {		    
	    	int n = s.filter(mot -> mot.contains("x"))
	                .filter(mot -> mot.contains("y"))
	                .mapToInt(String::length)
	                .sum();
	       System.out.printf("%,d lettres cumulees au total dans les mots comportant a la fois x et y %n", n);
	    }catch (IOException e) {
			e.printStackTrace();
	    }
	}
}