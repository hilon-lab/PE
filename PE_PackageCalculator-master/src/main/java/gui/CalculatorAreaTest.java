package gui;
import junit.framework.Test;



public class CalculatorAreaTest extends CalculatorArea {

	@Test(expected = ExceptionInInitializerError.class)

	public static void main (String args[]) {
		
		
		int rightlength = CalculatorArea.parseUserInputLength("10mm");
		int rightweight = CalculatorArea.parseUserInputWeight("10g");
		
		int wronglength = CalculatorArea.parseUserInputLength("10kilometer");
		int wrongweight = CalculatorArea.parseUserInputWeight("2 Pfund");
		
		
		System.out.println("Korrekt wäre: "+ rightlength +" " + rightweight);
		System.out.println("falsch wäre: "+ wronglength +" "+ wrongweight);
	}
}





