package util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.function.BiPredicate;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class RepUtils {

	private RepUtils() {
	}

	public static void afficheTousLesChemins(Stream<Path> chemins) {
		chemins.forEach(System.out::println);
	}

	public static void afficheTousLesCheminsDansRepertoire(String rep) {
		try (Stream<Path> chemins = Files.list(Paths.get(rep))) {
			afficheTousLesChemins(chemins);
		} catch (IOException ioe) {
			System.err.println("IOException: " + ioe);
		}
	}

	public static void afficheChemins(Stream<Path> chemins, Predicate<Path> test) {
		chemins.filter(test).forEach(System.out::println);
	}

	public static void afficheCheminsDansRepertoire(String rep, Predicate<Path> test) {
		try (Stream<Path> chemins = Files.list(Paths.get(rep))) {
			afficheChemins(chemins, test);
		} catch (IOException ioe) {
			System.err.println("IOException: " + ioe);
		}
	}

	public static void afficheTousLesCheminsDansArborescence(String repRacine) {
		try (Stream<Path> paths = Files.walk(Paths.get(repRacine))) {
			afficheTousLesChemins(paths);
		} catch (IOException ioe) {
			System.err.println("IOException: " + ioe);
		}
	}

	public static void afficheCheminsDansArborescence(String repRacine, Predicate<Path> test) {
		try (Stream<Path> paths = Files.walk(Paths.get(repRacine))) {
			afficheChemins(paths, test);
		} catch (IOException ioe) {
			System.err.println("IOException: " + ioe);
		}
	}

	public static void rechercheCheminsDansArborescence(String repRacine, BiPredicate<Path, BasicFileAttributes> test) {
		try (Stream<Path> chemins = Files.find(Paths.get(repRacine), 10, test)) {
			afficheTousLesChemins(chemins);
		} catch (IOException ioe) {
			System.err.println("IOException: " + ioe);
		}
	}

}
