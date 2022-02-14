package com.ncstudy.toolutils;


import javax.naming.NamingException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * @ClassName:  DateUtil  nc
 * @Description: 日期工具类
 */
public abstract class DateUtil {

    private final static String myFmt  = new String("yyyy-MM-dd HH:mm:ss");
    private final static String myFmt2 = new String("yyyy-MM-dd");
    private final static String myFmt3 = new String("EEE MMM dd HH:mm:ss zzz yyyy");   //星期三 八月 29 14:19:49 CST 2018
    private final static String myFmt4 = new String("yyyy-MM-dd HH:mm:ss:SSS");
    private final static String myFmt5 = new String("yyyyMMddHHmmss");
    private final static String myFmt6 = new String("yyyyMM");
    private final static String myFmt7 = new String("yyyy");
    private final static String myFmt8 = new String("yyyy/MM/dd");
    private final static String myFmt9 = new String("yyyy-MM-dd HH:mm");

    public static String Date1Str(Date date)  {
        return new SimpleDateFormat(myFmt).format(date);
    }
    public static String Date2Str(Date date) {
        return new SimpleDateFormat(myFmt2).format(date);
    }
    public static String Date3Str(Date date) {
        return new SimpleDateFormat(myFmt3).format(date);
    }
    public static String Date4Str(Date date) {
        return new SimpleDateFormat(myFmt4).format(date);
    }
    public static String Date5Str(Date date) {
        return new SimpleDateFormat(myFmt5).format(date);
    }
    public static String Date6Str(Date date) {
        return new SimpleDateFormat(myFmt6).format(date);
    }
    public static String Date7Str(Date date) {
        return new SimpleDateFormat(myFmt7).format(date);
    }
    public static String Date8Str(Date date) {
        return new SimpleDateFormat(myFmt8).format(date);
    }

    /**
     * @Description: 校验时间字符串是否正确
     * @param: @param date 日期
     * @param: @param fmt  格式
     * @throws
     */
//    public static boolean isValidate(String date, String fmt) {
//        try {
//            if (StringUtils.isNotBlank(date) && StringUtils.isNotBlank(fmt)) {
//                SimpleDateFormat dataFmt = new SimpleDateFormat(fmt);
//                Date dd = dataFmt.parse(date);
//                if (date.equals(dataFmt.format(dd))) {
//                    return true;
//                } else {
//                    return false;
//                }
//            } else {
//                return false;
//            }
//        } catch (Exception e) {
//            return false;
//        }
//    }

    /**
     * str 根据长度转对应 date(两种)  Mon Sep 23 01:01:01 CST 2019
     * @param str
     * @return
     */
    public static Date Str2D(String str) {
        if (null == str) {
          return null;
        }
        try {
          if (str.length() > 10) {
            return new SimpleDateFormat(myFmt).parse(str);
          } else {
            return new SimpleDateFormat(myFmt2).parse(str);
          }
        } catch (Exception e) {
          e.printStackTrace();
        }
        return null;
    }

    /**
     * 目的不明確
     * @param str
     * @return
     */
    public static Date Str2D2(String str) {
        try {
          return new SimpleDateFormat(myFmt3, java.util.Locale.ENGLISH).parse(str);
        } catch (Exception e) {
          e.printStackTrace();
        }
        return null;
    }
    public static Date Str2D9(String str) {
	    try {
	        return new SimpleDateFormat(myFmt9, java.util.Locale.ENGLISH).parse(str);
        } catch (Exception e) {
	        e.printStackTrace();
        }
        return null;
    }

    /**
     * 設置年月日
     * @param year
     * @param month
     * @param date
     * @return
     */
    public static Date createDate(int year, int month, int date) {
        GregorianCalendar calendar = new GregorianCalendar();
        calendar.clear();
        calendar.set(Calendar.YEAR, year);
        calendar.set(Calendar.MONTH, month - 1);
        calendar.set(Calendar.DAY_OF_MONTH, date);
        return calendar.getTime();
    }

    /**
       * @author 字符串转时间 默認年月日 2019-09-23
       * @param date
       * @return
       */
    public static Date Str2Date(String date) {
        try {
          SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd");//可改
          if (date.length() > 10) {
            ft = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
          }
          java.util.Date d = ft.parse(date);
          return new java.sql.Date(d.getTime());
        } catch (Exception ex) {
          return new Date(Calendar.getInstance().getTime().getTime());
        }
      }

    /**
   * 获取当前日期的前一天具體時間 2018-08-28 13:21:13
     */
    public static String getPrevDay() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new java.sql.Date(System.currentTimeMillis()));
        int day = calendar.get(Calendar.DATE);
        calendar.set(Calendar.DATE, day - 1);
        return new SimpleDateFormat(myFmt).format(calendar.getTime());
    }

    /**
    * 获取当前日期的后一天 2018-08-30 13:21:13
    */
    public static String getNextDay() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new java.sql.Date(System.currentTimeMillis()));
        int day = calendar.get(Calendar.DATE);
        calendar.set(Calendar.DATE, day + 1);

        SimpleDateFormat sdf = new SimpleDateFormat(myFmt);
        return sdf.format(calendar.getTime());
    }

    /**
    * 获取当前日期 2018-08-28 13:21:13
    */
    public static String getCurrentDayTime() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new java.sql.Date(System.currentTimeMillis()));
        SimpleDateFormat sdf = new SimpleDateFormat(myFmt);
        return sdf.format(calendar.getTime());
    }

    /**
       * 获取当前数据库日期 2018-08-29 13:24:27.243
       */
    public static Date getSysdate() {
	    return new Timestamp(System.currentTimeMillis());
    }
    /**
     * 获取当前日期 2018-08-29 13:24:27.243
     */
    public static Timestamp getCurrentTimestamp() {
        Timestamp d = new Timestamp(System.currentTimeMillis());
        return d;
    }

    /**
     * 获取四位年份 2018
     */
    public static String getCurrentYear() {
        SimpleDateFormat formatter;
        formatter = new SimpleDateFormat("yyyy");
        String ctime = formatter.format(new Date());
        return ctime;
    }
    /**
     * 获取两位年份 18
     */
    public static String getCuurentShortYear() {
        SimpleDateFormat formatter;
        formatter = new SimpleDateFormat("yy");
        String ctime = formatter.format(new Date());
        return ctime;
    }
    /**
    * 获取当前月 8
    */
    public static int getCurrentMonth() {
    Calendar ca = Calendar.getInstance();
    int month = ca.get(Calendar.MONTH) + 1;// 获取月
    return month;
  }
    /**
     * 获取两位月份 08
     */
    public static String getDoubleMonth() {
        SimpleDateFormat formatter;
        formatter = new SimpleDateFormat("MM");
        String ctime = formatter.format(new Date());
        return ctime;
    }
    /**
     * 获取两位日期 29
     */
    public static String getCurrentDay() {
        SimpleDateFormat formatter;
        formatter = new SimpleDateFormat("dd");
        String ctime = formatter.format(new Date());
        return ctime;
    }

    /**
     * 获取当前时间時分秒 13:27:06
     * @return
     */
    @SuppressWarnings("deprecation")
    public static Time getCurrentTime() {
        Calendar ca = Calendar.getInstance();
        int minute = ca.get(Calendar.MINUTE);// 分
        int hour = ca.get(Calendar.HOUR_OF_DAY);// 小时
        int second = ca.get(Calendar.SECOND);// 秒
        Time ts = new Time(hour, minute, second);
        return ts;
    }


    /**
    * 获取当前是一周的第幾天
    */
    public static int getCurWeek() {
        int week = java.util.Calendar.getInstance().get(java.util.Calendar.DAY_OF_WEEK);
        int weekDay = 0;
        if (week == 1) {
          weekDay = 7;
        } else {
          weekDay = week - 1;
        }
        return weekDay;
    }
    /**
     * 一年的第幾周
     * @return
     */
    public static int getYeareek(){
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;
        try {
            date = format.parse(format.format(System.currentTimeMillis()));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setFirstDayOfWeek(Calendar.MONDAY);
        calendar.setTime(date);
       return calendar.get(Calendar.WEEK_OF_YEAR);
    }

    /**
       * 获取当前财务年度（3月31日~4月1日为财务一整年度）
       * @return
       */
    public static String getFiscalYear(){
          SimpleDateFormat yearFormatter = new SimpleDateFormat("yyyy");
          String year = yearFormatter.format(new Date());

          SimpleDateFormat mmformatter = new SimpleDateFormat("MM");
          String month = mmformatter.format(new Date());
          Integer imonth = Integer.valueOf(month);

          String fiscalYear = year;
          if (imonth < 4){
              Integer i = Integer.valueOf(year) - 1;
              fiscalYear = String.valueOf(i);
          }

          return fiscalYear;
      }

    /**
	 * 获取年度 以5月為分割,之前減一年,之後為現年
	 */
	public static String getClosingYearNo() {
		Calendar cal = Calendar.getInstance();
		int year = cal.get(Calendar.YEAR);
		int month = cal.get(Calendar.MONTH);
		if (month >= 4) {
			return String.valueOf(year);
		} else {
			return String.valueOf(year - 1);
		}
	}
	
	/**
	 * 日期比较
	 * @param beginDate
	 * @param endDate
	 * @return
	 */
	public static boolean compare(String beginDate, String endDate) {
		Date b = Str2D(beginDate);
		Date e = Str2D(endDate);
		// Date类的一个方法，如果a早于b返回true，否则返回false
		if (b.before(e))
			return true;
		else
			return false;
	}
    //上面方法重載 參數不同,功能一漾
	public static boolean compare(Date beginDate, String endDate) {
		Date e = Str2D(endDate);
		// Date类的一个方法，如果a早于b返回true，否则返回false
		if (beginDate.before(e))
			return true;
		else
			return false;
	}
	
	/**
	 * 将八位的年月日格式化成10位带横杠的年月日如：20140404->2014-04-04
	 */
	public static Date formatSAP8Date(String sapDate) throws Exception {
		boolean isInt = sapDate.matches("[0-9]*");
		if (isInt == false)
			throw new Exception("SAP日期格[" + sapDate + "]式校验错误,不符合8位数字类型日期格式。\n如:20140404");

		String year = sapDate.substring(0, 4);
		String month = sapDate.substring(4, 6);
		String day = sapDate.substring(6, 8);

		if (Integer.valueOf(month) > 12)
			throw new Exception("月份[" + month + "]式校验错误,月份不能大于12个月.");

		if (Integer.valueOf(day) > 31)
			throw new Exception("日期[" + day + "]式校验错误,日期不能大于31天.");

		return new SimpleDateFormat("yyyy-MM-dd").parse(year + "-" + month + "-" + day);
	}
	
	/**
	 * @param beginDate 开始时间
	 * @param endDate 结束时间
	 * @param dateDiff 时间间隔
	 * @param ts
	 * @param tsDiff ts间隔
	 * @return
	 */
	public static boolean isVaildDate(String beginDate, String endDate, int dateDiff, String ts, int tsDiff) {
		return isVaildDate(Str2D(beginDate), Str2D(endDate), dateDiff,Str2D(ts), tsDiff);
	}
	private final static long TO_DAY = 24*3600*1000;
	public static boolean isVaildDate(Date beginDate, Date endDate, int dateDiff, Date ts, int tsDiff) {
		if (dateDiff == 0 && tsDiff == 0) return false;
		if (beginDate != null && endDate != null) {
			if (((endDate.getTime() - beginDate.getTime())/TO_DAY) < dateDiff) {
				return true;
			}
		} else if (ts != null) {
			if (((new Date().getTime() - ts.getTime())/TO_DAY) < tsDiff) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * @param offset 开始位置
	 * @param limit 取行数
	 * @param diff 限制行数
	 * @return
	 */
//	public static boolean isVaildLimit(String offset, String limit, int diff) {
//		if (StringUtils.isNotBlank(offset) && StringUtils.isNotBlank(limit)) {
//			return isVaildLimit(Integer.valueOf(offset), Integer.valueOf(limit), diff);
//		}
//		return false;
//	}
	public static boolean isVaildLimit(int offset, int limit, int diff) {
		if (limit != 0 && limit <= diff && (limit - offset) <= diff) {
			return true;
		}
		return false;
	}
	
	/**
     * 当前日期时间加上多少天 Fri Aug 31 13:48:32 CST 2018
     */
    public static Date plusDay(int day){
        Date d = new Date();
        Calendar ca = Calendar.getInstance();
        ca.add(Calendar.DATE, day);// num为增加的分数，可以改变的
        d = ca.getTime();
        return d;
    }
    /**
     * 当前日期时间加上多少天 2018-08-31 13:52:01
     */
    public static String plusDayToStr(int day){
        Date d = new Date();
        Calendar ca = Calendar.getInstance();
        ca.add(Calendar.DATE, day);// num为增加的分数，可以改变的
        d = ca.getTime();
        return new SimpleDateFormat(myFmt).format(d);
    }
    /**
     * 当前日期时间加上多少分钟
     * @param minute 为增加的时间分
     */
    public static Date plusMinute(int minute){
        Date d = new Date();
        Calendar ca = Calendar.getInstance();
        ca.add(Calendar.MINUTE, minute);// num为增加的分数，可以改变的
        d = ca.getTime();
        return d;
    }
    /**
     * 当前日期时间加上多少分钟
     * @param minute 为增加的时间分
     */
    public static String plusMinuteToStr(int minute){
        Date d = new Date();
        Calendar ca = Calendar.getInstance();
        ca.add(Calendar.MINUTE, minute);// num为增加的分数，可以改变的
        d = ca.getTime();
        return new SimpleDateFormat(myFmt).format(d);
    }
	/**
     * 当前日期时间加上多少秒
     * @param second 为增加的时间秒
     */
    public static Date plusSecond(int second){
        Date d = new Date();
        Calendar ca = Calendar.getInstance();
        ca.add(Calendar.SECOND, second);// second为增加的秒数，可以改变的
        d = ca.getTime();
        return d;
    }
    /**
     * 当前日期时间加上多少秒
     * @param second 为增加的时间秒
     */
    public static String plusSecondToStr(int second){
        Date d = new Date();
        Calendar ca = Calendar.getInstance();
        ca.add(Calendar.SECOND, second);// second为增加的秒数，可以改变的
        d = ca.getTime();
        return new SimpleDateFormat(myFmt).format(d);
    }

    /**
     * 获取两个时间的毫秒差
     * @param begin 开始时间
     * @param end   结束时间
     * @return 毫秒数
     */
    public static Long getDiff(Date begin, Date end){
        return (end.getTime() - begin.getTime());
    }
    
    /**
     * 将时间转换为时间戳   2018-09-12 01:01:01 --> 1536685261000
     * @param s 日期格式字符串 yyyy-MM-dd HH:mm:ss
     * @throws ParseException
     */
    public static String dateToStamp(String s) throws ParseException {
        String res;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = simpleDateFormat.parse(s);
        long ts = date.getTime();
        res = String.valueOf(ts);
        return res;
    }
    /**
     * 将时间戳转换为时间 1536685261 --> 2018-09-12 01:01:01
     * @param s 时间戳格式字符串:10位长度的字符串
     * @return 日期格式yyyy-MM-dd HH:mm:ss
     */
    public static String stampToDate(String s){
        String res;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        long lt = new Long(s);
        Date date = new Date(lt);
        res = simpleDateFormat.format(date);
        return res;
    }

    /**
     * 多功能版,可以累加時間的各個數值 默認是分
     * 2018-09-01 01:01:01, 1,"hour" --> 2018-09-01 02:01:01
     * @param timeStr
     * @param num
     * @param type
     * @return
     */
    public static String addTime(String timeStr, Integer num, String type){
        String str=null;
        try {
            SimpleDateFormat df = new SimpleDateFormat(myFmt);
            Date date = df.parse(timeStr);
            //时间累计
            Calendar gc =new GregorianCalendar();
            gc.setTime(date);
            switch(type) {
            case "year":
            	gc.add(GregorianCalendar.YEAR,num);
            	break;
            case "month":
            	gc.add(GregorianCalendar.MONTH,num);
            	break;
            case "day":
            	gc.add(GregorianCalendar.DATE,num);
            	break;
            case "hour":
            	gc.add(GregorianCalendar.HOUR,num);
            	break;
            case "minute":
            	gc.add(GregorianCalendar.MINUTE,num);
            	break;
            case "second":
            	gc.add(GregorianCalendar.SECOND,num);
            	break;
            default:
            	gc.add(GregorianCalendar.MINUTE,num);
            	break;
            }
            str=  df.format(gc.getTime());
        }catch (Exception e){
        	e.printStackTrace();
        	str = timeStr;
        }
        return str;
    }

}
