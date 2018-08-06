package dma;

public class StringUtils {
	
	public static int presence_e(String s1, String s2) {
		if(s1.contains("e") && !s2.contains("e")) return -1;
		else if(s2.contains("e") && !s1.contains("e")) return 1;
		else return 0;
	}
}
