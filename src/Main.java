import TaxCalculation.*;
import java.util.*;


public class Main {	
	//The main program
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Set the elements 
		
		boolean isMarried = false;
		int income = -100;
		int MPF;
		int Progressive;
		int Stantard;
		int PayTax;
		
		int mateMPF = 0;
		int mateincome = -1020;
		int mateProgressive = 0;
		int mateStantard = 0;
		int matePayTax;
		
		int SumMPF = 0;
		int Sumincome = 0;
		int SummateProgressive = 0;
		int SummateStantard = 0;
		int SumPayTax;
		
		//Set the allowance
		int allowance = 132000;
		
		MPFCalculation M = new MPFCalculation();
		StandardTax S = new StandardTax();
		ProgressiveTax P = new ProgressiveTax();
		
		
		
		Scanner in = new Scanner(System.in);
		System.out.println("Welcome to use this program.");
		System.out.println("This is a program to calculate the Salary Tax payable of Hong Kong.");
		
		//Check the user is married or not
		int sm = 0;
		while (sm <= 0 || sm >= 3){
			System.out.print("Are you single (1) or married (2)? (Other input is not allowed) ");
			sm = in.nextInt(); 
			if(sm == 1){
				isMarried = false;
			}else if(sm == 2){
				isMarried = true;
			}else{
				System.out.println("You enter a wrong input, please input again ");
			}
		}
		
		//Get the income
		while (income < 0){
			System.out.print("Please enter your yearly income : ");
			income = in.nextInt(); 
			if(income < 0){
				System.out.println("Please input vaild value");
			}
		}
		if(isMarried == true){
			while(mateincome < 0 ){
				System.out.print("Please enter your mate's yearly income : ");
				mateincome = in.nextInt(); 
				if(mateincome< 0){
					System.out.println("Please input vaild value");
				}
			}
		}
		
		//Calculate the single payment
		MPF = M.MPFCalculate(income);
		Stantard = S.StandardTaxCalculate(income, MPF);
		Progressive = P.ProgressiveTaxCalculate(income, MPF,  allowance);
		
		
		//Calculate the joint and separate payment
		if(isMarried == true){
			Sumincome = income + mateincome;
			
			mateMPF = M.MPFCalculate(mateincome);
			mateStantard = S.StandardTaxCalculate(mateincome, mateMPF);
			mateProgressive = P.ProgressiveTaxCalculate(mateincome, mateMPF, allowance);
			
			allowance = 132000 * 2;
			SumMPF = MPF + mateMPF;
			SummateProgressive = P.ProgressiveTaxCalculate(Sumincome, SumMPF, allowance);
			SummateStantard = S.StandardTaxCalculate(Sumincome, SumMPF);
			
		}
		
		//Show the value of self MPF
		System.out.println("Your MPF amount is $" + MPF);
		//Determine the recommended payment 
		if(Stantard <= Progressive ){
			PayTax = Stantard;
			System.out.println("Your pay tax(at stantard Tax) is $" + PayTax);
		}else{
			PayTax = Progressive;
			System.out.println("Your pay tax is $" + PayTax);
		}
		
		
		if(isMarried == true){
			System.out.println("Your mate's MPF amount is $" + mateMPF);
			if(mateStantard <= mateProgressive){
				matePayTax = mateStantard;
				System.out.println("Your mate's pay tax(at stantard Tax) is $" + matePayTax);
			}else{
				matePayTax = mateProgressive;
				System.out.println("Your mate's pay tax is $" + matePayTax);
			}
			
			if(SummateStantard <= SummateProgressive){
				SumPayTax = SummateStantard;
				System.out.println("The joint pay tax(at stantard Tax) is $" + SumPayTax);
			}else{
				SumPayTax = SummateProgressive;
				System.out.println("The joint pay tax is $" + SumPayTax);
			}
			
			System.out.println("The total separate pay tax is $" + (matePayTax + PayTax));
			if(SumPayTax <= (matePayTax + PayTax)){
				System.out.println("Joint pay tax is recommended");
			}else{
				System.out.println("Separate pay tax is recommended");
			}
		}
		
	}
	public int test(int income, int mateincome) {
		boolean isMarried = true;
		int MPF;
		int Progressive;
		int Stantard;
		int PayTax;
		
		int mateMPF = 0;
		int mateProgressive = 0;
		int mateStantard = 0;
		int matePayTax;
		
		int SumMPF = 0;
		int Sumincome = 0;
		int SummateProgressive = 0;
		int SummateStantard = 0;
		int SumPayTax;
		
		//Set the allowance
		int allowance = 132000;
		
		MPFCalculation M = new MPFCalculation();
		StandardTax S = new StandardTax();
		ProgressiveTax P = new ProgressiveTax();
	
		
		
		
		//Calculate the single payment
		MPF = M.MPFCalculate(income);
		Stantard = S.StandardTaxCalculate(income, MPF);
		Progressive = P.ProgressiveTaxCalculate(income, MPF,  allowance);
		
		
		//Calculate the joint and separate payment
		if(isMarried == true){
			Sumincome = income + mateincome;
			
			mateMPF = M.MPFCalculate(mateincome);
			mateStantard = S.StandardTaxCalculate(mateincome, mateMPF);
			mateProgressive = P.ProgressiveTaxCalculate(mateincome, mateMPF, allowance);
			
			allowance = 132000 * 2;
			SumMPF = MPF + mateMPF;
			SummateProgressive = P.ProgressiveTaxCalculate(Sumincome, SumMPF, allowance);
			SummateStantard = S.StandardTaxCalculate(Sumincome, SumMPF);
			
		}
		
		//Show the value of self MPF
		System.out.println("Your MPF amount is $" + MPF);
		//Determine the recommended payment 
		if(Stantard <= Progressive ){
			PayTax = Stantard;
			System.out.println("Your pay tax(at stantard Tax) is $" + PayTax);
		}else{
			PayTax = Progressive;
			System.out.println("Your pay tax is $" + PayTax);
		}
		
		
		int paytax = 0;
		if(isMarried == true){
			System.out.println("Your mate's MPF amount is $" + mateMPF);
			if(mateStantard <= mateProgressive){
				matePayTax = mateStantard;
				System.out.println("Your mate's pay tax(at stantard Tax) is $" + matePayTax);
			}else{
				matePayTax = mateProgressive;
				System.out.println("Your mate's pay tax is $" + matePayTax);
			}
			
			if(SummateStantard <= SummateProgressive){
				SumPayTax = SummateStantard;
				System.out.println("The joint pay tax(at stantard Tax) is $" + SumPayTax);
			}else{
				SumPayTax = SummateProgressive;
				System.out.println("The joint pay tax is $" + SumPayTax);
			}
			
			System.out.println("The total separate pay tax is $" + (matePayTax + PayTax));
			if(SumPayTax <= (matePayTax + PayTax)){
				System.out.println("Joint pay tax is recommended");
				paytax = SumPayTax;
			}else{
				System.out.println("Separate pay tax is recommended");
				paytax = matePayTax + PayTax;
			}
		}
		return paytax;
		
	}
	public int test(int income) {
		boolean isMarried = false;
		int MPF;
		int Progressive;
		int Stantard;
		int PayTax;
		
		int mateMPF = 0;
		int mateincome = -1020;
		int mateProgressive = 0;
		int mateStantard = 0;
		int matePayTax;
		
		int SumMPF = 0;
		int Sumincome = 0;
		int SummateProgressive = 0;
		int SummateStantard = 0;
		int SumPayTax;
		
		//Set the allowance
		int allowance = 132000;
		
		MPFCalculation M = new MPFCalculation();
		StandardTax S = new StandardTax();
		ProgressiveTax P = new ProgressiveTax();
		
		//Calculate the single payment
		MPF = M.MPFCalculate(income);
		Stantard = S.StandardTaxCalculate(income, MPF);
		Progressive = P.ProgressiveTaxCalculate(income, MPF,  allowance);
		
		
		//Calculate the joint and separate payment
		if(isMarried == true){
			Sumincome = income + mateincome;
			
			mateMPF = M.MPFCalculate(mateincome);
			mateStantard = S.StandardTaxCalculate(mateincome, mateMPF);
			mateProgressive = P.ProgressiveTaxCalculate(mateincome, mateMPF, allowance);
			
			allowance = 132000 * 2;
			SumMPF = MPF + mateMPF;
			SummateProgressive = P.ProgressiveTaxCalculate(Sumincome, SumMPF, allowance);
			SummateStantard = S.StandardTaxCalculate(Sumincome, SumMPF);
			
		}
		
		//Show the value of self MPF
		System.out.println("Your MPF amount is $" + MPF);
		//Determine the recommended payment 
		if(Stantard <= Progressive ){
			PayTax = Stantard;
			System.out.println("Your pay tax(at stantard Tax) is $" + PayTax);
		}else{
			PayTax = Progressive;
			System.out.println("Your pay tax is $" + PayTax);
		}
		
		int paytax = 0;
		if(isMarried == true){
			System.out.println("Your mate's MPF amount is $" + mateMPF);
			if(mateStantard <= mateProgressive){
				matePayTax = mateStantard;
				System.out.println("Your mate's pay tax(at stantard Tax) is $" + matePayTax);
			}else{
				matePayTax = mateProgressive;
				System.out.println("Your mate's pay tax is $" + matePayTax);
			}
			
			if(SummateStantard <= SummateProgressive){
				SumPayTax = SummateStantard;
				System.out.println("The joint pay tax(at stantard Tax) is $" + SumPayTax);
			}else{
				SumPayTax = SummateProgressive;
				System.out.println("The joint pay tax is $" + SumPayTax);
			}
			
			System.out.println("The total separate pay tax is $" + (matePayTax + PayTax));
			if(SumPayTax <= (matePayTax + PayTax)){
				System.out.println("Joint pay tax is recommended");
				paytax = SumPayTax;
			}else{
				System.out.println("Separate pay tax is recommended");
				paytax = matePayTax + PayTax;
			}
		}
		return paytax;
		
	}

}
