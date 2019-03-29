package TaxCalculation;

public class MPFCalculation{
	
	//Set the MPF and Monthly relevant income
	public static int MPFCalculate(int income){
		int MPF;
		int MRI; 
		
		MRI = income / 12;
		if(MRI < 7100){
			return MPF = 0;
		}else if (MRI >= 7100 && MRI <= 30000){
			return MPF = (int)(MRI * 0.05f) * 12;
		}else{
			return MPF = 1500 * 12;
		}
		
	}
}
