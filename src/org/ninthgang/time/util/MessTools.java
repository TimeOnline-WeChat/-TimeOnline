/**
 * 
 */
package org.ninthgang.time.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 工具类
 * 
 * @author lingqiusang
 * 
 */
public class MessTools {

	/** 获取当天时间yyyy-MM-dd */
	public static String getCurrentDate() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String currentDate = null;
		try {
			currentDate = sdf.format(new Date());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return currentDate;
	}
	/** 获取系统前一天的时间yyyy-MM-dd */
	public static String getYesterday() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String currentDate = null;
		try {
			Calendar cla = Calendar.getInstance();
			cla.setTime(new Date());
			cla.add(Calendar.DAY_OF_YEAR, -1);
			currentDate = sdf.format(cla.getTime());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return currentDate;
	}
}
