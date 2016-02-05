package com.tax.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * author lzc
 * <coushuxiaolang@163.com>
 */
public class DateUtil {

	/**获取当前时间前三个月的月初日子
	 * add by lzc     date: 2016年1月26日
	 * ex:
	 * now:2016年1月26日11:31:46
	 * @return 20151001
	 */
	public static int getLatst3MonthStartDate(){
		DateFormat df = new SimpleDateFormat("yyyyMMdd");
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.MONTH,calendar.get(Calendar.MONTH)-3);
		calendar.set(Calendar.DAY_OF_MONTH,1);
		
		
		return Integer.parseInt(df.format(calendar.getTime()).toString());
	}
	
	/**获取上个月月末日子
	 * add by lzc     date: 2016年1月26日
	 * ex:
	 * now:2016年1月26日11:33:14
	 * @return 20151231
	 */
	public static int getLastMonthEndDate(){
		DateFormat df = new SimpleDateFormat("yyyyMMdd");
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.MONTH,calendar.get(Calendar.MONTH)-1);
		calendar.set(Calendar.DAY_OF_MONTH,calendar.getActualMaximum(Calendar.DATE));
		return Integer.parseInt(df.format(calendar.getTime()).toString());
		
	}
	
	/**获取上个月月初日子
	 * add by lzc     date: 2016年2月2日
	 * @return
	 */
	public static int getLastMonthStartDate(){
		DateFormat df = new SimpleDateFormat("yyyyMMdd");
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.MONTH,calendar.get(Calendar.MONTH)-1);
		calendar.set(Calendar.DAY_OF_MONTH,1);
		return Integer.parseInt(df.format(calendar.getTime()).toString());
		
	}
	
	
	
	
	
	/**获取俩年前第一天
	 * add by lzc     date: 2016年1月29日
	 * @param year
	 * @return
	 */
	public static int get2YearBeginDate(){
		DateFormat df = new SimpleDateFormat("yyyyMMdd");
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.YEAR, calendar.get(Calendar.YEAR)-2);
		calendar.set(Calendar.MONTH,0);
		calendar.set(Calendar.DAY_OF_MONTH,1);
		return Integer.parseInt(df.format(calendar.getTime()).toString());
	}
	
	
	/**获取X年第一天
	 * add by lzc     date: 2016年1月30日
	 * @param year
	 * @return
	 */
	public static int getYearBeginDate(int year){
		DateFormat df = new SimpleDateFormat("yyyyMMdd");
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.YEAR, year);
		calendar.set(Calendar.MONTH,0);
		calendar.set(Calendar.DAY_OF_MONTH,1);
		return Integer.parseInt(df.format(calendar.getTime()).toString());
	}
	
	/**获取X年最后一天
	 * add by lzc     date: 2016年1月30日
	 * @param year
	 * @return
	 */
	public static int getYearEndDate(int year){
		DateFormat df = new SimpleDateFormat("yyyyMMdd");
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.YEAR, year);
		calendar.set(Calendar.MONTH,11);
		calendar.set(Calendar.DAY_OF_MONTH,calendar.getMaximum(Calendar.DAY_OF_MONTH));
		return Integer.parseInt(df.format(calendar.getTime()).toString());
	}
	
	
	
	public static void main(String[] args) {
		getLastMonthEndDate();
		getLastMonthStartDate();
	}
	
}
