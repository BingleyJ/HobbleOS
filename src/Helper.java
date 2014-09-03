import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;


public class Helper {
	public Helper(){
		
	}

	
	public String getTime(){
		DateFormat tf = new SimpleDateFormat("hh:mm:ss");
		java.util.Date today = Calendar.getInstance().getTime();        
		String reportTime = tf.format(today);
		return reportTime;
	}
	
	public String getDate(){
		DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
		java.util.Date today = Calendar.getInstance().getTime();        
		String reportDate = df.format(today);
		return reportDate;
	}
	
	public void wait(int inMilli) throws InterruptedException{
		 Thread.sleep(inMilli);
	}
	
}
