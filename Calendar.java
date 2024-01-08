/** 
 * Prints the calendars of all the years in the 20th century.
 */
public class Calendar 
{	
    // Starting the calendar on 1/1/1900
	static int dayOfMonth = 1;   
	static int month = 1;
	static int dayOfWeek = 2;     // 1.1.1900 was a Monday
	static int nDaysInMonth = 31; // Number of days in January
	
	/** 
	 * Prints the calendars of all the years in the 20th century. Also prints the  
	 * number of Sundays that occured on the first day of the month during this period.
	 */
	public static void main(String args[]) 
		{
		
	 		 int year = Integer.parseInt(args[0]);
	 		advance(year);//initiate the function with the givven year
	 		
	 		
        }
	 
	 private static void advance(int years)
	 {
	 	int day = 2;
	 	for(int year = 1900;year<years;year++)
	 	{
		 	for (int i =1;i<13;i++)
		 	{
		 		for (int j=1;j<nDaysInMonth(i,year)+1;j++)//checking when is sunday
		 		{
		 			if(day>7)
		 				day=1;
		 			day++;
		 		}

		 	}
		}
		 	for (int i =1;i<13;i++)
		 	{
		 		for (int j=1;j<nDaysInMonth(i,years)+1;j++)
		 		{
		 			if(day>7)//check if the week is passed
		 				day=1;
		 			if(day==1)//check if sunday
		 			{
		 				System.out.println(j+"/"+i+"/"+years+" Sunday");
		 			}
		 			else  System.out.println(j+"/"+i+"/"+years);
		 			day++;
		 		}

		 	}


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
