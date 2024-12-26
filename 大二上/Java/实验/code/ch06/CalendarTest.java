package cn.edu.zjut.java.ch06;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class CalendarTest {

	public static void main(String[] args){
		
		Calendar c = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	   // System.out.println(sdf.format(c.getTime()));

		
		
		//c.set(1, 1, 1);
		//c.set(2, 1, 1);
		
		System.out.println(c.get(Calendar.YEAR));
		

		System.out.println(c.getTimeInMillis());
	    
	    //Date d = new Date(1,1,1);
	    
	    Date date = new Date(2016,10,1);
	    System.out.println(sdf.format(date));  //3916-11-01
	    
	}
}