package util;

public class StringUtils {
  
	private StringUtils() {}
  
	/** retourne la copie inversee d'une chaine */
	public static String reverseString(String s) {
		// A COMPLETER
	}
  
	/** retourne true si la chaine fournie en argument est un palidrome */
	public static boolean isPalindrome(String s) {
		return(s.equalsIgnoreCase(reverseString(s)));
	}
  
}
