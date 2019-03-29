package TaxCalculation;

public class ProgressiveTax {

	public static int ProgressiveTaxCalculate(int income, int MPF, int allowance){
		
		//Constants
		int ProgressiveTax = 0;
		int band;
		
		final int first = 50000;
		final int second = 50000;
		final int third = 50000;
		final int fourth = 50000;
		final float firstRate = 0.02f;
		final float secondRate = 0.06f;
		final float thirdRate = 0.10f;
		final float fourthRate = 0.14f;
		final float remainderRate = 0.17f;
		
		
		//Calculate net charge income
		int netChargeable = income - allowance - MPF;
		if (netChargeable <= 0){
			return ProgressiveTax = 0;
		}
		
		// First band
		band = netChargeable < first ? (int)(netChargeable * firstRate) : (int)(first * firstRate);
		ProgressiveTax += band;
		
		// Second band
		netChargeable -= second;
		if (netChargeable > 0) {
			band = netChargeable < second ? (int) (netChargeable * secondRate) : (int) (second * secondRate);
			ProgressiveTax += band;
		}
		
		// Third band
		netChargeable -= third;
		if (netChargeable > 0) {
			band = netChargeable < third ? (int) (netChargeable * thirdRate) : (int) (third * thirdRate);
			ProgressiveTax += band;
		}
		
		// Fourth band
		netChargeable -= fourth;
		if (netChargeable > 0) {
			band = netChargeable < third ? (int) (netChargeable * fourthRate) : (int) (fourth * fourthRate);
			ProgressiveTax += band;
		}
		
		// Remainder
		netChargeable -= fourth;
		if (netChargeable > 0) {
			band = (int)(netChargeable * remainderRate);
			ProgressiveTax += band;
		}
		
		return ProgressiveTax;
		
	}
}
