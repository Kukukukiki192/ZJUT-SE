package com.company;
import java.util.Scanner;
import java.util.Calendar;
import java.text.SimpleDateFormat;
public class J日历 {

    public static void main(String[] args) {
	    Scanner in=new Scanner(System.in);
        while(in.hasNext()) {
            Calendar c = Calendar.getInstance();
            c.set(2000,1-1,1);
            int days = in.nextInt();
            c.add(Calendar.DATE,days);
            int week = c.get(Calendar.DAY_OF_WEEK);
            String[] w=new String[]{"Sunday","Monday","Tuesday","Wednesday","Thursday","Friday","Saturday"};
            SimpleDateFormat cc = new SimpleDateFormat("yyyy-MM-dd");
            System.out.println(cc.format(c.getTime())+" "+w[week-1]);
        }
    }
}
