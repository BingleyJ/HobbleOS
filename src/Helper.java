import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;


public class Helper {
	public Helper(){
		
	}

	public String date(){
		// Create an instance of SimpleDateFormat used for formatting 
		// the string representation of date (month/day/year)
		DateFormat df = new SimpleDateFormat("MM/dd/yyyy");

		// Get the date today using Calendar object.
		java.util.Date today = Calendar.getInstance().getTime();        
		// Using DateFormat format method we can create a string 
		// representation of a date with the defined format.
		String reportDate = df.format(today);

		// Print what date is today!
		String returndate = ("Date: " + reportDate);
		return returndate;
	}
	
	public void wait(int inMilli) throws InterruptedException{
		 Thread.sleep(inMilli);
	}
	
}
