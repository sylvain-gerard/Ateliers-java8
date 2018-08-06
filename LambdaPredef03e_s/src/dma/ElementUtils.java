package dma;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;


public class ElementUtils {
	
	private ElementUtils() {} 

	/*
	public static <T> List<T> allMatches(List<T> candidates,Predicate<T> matchFunction) {
		List<T> results = new ArrayList<>();
		for (T possibleMatch : candidates) {
			if (matchFunction.test(possibleMatch)) {
				results.add(possibleMatch);
			}
		}
		return (results);
	}
	
	public static <T> List<T> allMatches(List<T> candidates,Predicate<T> matchFunction) {
		List<T> results = new ArrayList<>();
		candidates.forEach(s -> { if (matchFunction.test(s)) results.add(s);}  );
		return results;
	}
	*/
	
	public static <T> List<T> allMatches(List<T> candidates,Predicate<T> matchFunction) {
		List<T> results = new ArrayList<>(candidates);
		results.removeIf(matchFunction.negate());
		return results;
	}
}
