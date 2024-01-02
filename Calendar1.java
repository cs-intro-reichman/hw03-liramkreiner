/** 
 * Prints the calendars of all the years in the 20th century.
 */
public class Calendar1 {	
    // Starting the calendar on 1/1/1900
	static int dayOfMonth = 1;   
	static int month = 1;
	static int year = 1900;
	static int dayOfWeek = 2;     // 1.1.1900 was a Monday
	static int nDaysInMonth = 31; // Number of days in January
	
	/** 
	 * Prints the calendars of all the years in the 20th century. Also prints the  
	 * number of Sundays that occured on the first day of the month during this period.
	 */
	public static void main(String args[]) 
		{
		
	 		
	 		advance();
	 		
	 		
        }
	 	//// Write the necessary ending code here
	 
	
	 // Advances the date (day, month, year) and the day-of-the-week.
	 // If the month changes, sets the number of days in this month.
	 // Side effects: changes the static variables dayOfMonth, month, year, dayOfWeek, nDaysInMonth.
	 private static void advance()
	 {
	 	int countdate = 0;
	 	int day = 2;
	 	for(int year = 1900;year<2000;year++)
	 	{
		 	for (int i =1;i<13;i++)
		 	{
		 		for (int j=1;j<nDaysInMonth(i,year)+1;j++)
		 		{
		 			if(day>7)
		 				day=1;
		 			if(day==1)
		 			{
		 				if(j==1)
		 					countdate++;
		 				System.out.println(j+"/"+i+"/"+year+" Sunday");
		 			}
		 			else  System.out.println(j+"/"+i+"/"+year);
		 			day++;
		 		}

		 	}
		}
		System.out.println("During the 20th century, " +countdate+" Sundays fell on the first day of the month");



	 } 
		 
    // Returns true if the given year is a leap year, false otherwise.
	private static boolean isLeapYear(int year) {
	    boolean isleap = false;
	    if(year%4==0)//check if the year davise by 4
	    {
	    	isleap=true;
	    	if (year%400!=0&&year%100==0)//check if the year deviseble by 400 but not 100
	    		isleap = false;


	    }
		return isleap;
	}
	 
	// Returns the number of days in the given month and year.
	// April, June, September, and November have 30 days each.
	// February has 28 days in a common year, and 29 days in a leap year.
	// All the other months have 31 days.
	private static int nDaysInMonth(int month, int year) {
		if (month == 4 ||month == 6 ||month == 9 ||month == 11)// checkif the month is april june september or november
		return 30;
		if(month==2)//check if the month is feb and check how many days it should have depend on either it is leap ot common year
		{
			if (isLeapYear(year))
					return 29;
		 return 28;
		}
		return 31;//if the month is nither of the month above

	}
}
