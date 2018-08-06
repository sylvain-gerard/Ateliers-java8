package dma;

public class StringUtils {

	private StringUtils() {}

	public static String meilleureChaine(String s1, String s2, 
			PropositionChaine tester) {

		return tester.estMeilleure(s1, s2) ? s1 : s2 ;
	}
}
