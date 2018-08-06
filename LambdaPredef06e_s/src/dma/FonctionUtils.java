package dma;

import java.util.List;
import java.util.function.BinaryOperator;

public class FonctionUtils {

  public static <T> T collect(List<T> entries, BinaryOperator<T> operation, T initial) {
    for(T entry: entries) {
    	initial = operation.apply(initial, entry);
    }
    return initial;
  }
 
}
