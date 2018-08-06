package dma;

public class ElementUtils {
	
	private ElementUtils() {
	}

	public static <T> T meilleurElement(T e1, T e2, 
			PropositionElement<T> tester) {
		
		return tester.estMeilleur(e1, e2) ? e1 : e2 ;
	}
}
