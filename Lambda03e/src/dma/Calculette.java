package dma;

interface CalculEntier{
	int operation (int a, int b);
}
// DONE
public class Calculette {
	public int operationSurEntier(int a, int b, CalculEntier calcul){
		return calcul.operation (a,b);
	}
	
	public static void main(String[] args){
		Calculette calculette = new Calculette();
		
		CalculEntier addition = (a,b) -> a + b;
		
		CalculEntier soustraction = (a,b) -> a - b;
				
		CalculEntier multiplication = (a,b) -> a * b;
		
		CalculEntier division = (a,b) -> a / b;
		
		CalculEntier modulo = (a, b) -> a % b;
		
		System.out.println(calculette.operationSurEntier(100,5, addition));
		System.out.println(calculette.operationSurEntier(100,5, soustraction));
		System.out.println(calculette.operationSurEntier(100,5, multiplication));
		System.out.println(calculette.operationSurEntier(100,5, division));
		System.out.println(calculette.operationSurEntier(100,5, modulo));	
	}
}



