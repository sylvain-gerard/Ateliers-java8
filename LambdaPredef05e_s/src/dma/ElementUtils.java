package dma;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class ElementUtils {

	private ElementUtils() {
	}
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
	*/
	
	public static <T> List<T> allMatches(List<T> candidates,Predicate<T> matchFunction) {
		List<T> results = new ArrayList<>();
		candidates.forEach(s -> { if (matchFunction.test(s)) results.add(s);}  );
		return results;
	}

	/*
	public static <T, R> List<R> transformedList(List<T> originals,Function<T, R> transformer) {
		List<R> results = new ArrayList<>();
		for (T original : originals) {
			results.add(transformer.apply(original));
		}
		return (results);
	}
	*/
	
	public static <T, R> List<R> transformedList(List<T> originals, Function<T, R> transformer) {
		List<R> results = new ArrayList<>();
		originals.forEach(s -> results.add(transformer.apply(s)));
		return (results);
	}
}
