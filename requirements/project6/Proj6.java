
/**
 * Proj6 finds the earliest, latest, and average date from a list
 *
 * @author Tyler Bruce
 * @version Project 6
 */

import java.util.*;

public class Proj6 {
   public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.print("Enter a list of dates: ");
        String list = s.nextLine();

        StringTokenizer st = new StringTokenizer(list, ", ");
        String[] dates = new String[st.countTokens()];

        for (int i = 0; i < dates.length; i++) {
            dates[i] = st.nextToken();
        }
        
        printEarliest(dates);
        printLatest(dates);
        printAvgYear(dates);

        //YOU DO THIS
        //Call printEarliest, printLatest, and printAvgYear
        //with the dates array
    }

	/**
	 * getMonth returns the month in a date
	 * of the form month/day/year
	 *
	 * @param date - A date of the form month/day/year
	 * @return The month of the given date
	 */
    public static int getMonth(String date) {
        StringTokenizer st = new StringTokenizer(date, "/");
        return Integer.parseInt(st.nextToken());
    }

	/**
	 * getDay returns the day in a date
	 * of the form month/day/year
	 *
	 * @param date - A date of the form month/day/year
	 * @return The day of the given date
	 */
    public static int getDay(String date) {
        StringTokenizer st = new StringTokenizer(date, "/");
        st.nextToken();
        return Integer.parseInt(st.nextToken());
    }


	/**
	 * getYear returns the year in a date
	 * of the form month/day/year
	 *
	 * @param date - A date of the form month/day/year
	 * @return The year of the given date
	 */
    public static int getYear(String date) {
        StringTokenizer st = new StringTokenizer(date, "/");
        st.nextToken();
        st.nextToken();
        return Integer.parseInt(st.nextToken());
    }

	/**
	 * printEarliest prints the date that comes chronologically
	 * first from the dates array
	 *
	 * @param dates - An array of dates, all of the form month/day/year
	 */
    public static void printEarliest(String[] dates) {
        int currentDate = getDay(dates[0]);
        int currentMonth = getMonth(dates[0]);
        int currentYear = getYear(dates[0]);
        
        int index_of_the_earliest_date = 0;
        for (int i = 0; i < dates.length; i++)
        {
            if(dates [index_of_the_earliest_date] < dates[i])
            {
                index_of_the_earliest_date = i;
            }
        }
        System.out.println("Earliest date: " + index_of_the_earliest_date );
        
        //YOU DO THIS
        //Print the earliest date in the dates array
        //You may want to call getMonth, getDay, and getYear
        //To get the month, day, and year from a particular date
        //Don't forget that several dates may have the same year and/or month
    }

	/**
	 * printLatest prints the date that comes chronologically
	 * last from the dates array
	 *
	 * @param dates - An array of dates, all of the form month/day/year
	 */
    public static void printLatest(String[] dates) {
         int currentDate = getDate(dates[0]);
        int currentMonth = getMonth(dates[0]);
        int currentYear = getYear(dates[0]);
        
        int index_of_the_latest_date = o;
        for (int i = 0; i <dates.length; i++)
        {
            if(dates[index_of_the_latest_date] > dates[i])
            {
                index_of_the_earliest_date = i;
            }
        }
        System.out.println("Latest date: " + index_of_the_latest_date );
        
        //YOU DO THIS
        //Print the latest date in the dates array
        //You may want to call getMonth, getDay, and getYear
        //To get the month, day, and year from a particular date
        //Don't forget that several dates may have the same year and/or month
    }

	/**
	 * printAvgYear prints the average year among all the dates in
	 * the dates array
	 *
	 * @param dates - An array of dates, all of the form month/day/year
	 */
    public static void printAvgYear(String[] dates) {
       
        
        //YOU DO THIS
		//Print the average year of the dates in the dates array
		//You may want to call getYear to get the year from each date
    }
}
