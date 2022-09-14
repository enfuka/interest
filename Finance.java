public class Finance {

	public static void main(String[] args)			// Driver method.
	{
		header();
		displaySectionA();
		System.out.println("\n\n");
		displaySectionB();
		System.out.println("\n\n");
		displaySectionC();
	}


	public static void displaySectionA()			// Method to print a table for section A.
	{
		System.out.println("Payment		APR		Years		FV		FV/Continuous	FV/c-FV");
		System.out.println("----------	----------	----------	----------	----------	----------");
		
		for(double P = 500; P <= 1500; P = P + 500)			// Iterate over payment values.
		{
			if(P>500)										// Print space between blocks.
				System.out.println();
			for(int y = 5; y <= 10; y = (3*y - 1)/2)		// Iterate over year values.
			{
				if(y>5)										// Print space between blocks.
					System.out.println();
				for(int r = 2; r <= 8; r++)					// Iterate over rate values and print rows.
				{
					System.out.printf("$%7.2f	%d %%		%d		$%7.2f	$%7.2f	$%7.2f\n", P, r, y, calcFV(P,r,y), calcFVcont(P,r,y), calcFVcont(P,r,y)-calcFV(P,r,y));
				}
			}
		}
	}	
	
	
	public static void displaySectionB()			// Method to print a table for section B.
	{
		double P = 200;								// Declaration for the constant payment value.
		
		System.out.println("FV		Rate		Payment		Number of Periods");
		System.out.println("----------	----------	----------	----------");
			
		for(int r = 2; r <= 7; r++)					// Iterate over rate values.
		{
			if(r>2)									// Print space between blocks.
				System.out.println();
			for(double FV = 1000; FV <= 2000; FV = FV + 200)		// Iterate over FV values and print rows.
			{
				System.out.printf("$%7.2f	%d %%		$%7.2f	%.0f\n", FV, r, P, calcPeriod(FV,r,P));
			}
		}
		
	}
	
			
	public static void displaySectionC()			// Method to print a table for section C.
	{
		double C1 = 100;							// Declaration for the constant cash flow value.
		
		System.out.println("C1		Rate		Number of Periods	Present Value");
		System.out.println("----------	----------	----------		----------");
			
		for(int n = 1; n <= 3; n++)					// Iterate over period values.
		{
			if(n>1)									// Print space between blocks.
				System.out.println();
			for(int r = 3; r <= 6; r++)				// Iterate over rate values and print rows.
			{
				System.out.printf("$%7.2f	%d %%		%d			$%7.2f\n", C1, r, n, calcPV(C1,r,n));
			}
		}
		
	}
	
	
	public static double calcFV(double P, int r, int y)						// Method to calculate future value.
	{
		double R = (double) r/100;
		return P*((Math.pow(1 + R, y) - 1)/R);
	}
	
	public static double calcFVcont(double P, int r, int y)					// Method to calculate future value with continuous compounding.
	{
		double R = (double) r/100;
		return P*((Math.exp(R*y) - 1)/(Math.exp(R) - 1));
	}
	
	public static double calcPeriod(double FV, int r, double P)				// Method to calculate the number of periods to achieve the future value.
	{
		double R = (double) r/100;
		return Math.ceil(Math.log(1 + ((FV*R)/P))/Math.log(1 + R));
	}
	
	public static double calcPV(double C1, int r, int n)					// Method to calculate Present value.
	{
		double R = (double) r/100;
		return C1/Math.pow(1 + R, n);
	}
}
