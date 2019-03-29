package TaxCalculation;

public class StandardTax {
	public static int StandardTaxCalculate(int income, int MPF){
		
		final float standardRate = 0.15f;
		
		return (int) ((income - MPF) * standardRate); 
	}
}
