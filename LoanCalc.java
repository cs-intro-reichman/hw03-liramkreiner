/**
* Computes the periodical payment necessary to re-pay a given loan.
*/
public class LoanCalc {
	
	static double epsilon = 0.001;  // The computation tolerance (estimation error)
	static int iterationCounter; 
	static int iterationCounter1;   // Monitors the efficiency of the calculation
	
    /** 
     * Gets the loan data and computes the periodical payment.
     * Expects to get three command-line arguments: sum of the loan (double),
     * interest rate (double, as a percentage), and number of payments (int).  
     */
	public static void main(String[] args) {		
		// Gets the loan data
		double loan = Double.parseDouble(args[0]);
		double rate = Double.parseDouble(args[1]);
		int n = Integer.parseInt(args[2]);
		System.out.println("Loan sum = " + loan + ", interest rate = " + rate + "%, periods = " + n);
		
		// Computes the periodical payment using brute force search
		System.out.print("Periodical payment, using brute force: ");
		System.out.printf("%.2f", bruteForceSolver(loan, rate, n, epsilon));
		System.out.println();
		System.out.println("number of iterations: " + iterationCounter);

		// Computes the periodical payment using bisection search
		System.out.print("Periodical payment, using bi-section search: ");
		System.out.printf("%.2f", bisectionSolver(loan, rate, n, epsilon));
		System.out.println();
		System.out.println("number of iterations: " + iterationCounter1);
	}
	
	/**
	* Uses a sequential search method  ("brute force") to compute an approximation
	* of the periodical payment that will bring the ending balance of a loan close to 0.
	* Given: the sum of the loan, the periodical interest rate (as a percentage),
	* the number of periods (n), and epsilon, a tolerance level.
	*/
	// Side effect: modifies the class variable iterationCounter.
    public static double bruteForceSolver(double loan, double rate, int n, double epsilon) 
    {  
    	 
		double payment = loan/n;//deter the first payment to be loan/period
		while (endBalance(loan,rate,n,payment) >= 0)   
		{
			payment += epsilon;//advence the payment with epsioln
			iterationCounter++; //check how much time the loop run
		}
		 return payment; // returning the payment
    }
    
    /**
	* Uses bisection search to compute an approximation of the periodical payment 
	* that will bring the ending balance of a loan close to 0.
	* Given: the sum of theloan, the periodical interest rate (as a percentage),
	* the number of periods (n), and epsilon, a tolerance level.
	*/
	// Side effect: modifies the class variable iterationCounter.
    public static double bisectionSolver(double loan, double rate, int n, double epsilon) 
    {  
		

		double payment =  loan/n, loanforwork = loan;//stetting the first payment to be loan/period
		double checkpayment = (payment + loan) /2; //setting g according to algoritem
		while (loanforwork - payment > epsilon)
		 {		
		 	if (endBalance(loan,rate,n,checkpayment) * endBalance(loan,rate,n,payment)>0 ) //if f(g)*f(l)>0
				payment = checkpayment;
				else
					loanforwork = checkpayment;
			checkpayment = (loanforwork + payment) / 2;
			iterationCounter1++; //checking how much time the loop run
		}
		return checkpayment; //returning the payment
    }
	
	/**
	* Computes the ending balance of a loan, given the sum of the loan, the periodical
	* interest rate (as a percentage), the number of periods (n), and the periodical payment.
	*/
	private static double endBalance(double loan, double rate, int n, double payment) 
	{
		double endofbalance = loan;
		for (int i=0;i<n;i++)
			endofbalance = (endofbalance-payment) * (1+rate/100); //cheking how much mony left to pay
		return endofbalance; // returning the rest of the mony that left after the payments

	}
}