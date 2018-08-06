package dma;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class StringUtils {
	
	private StringUtils() {
	}
	/*
	public static List<String> allMatches(List<String> candidates, 
	Predicate<String> matchFunction) {
		List<String> results = new ArrayList<>();
		for (String possibleMatch : candidates) {
			if (matchFunction.test(possibleMatch)) {
				results.add(possibleMatch);
			}
		}
		return (results);
	}

	public static List<String> allMatches(List<String> candidates,Predicate<String> matchFunction) {
		List<String> results = new ArrayList<>();
		candidates.forEach(s -> {if (matchFunction.test(s)) results.add(s);});
		return results;
	}
	*/

	public static List<String> allMatches(List<String> candidates,Predicate<String> matchFunction) {
		List<String> results = new ArrayList<>(candidates);
		results.removeIf(matchFunction.negate());
		return results;
	}

}
