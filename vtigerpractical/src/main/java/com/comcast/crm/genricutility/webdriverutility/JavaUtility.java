package com.comcast.crm.genricutility.webdriverutility;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class JavaUtility {
	
	
	public int getRandomNumber() {
		Random random = new Random();
		int randomnumber = random.nextInt(70000);
		return randomnumber;
	}

	
	public String getSystemDateyyyymmdd() {
		Date dateobj = new Date();
		SimpleDateFormat	 sim = new SimpleDateFormat("yyyy-MM-dd");
		 String systemdate = sim.format(dateobj);
		 return systemdate;
	}
	
	public String getRequiredDate(int days) {
		SimpleDateFormat	 sim = new SimpleDateFormat("yyyy-MM-dd");
		Calendar cal = sim.getCalendar();
	    cal.add(Calendar.DAY_OF_MONTH, days);
	   String requireddate = sim.format(cal.getTime());
	   return requireddate;
	}
	
	public StringBuilder getAlphaNumericRandomNumber() {
    int n = 20;
    String alphanumeric = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789abcdefghijklmnopqrstuvwxyz";
	StringBuilder sb = new StringBuilder(n);
		
		for(int i=0; i< n; i++) {
			int index = (int)(alphanumeric.length()*Math.random());
			sb.append(alphanumeric.charAt(index));	
		
	}
		return sb;
	}
	
	

}
