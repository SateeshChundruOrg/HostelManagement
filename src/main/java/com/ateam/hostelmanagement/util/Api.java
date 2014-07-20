package com.ateam.hostelmanagement.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;
import java.io.Writer;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.TimeZone;

import javax.xml.bind.DatatypeConverter;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.lang.time.DateFormatUtils;
import org.apache.commons.lang.time.DateUtils;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;



public class Api {

	private static Map<String, String> companyLabelMap;
	public static enum DateType{YEAR,MOTH,DAY,HOUR,MINUTE,SECOND};
	public static enum EmpTrackType{JOB,LEAVE,WORKING_HOUR,SPECIAL_WORKING};
	public static enum CsvOptions{FILTER_NULL_OR_EMPTY,NONE};

	public static String populateTemplate(String template,
			Map<String, String> values) {
		if (values == null || isEmptyString(template)) {
			return template;
		} else {
			Iterator<String> keyIterator = values.keySet().iterator();
			while (keyIterator.hasNext()) {
				String key = keyIterator.next();
				String value = values.get(key);

				if (key != null) {
					value = makeEmptyIfNull(value);
					template = template.replace(key, value);
				}
			}

			return template;
		}
	}

	public static String[] csvToArray(String csv) {
		String[] parts = null;

		if (!Api.isEmptyString(csv)) {
			parts = csv.split(",");
		}

		return parts;
	}

	public static List<String> csvToList(String csv) {
		ArrayList<String> list = new ArrayList<String>();

		if (!Api.isEmptyString(csv)) {
			String[] parts = csv.split(",");
			for (String part : parts) {
				list.add(part.trim());
			}
		}

		return list;
	}

	public static List<Long> csvToLongList(String csv) {
		ArrayList<Long> list = new ArrayList<Long>();

		if (!Api.isEmptyString(csv)) {
			String[] parts = csv.split(",");
			for (String part : parts) {
				list.add(Long.parseLong(part.trim()));
			}
		}

		return list;
	}

	public static String getCheckSum(File checkSumFIle) {
		String checkSum = "";
		InputStream is = null;
		try {
			// System.out.println("in getCheckSum method ");
			MessageDigest md = MessageDigest.getInstance("MD5");
			is = new FileInputStream(checkSumFIle);

			int length = 512;
			byte bt[] = new byte[length];
			int read = 0;

			while ((read = is.read(bt, 0, length)) != -1) {
				md.update(bt, 0, read);
			}
			checkSum = new BigInteger(1, md.digest()).toString(16);
			if (checkSum.length() < 32) {
				int l = 32 - checkSum.length();
				for (int i = 0; i < l; i++) {
					checkSum = "0" + checkSum;
				}
			}
			// System.out.println("check sum is " + checkSum);
		} catch (Exception e) {
			// System.out.println("Error " + e.toString());
			//Log.info(Api.class, "Error: " + e.toString(), e);
		} finally {
			try {
				if (is != null)
					is.close();
			} catch (Exception e) {
				// System.out.println("Error " + e.toString());
				//Log.info(Api.class, "Error: " + e.toString(), e);
			}
		}
		return checkSum;
	}

	public static String toJson(Object object) throws JsonGenerationException,
			JsonMappingException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		Writer strWriter = new StringWriter();
		mapper.writeValue(strWriter, object);
		return strWriter.toString();
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static Object fromJson(String json, Class class1)
			throws JsonParseException, JsonMappingException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		return mapper.readValue(json, class1);
	}

	@SuppressWarnings("rawtypes")
	public static Object fromJson(String json, TypeReference type)
			throws JsonParseException, JsonMappingException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		return mapper.readValue(json, type);
	}

	public static String[] orderByOrder(String orderBy, String order,
			String orderByDefault) {
		if (Api.isEmptyString(order)) {
			order = "ASC";
		}

		orderBy = Api.makeNullIfNull(orderBy);
		if (orderBy == null) {
			orderBy = orderByDefault;
		} else {
			if (orderBy.indexOf("`") < 0) {
				orderBy = "`" + orderBy + "`";
			}
		}

		if (!(order.equals("ASC") || order.equals("DESC"))) {
			order = "ASC";
		}

		return new String[] { orderBy, order };
	}

	public static String toCSV(Object[] strings) {
		if (strings != null) {
			String csv = "";
			for (Object string : strings) {
				if (string != null) {
					if (csv.length() > 0) {
						csv += ", ";
					}

					csv += string.toString();
				}
			}

			return csv;
		} else {
			return null;
		}
	}

	public static String toCSV(List<?> list) {
		if (list != null) {
			String csv = "";
			for (Object obj : list) {
				if (csv.length() > 0) {
					csv += ", ";
				}

				csv += obj.toString();
			}

			return csv;
		} else {
			return null;
		}
	}
	
	public static String toCSV1(List<?> list) {
		if (list != null) {
			String csv = "";
			for (Object obj : list) {
				if (csv.length() > 0) {
					csv += ",";
				}

				csv += obj.toString();
			}

			return csv;
		} else {
			return null;
		}
	}

	public static boolean like(String toBeCompare, String by) {
		if (by != null) {
			if (toBeCompare != null) {
				if (by.startsWith("%") && by.endsWith("%")) {
					int index = toBeCompare.toLowerCase().indexOf(
							by.replace("%", "").toLowerCase());
					if (index < 0) {
						return false;
					} else {
						return true;
					}
				} else if (by.startsWith("%")) {
					return toBeCompare.endsWith(by.replace("%", ""));
				} else if (by.endsWith("%")) {
					return toBeCompare.startsWith(by.replace("%", ""));
				} else {
					return toBeCompare.equals(by.replace("%", ""));
				}
			} else {
				return false;
			}
		} else {
			return false;
		}
	}

	public static String toString(String[] strings, String seperator) {
		if (strings != null) {
			String str = "";
			for (String string : strings) {
				if (str.length() > 0) {
					str += seperator;
				}

				str += string;
			}

			return str;
		} else {
			return null;
		}
	}

	public static String toString(int num, int minLength, String append) {
		String str = "" + num;

		if (append == null) {
			append = "0";
		}

		int diff = minLength - str.length();
		if (diff > 0) {
			str = append + str;
		}
		return str;
	}

	public static String encodeNewLinesAndQuotes(String string) {
		string = string.replace("\n", "&-nl-n;");
		string = string.replace("\r", "&-nl-r;");
		string = string.replace("'", "&-sq;");
		string = string.replace("\"", "&-dq;");
		return string;
	}

	public static String decodeNewLinesAndQuotes(String string) {
		string = string.replace("&-nl-n;", "\n");
		string = string.replace("&-nl-r;", "\r");
		string = string.replace("&-sq;", "'");
		string = string.replace("&-dq;", "\"");
		return string;
	}

	public static String formatDistance(long distance) {
		String resp = "";

		long diff[] = new long[] { 0, 0 };

		/* M */diff[1] = (distance >= 1000 ? distance % 1000 : distance);
		/* KM */diff[0] = (distance / 1000);

		if (diff[0] > 0) {
			resp = diff[0] + " KM";

			if (diff[1] > 0) {
				double dist = round(diff[0] + ((diff[1] * 1.0) / 1000), 2);
				resp = dist + " KM";
			}
		} else {
			resp = diff[1] + " Meter";
		}

		return resp;
	}

	public static String formatFileSize(long size) {
		String resp = "";

		long diff[] = new long[] { 0, 0, 0, 0, 0 };

		/* B */diff[4] = (size >= 1024 ? size % 1024 : size);
		/* KB */diff[3] = (size = (size / 1024)) >= 1024 ? size % 1024 : size;
		/* MB */diff[2] = (size = (size / 1024)) >= 1024 ? size % 1024 : size;
		/* GB */diff[1] = (size = (size / 1024)) >= 1024 ? size % 1024 : size;
		/* TB */diff[0] = (size = (size / 1024));

		if (diff[0] > 0) {
			resp = diff[0] + " TB";
		} else if (diff[1] > 0) {
			resp = diff[1] + " GB";
		} else if (diff[2] > 0) {
			resp = diff[2] + " MB";
		} else if (diff[3] > 0) {
			resp = diff[3] + " KB";
		} else {
			resp = diff[4] + " B";
		}

		return resp;
	}

	private static long[] getTimeElapse(long diffInSeconds) {
		long diff[] = new long[] { 0, 0, 0, 0 };
		/* sec */diff[3] = (diffInSeconds >= 60 ? diffInSeconds % 60
				: diffInSeconds);
		/* min */diff[2] = (diffInSeconds = (diffInSeconds / 60)) >= 60 ? diffInSeconds % 60
				: diffInSeconds;
		/* hours */diff[1] = (diffInSeconds = (diffInSeconds / 60)) >= 24 ? diffInSeconds % 24
				: diffInSeconds;
		/* days */diff[0] = (diffInSeconds = (diffInSeconds / 24));

		return diff;
	}

	public static String getTimeElapseShort(long diffInSeconds) {
		String resp = "";

		long diff[] = getTimeElapse(diffInSeconds);

		if (diff[0] > 0) {
			resp = String.format("%d day%s", diff[0], diff[0] > 1 ? "s" : "");
		} else if (diff[1] > 0) {
			resp = String.format("%d hr%s", diff[1], diff[1] > 1 ? "s" : "");
		} else if (diff[2] > 0) {
			resp = String.format("%d min%s", diff[2], diff[2] > 1 ? "s" : "");
		} else {
			resp = String.format("%d sec%s", diff[3], diff[3] > 1 ? "s" : "");
		}

		return resp;
	}

	public static String getTimeElapseLong(long diffInSeconds) {
		String resp = "";

		long diff[] = getTimeElapse(diffInSeconds);

		if (diff[0] > 0) {
			resp = String.format("%d day%s", diff[0], diff[0] > 1 ? "s" : "");

			if (diff[1] > 0) {
				resp += String.format(" %d hr%s", diff[1], diff[1] > 1 ? "s"
						: "");
			}
		} else if (diff[1] > 0) {
			resp = String.format("%d hr%s", diff[1], diff[1] > 1 ? "s" : "");

			if (diff[1] > 0) {
				resp += resp = String.format(" %d min%s", diff[2],
						diff[2] > 1 ? "s" : "");
			}
		} else if (diff[2] > 0) {
			resp = String.format("%d min%s", diff[2], diff[2] > 1 ? "s" : "");

			if (diff[1] > 0) {
				resp = String.format(" %d sec%s", diff[3], diff[3] > 1 ? "s"
						: "");
			}
		} else {
			// resp = String.format("%d sec%s", diff[3], diff[3] > 1 ? "s" :
			// "");
			resp = "few secs";
		}

		return resp;
	}

	public static String getTimeElapseShortForExpiry(long diffInSeconds) {
		String resp = "";

		long diff[] = getTimeElapse(diffInSeconds);

		// if (diff[0] > 0) {
		// resp = String.format("%d day%s", diff[0], diff[0] > 1 ? "s" : "");
		// } else if (diff[1] > 0) {
		// resp = String.format("%d hr%s", diff[1], diff[1] > 1 ? "s" : "");
		// } else if (diff[2] > 0) {
		// resp = String.format("%d min%s", diff[2], diff[2] > 1 ? "s" : "");
		// } else {
		// resp = String.format("%d sec%s", diff[3], diff[3] > 1 ? "s" : "");
		// }

		if (diff[0] > 0) {
			resp = String.format("%d day%s", (diff[0] + 1), diff[0] > 1 ? "s"
					: "");
		} else if (diff[1] > 0) {
			resp = String.format("%d hr%s", diff[1], diff[1] > 1 ? "s" : "");
		} else if (diff[2] > 0) {
			resp = String.format("%d min%s", diff[2], diff[2] > 1 ? "s" : "");
		} else {
			resp = String.format("%d sec%s", diff[3], diff[3] > 1 ? "s" : "");
		}

		return resp;
	}

	public static String getTimeElapseTillNow(String dateTime)
			throws ParseException {
		Calendar calendarRef = toCalendar(getDateTimeInUTC(dateTime));
		calendarRef.setTimeZone(TimeZone.getTimeZone("UTC"));

		return getTimeElapseTillNow(calendarRef);
	}

	public static String getTimeElapseTillNow(Calendar calendarRef) {
		long ref = calendarRef.getTimeInMillis();
		long now = System.currentTimeMillis();

		long diff = Math.round((now - ref) / 1000);

		return getTimeElapseShortForExpiry(diff);
	}

	public static String getRandomString(int length) {
		String chars = "0123456789abcdefghijklmonpqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
		Random r = new Random();

		char[] buf = new char[length];

		for (int i = 0; i < buf.length; i++) {
			buf[i] = chars.charAt(r.nextInt(chars.length()));
		}

		return new String(buf);
	}

	public static String getDateTimeFromXsd(String datetimeXsd) {
		Calendar calendar = DatatypeConverter.parseDateTime(datetimeXsd);
		String datetime = Api.getDateTimeInUTC(calendar);
		datetime = datetime.substring(0, 19);
		return datetime;
	}

	// public static Date getDateNowInUtc() {
	// Calendar calendar = getCalendarNowInUtc();
	// Date date = calendar.getTime();
	// return date;
	// }

	public static Date getDateNowInUtc() {
		Calendar calendar = getCalendarNowInUtc();
		long time = calendar.getTimeInMillis();
		time -= TimeZone.getDefault().getRawOffset();
		Date date = new Date(time);
		return date;
	}

	public static Date addDate(String date, int day) throws ParseException {
		Calendar calendar = Api.getCalendar(Api.getDateTimeInUTC(date));
		calendar.add(Calendar.DATE, day);
		return calendar.getTime();
	}

	public static Calendar getCalendarNowInUtc() {
		Calendar calendar = Calendar.getInstance();
		calendar.setTimeZone(TimeZone.getTimeZone("GMT"));
		calendar.setTimeInMillis(System.currentTimeMillis());
		return calendar;
	}

	public static Calendar getCalendarInUtc(long time) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTimeZone(TimeZone.getTimeZone("GMT"));
		calendar.setTimeInMillis(time);
		return calendar;
	}

	public static Calendar getCalendarInUtc(Calendar calendar) {
		Calendar calendar2 = Calendar.getInstance();
		calendar2.setTimeZone(TimeZone.getTimeZone("GMT"));
		calendar2.setTimeInMillis(calendar.getTimeInMillis());
		return calendar2;
	}

	public static Calendar getCalendarTimeInTz(Calendar calendar, String offset) {
		calendar.add(Calendar.MINUTE, -Integer.parseInt(offset));
		return calendar;
	}

	public static String getDateToString(Date date) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return format.format(date);
	}
	
	public static String getDateInStandardFormat(String dateString) {
	    if(isEmptyString(dateString)){
	    try {
		   Date  date = DateUtils.parseDate(dateString, new String[]{"yyyy-MM-dd HH:mm:ss","yyyy-MM-dd HH:mm:ss.s"});
		   
		    DateFormatUtils.format(date, "yyyy-MM-dd HH:mm:ss");
		  } catch (ParseException e) {
		      // TODO Auto-generated catch block
		      e.printStackTrace();
		      return null;
		  }
	    }
		//SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return dateString;
	}
	
      
	public static Long getDateTimeInMillies(String datetime){
	    if(!isEmptyString(datetime)){
		    try {
			   Date  date = DateUtils.parseDate(datetime, new String[]{"yyyy-MM-dd HH:mm:ss","yyyy-MM-dd HH:mm:ss.s"});
			   
			   return date.getTime();
			  } catch (ParseException e) {
			      // TODO Auto-generated catch block
			      e.printStackTrace();
			      
			  }
		    }
			//SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	            return null;
	}

	public static String getDateTimeInUTC(Calendar calendar) {
		Date date = calendar.getTime();
		return getDateTimeInUTC(date);
	}

	public static String getDateInUTC(Date date) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		format.setTimeZone(TimeZone.getTimeZone("GMT"));
		return format.format(date);
	}

	public static String getDateTimeInUTC(Date date) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		format.setTimeZone(TimeZone.getTimeZone("GMT"));
		return format.format(date);
	}

	public static Date getDateTimeInUTC(String date) throws ParseException {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		format.setTimeZone(TimeZone.getTimeZone("GMT"));
		return format.parse(date);
	}

	public static String toUtcXsd(String date) throws ParseException {
		Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("GMT"));
		try {
			calendar.setTimeInMillis(getDateTimeInUTC(date).getTime());
		} catch (ParseException e) {
			try {
				calendar = DatatypeConverter.parseDateTime(date);
			} catch (IllegalArgumentException ee) {
				throw e;
			}
		}
		return DatatypeConverter.printDateTime(calendar);
	}

	public static Calendar toCalendar(Date date) {
		Calendar calendar = Calendar.getInstance();
		// calendar.setTimeZone(TimeZone.getTimeZone("GMT"));
		calendar.setTime(date);
		return calendar;
	}

	public static String getDateInTz(Calendar calendar, String offset) {
		calendar.add(Calendar.MINUTE, -Integer.parseInt(offset));
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		format.setTimeZone(TimeZone.getTimeZone("GMT"));
		return format.format(calendar.getTime());
	}

	public static String getDateTimeInTz(Calendar calendar, String offset) {
		calendar.add(Calendar.MINUTE, -Integer.parseInt(offset));
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm a");
		format.setTimeZone(TimeZone.getTimeZone("GMT"));
		return format.format(calendar.getTime());
	}

	public static String getDateTimeInTz24(Calendar calendar, String offset) {
		calendar.add(Calendar.MINUTE, -Integer.parseInt(offset));
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		format.setTimeZone(TimeZone.getTimeZone("GMT"));
		return format.format(calendar.getTime());
	}
	
	public static String getDateTimeWithGivenTime(Calendar calendar, String offset) {
		calendar.add(Calendar.MINUTE, -Integer.parseInt(offset));
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return format.format(calendar.getTime());
	}
	
	public static String getDateTimeInTz24(String dateTime, String offset) {
		Date date =getDateFromString(dateTime);
		Calendar calendar= getCalendar(date);
		return getDateTimeWithGivenTime(calendar, offset);
	}

	public static Calendar getCalendar(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTimeZone(TimeZone.getTimeZone("GMT"));
		calendar.setTime(date);
		return calendar;
	}

	public static String getDateTimeInTzToUtc(Calendar calendar, String offset) {
		calendar.add(Calendar.MINUTE, Integer.parseInt(offset));
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		format.setTimeZone(TimeZone.getTimeZone("GMT"));
		return format.format(calendar.getTime());
	}

	public static Calendar getCalendarInTzToUtc(Calendar calendar, String offset) {
		calendar.add(Calendar.MINUTE, Integer.parseInt(offset));
		calendar.setTimeZone(TimeZone.getTimeZone("GMT"));
		return calendar;
	}

	public static String getDateTimeInTzToXsd(Calendar calendar, String offset) {
		calendar.add(Calendar.MINUTE, -Integer.parseInt(offset));
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		format.setTimeZone(TimeZone.getTimeZone("GMT"));
		return format.format(calendar.getTime());
	}

	public static String getDateTimeInTzToXsd(String dateTime, String offset) {
		try {
			Calendar calendar = getCalendar(getDateTimeInUTC(dateTime));
			return getDateTimeInTzToXsd(calendar, offset);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static String getDateTimeInTzToUtc(String dateTime, String offset) {
		try {
			Calendar calendar = getCalendar(getDateTimeInUTC(dateTime));
			return getDateTimeInTzToUtc(calendar, offset);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static Integer getGivenFieldFromDateAndTime(String dateAndTime, DateType type) {
	   Date date;
	  try {
	      date = DateUtils.parseDate(dateAndTime, new String[]{"yyyy-MM-dd HH:mm:ss","yyyy-MM-dd HH:mm:ss.s","yyyy-MM-dd"});
	  } catch (ParseException e) {
	      // TODO Auto-generated catch block
	      e.printStackTrace();
	      return null;
	  }
	    Calendar calendar = Calendar.getInstance();
	    calendar.setTime(date);
	    switch(type){
	    case YEAR:
	    return calendar.get(Calendar.DAY_OF_YEAR);
	    case MOTH:
	    return calendar.get(Calendar.DAY_OF_MONTH);
	    case DAY:
	    return calendar.get(Calendar.DAY_OF_WEEK);
	    case HOUR:
	    return  calendar.get(Calendar.HOUR_OF_DAY);
	    case MINUTE:
	    return   calendar.get(Calendar.MINUTE);
	    case SECOND:
	    return calendar.get(Calendar.SECOND);
	    }
	    
	    return null;
	}

	

        public static String getTimeInTz24(String time, String offset)
			throws ParseException {
		SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
		Date date = format.parse(time);
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.MINUTE, -Integer.parseInt(offset));

		int hour = calendar.get(Calendar.HOUR_OF_DAY);
		int minute = calendar.get(Calendar.MINUTE);
		int second = calendar.get(Calendar.SECOND);

		return (hour > 9 ? hour : "0" + hour) + ":"
				+ (minute > 9 ? minute : "0" + minute) + ":"
				+ (second > 9 ? second : "0" + second);
	}

	public static String getTimeInTzToUtc(String time, String offset)
			throws ParseException {
		SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
		Date date = format.parse(time);
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.MINUTE, Integer.parseInt(offset));

		int hour = calendar.get(Calendar.HOUR_OF_DAY);
		int minute = calendar.get(Calendar.MINUTE);
		int second = calendar.get(Calendar.SECOND);

		return (hour > 9 ? hour : "0" + hour) + ":"
				+ (minute > 9 ? minute : "0" + minute) + ":"
				+ (second > 9 ? second : "0" + second);
	}

	public static String[] getDateRangeInUTC(Calendar calendar,
			int calendarStartField, int startVal, int calendarEndField,
			int endVal) {
		Calendar ref = Api.getCalendarNowInUtc();
		ref.setTimeInMillis(calendar.getTimeInMillis());

		Calendar start = Api.getCalendarNowInUtc();
		start.setTimeInMillis(ref.getTimeInMillis());
		start.add(calendarStartField, startVal);

		Calendar end = Api.getCalendarNowInUtc();
		end.setTimeInMillis(ref.getTimeInMillis());
		end.add(calendarEndField, endVal);

		String[] range = new String[] { Api.getDateInUTC(start.getTime()),
				Api.getDateInUTC(end.getTime()) };

		return range;
	}

	public static long getTimeDifferenceOfDateTimeInMilies(String dateStart,
			String dateStop) throws ParseException {
		Date start = getDateTimeInUTC(dateStart);
		Date end = getDateTimeInUTC(dateStop);

		long diff = end.getTime() - start.getTime();

		return diff;
	}

	public static long getTimeDifferenceOfDateTimeInMinutes(String dateStart,
			String dateStop) throws ParseException {
		long diff = getTimeDifferenceOfDateTimeInMilies(dateStart, dateStop);
		return Math.round(diff / (60 * 1000));
	}

	public static long getTimeDifferenceOfDateTimeInMiliesForXsd(
			String dateStartXsd, String dateStopXsd) throws ParseException {

		Calendar start = DatatypeConverter.parseDateTime(dateStartXsd);
		Calendar end = DatatypeConverter.parseDateTime(dateStopXsd);

		long diff = end.getTimeInMillis() - start.getTimeInMillis();

		return diff;
	}

	public static long getTimeDifferenceInMilies(String startTime,
			String endTime) throws ParseException {

		String dateStart = "1970-01-01 " + startTime;
		String dateStop = "1970-01-01 " + endTime;

		long diff = getTimeDifferenceOfDateTimeInMilies(dateStart, dateStop);
		return diff;
	}

	public static long getTimeDifferenceInMinutes(String startTime,
			String endTime) throws ParseException {
		long diff = getTimeDifferenceInMilies(startTime, endTime);
		return Math.round(diff / (60 * 1000));
	}

	public static double latLongDistanceInMeter(double lat1, double lon1,
			double lat2, double lon2) {
		double lat1Rad = Math.toRadians(lat1);
		double lon1Rad = Math.toRadians(lon1);
		double lat2Rad = Math.toRadians(lat2);
		double lon2Rad = Math.toRadians(lon2);

		int R = 6371;

		// By Spherical Law of Cosines
		// double dist = Math.acos(Math.sin(lat1)
		// * Math.sin(lat2)
		// + Math.cos(lat1)
		// * Math.cos(lat2)
		// * Math.cos(lon2-lon1))
		// * R;

		// By Equirectangular approximation
		double x = (lon2Rad - lon1Rad) * Math.cos((lat1Rad + lat2Rad) / 2);
		double y = (lat2Rad - lat1Rad);
		double dist = Math.sqrt(x * x + y * y) * R;

		// System.out.println("D> " + "lat1: "+latLong1.getLatitude() +
		// " lon1: "+latLong1.getLongitude() + " lat2: "+latLong2.getLatitude()
		// + " lon2: "+latLong1.getLongitude() + " Dis:" + (dist*1000));

		return dist * 1000;
	}

	/*public static double latLongDistanceInMeter(LatLong latLong1,
			LatLong latLong2) {
		return latLongDistanceInMeter(latLong1.getLatitude(),
				latLong1.getLongitude(), latLong2.getLatitude(),
				latLong2.getLongitude());
	}
*/
	public static boolean startsWith(String str, String prefix,
			boolean ignoreCase) {
		if (str == null || prefix == null) {
			return (str == null && prefix == null);
		}
		if (prefix.length() > str.length()) {
			return false;
		}
		return str.regionMatches(ignoreCase, 0, prefix, 0, prefix.length());
	}

	public static String makeNullIfEmpty(String value) {
		if (value != null && value.trim().length() == 0) {
			return null;
		} else {
			return value;
		}
	}

	public static String makeNullIfNull(String value) {
		if (value == null) {
			return null;
		}

		if (value.trim().length() == 0) {
			return null;
		} else {
			if (value.equals("null") || value.equals("Null")
					|| value.equals("NULL")) {
				return null;
			} else {
				return value;
			}
		}
	}

	public static String escapChar(String value, char... chars) {
		if (value != null && value.length() > 0) {
			if (chars != null) {
				for (char c : chars) {
					value = value.replace(c + "", "\\" + c);
				}
			}
		}

		return value;
	}

	public static String makeEmptyIfNull(String value) {
		if (value == null) {
			return "";
		} else {
			return value;
		}
	}

	/*public static void filterDisableEmployees(List<Employee> employees) {
		if (employees != null && employees.size() > 0) {
			Iterator<Employee> emloyeeIterator = employees.iterator();
			while (emloyeeIterator.hasNext()) {
				Employee employee = emloyeeIterator.next();
				if (employee.getStatus() == 0) {
					emloyeeIterator.remove();
				}
			}
		}
	}*/

	public static boolean isNonZeroPositiveLong(Long long1) {
		if (long1 == null || long1.longValue() <= 0) {
			return false;
		} else {
			return true;
		}
	}

	public static boolean isEqualLong(Long long1, Long long2) {
		if (long1 == null) {
			if (long2 == null) {
				return true;
			} else {
				return false;
			}
		} else {
			if (long2 == null) {
				return false;
			} else {
				return long1.longValue() == long2.longValue();
			}
		}
	}

	public static boolean isLength(long value, int length) {
		return String.valueOf(value).length() == length ? true : false;
	}

	public static boolean isLong(String value) {
		try {
			Long.parseLong(value);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public static boolean isInteger(String string1) {
		try {
			Integer.parseInt(string1);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public static boolean isEmptyString(String string1) {
		if (string1 != null && string1.trim().length() > 0) {
			return false;
		} else {
			return true;
		}
	}

	public static boolean isEqualString(String string1, String string2) {
		if (string1 == null) {
			if (string2 == null) {
				return true;
			} else {
				return false;
			}
		} else {
			return string1.equals(string2);
		}
	}

	public static boolean isEqualString(String string1, String string2,
			boolean makeNullIfEmpty) {
		if (makeNullIfEmpty) {
			return isEqualString(makeNullIfEmpty(string1),
					makeNullIfEmpty(string2));
		} else {
			return isEqualString(string1, string2);
		}
	}

	public static boolean isEqualStringIgnoreCase(String string1, String string2) {
		if (string1 == null) {
			if (string2 == null) {
				return true;
			} else {
				return false;
			}
		} else {
			return string1.equalsIgnoreCase(string2);
		}
	}

	public static int compare(String string1, String string2, boolean desc) {
		if (string1 == null) {
			if (string2 == null) {
				return 0;
			} else {
				if (desc) {
					return 1;
				} else {
					return -1;
				}
			}
		} else {
			if (string2 == null) {
				if (desc) {
					return -1;
				} else {
					return 1;
				}
			} else {
				int result = string1.compareTo(string2);
				if (result == 0) {
					return 0;
				} else if (result < 0) {
					if (desc) {
						return 1;
					} else {
						return -1;
					}
				} else {
					if (desc) {
						return -1;
					} else {
						return 1;
					}
				}
			}
		}
	}

	public static String replaceAllNewLineChar(String input) {
		String output = replaceAllSkipNull(input, "\n", " ");
		output = replaceAllSkipNull(output, "\r", " ");
		return output;
	}

	public static String replaceAllSkipNull(String input, String regex,
			String replacement) {
		if (input != null) {
			return input.replaceAll(regex, replacement);
		} else {
			return null;
		}
	}

	public static double round(double unrounded, int precision) {
		return round(unrounded, precision, BigDecimal.ROUND_HALF_DOWN);
	}

	public static double round(double unrounded, int precision, int roundingMode) {
		BigDecimal bd = new BigDecimal(unrounded);
		BigDecimal roundedBig = bd.setScale(precision, roundingMode);
		double rounded = roundedBig.doubleValue();
		return rounded;
	}

	public static boolean isAvailable(List<String> formIds, String string2) {
		if ((formIds != null) && (!isEmptyString(string2))) {
			for (int i = 0; i < formIds.size(); i++) {
				if (isEqualString((String) formIds.get(i), string2))
					return true;
			}
		} else {
			return true;
		}
		return false;
	}

	public static String addTimeToTime(String startTime, long visitduration) {
		String dateStart = "01/26/2012 " + startTime;
		SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy HH:mm");
		SimpleDateFormat timeFormate = new SimpleDateFormat("HH:mm:ss");
		try {
			Date oldDate = format.parse(dateStart);
			Calendar cal = Calendar.getInstance();
			cal.setTime(oldDate);
			cal.add(Calendar.MINUTE, (int) visitduration);
			Date newdate = cal.getTime();
			return timeFormate.format(newdate);

		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public static String addTimeToDateTime(String startDateTime,
			long visitduration) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		// SimpleDateFormat timeFormate = new SimpleDateFormat("HH:mm");
		try {
			Date oldDate = format.parse(startDateTime);
			Calendar cal = Calendar.getInstance();
			cal.setTime(oldDate);
			cal.add(Calendar.MINUTE, (int) visitduration);
			Date newdate = cal.getTime();
			return format.format(newdate);

		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public static String longDateTimeToString(long time) {
		Date date = new Date(time);
		return dateTimeToString(date);
	}

	public static String dateTimeToString(Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MMM/yyyy hh:mm:ss a");
		String d = sdf.format(date);
		return d;
	}

	public static String getDateInUTC(Calendar calendar) {
		Date date = calendar.getTime();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		format.setTimeZone(TimeZone.getTimeZone("GMT"));
		return format.format(date);
	}

	public static Calendar getDateTimeInUTC(long time) {
		long millis = TimeZone.getDefault().getRawOffset();
		time = time - millis;
		Calendar calendar = Calendar.getInstance();
		calendar.setTimeZone(TimeZone.getTimeZone("GMT"));
		calendar.setTimeInMillis(time);
		return calendar;
	}

	public static long getCurrentTimeInUTCLong() {
		long millis = TimeZone.getDefault().getRawOffset();
		long time = System.currentTimeMillis() - millis;
		// Calendar calendar = Calendar.getInstance();
		// calendar.setTimeZone(TimeZone.getTimeZone("GMT"));
		// calendar.setTimeInMillis(time);
		return time;
	}

	public static boolean checkDuplicateUsingAdd(Object[] input) {
		Set<Object> tempSet = new HashSet<Object>();
		for (Object obj : input) {
			if (!tempSet.add(obj)) {
				return true;
			}
		}
		return false;
	}

	public static String formatNumber(long number) {
		NumberFormat nf = new DecimalFormat("00000");
		return nf.format(number);
	}

	public static boolean isValidMimeType(FileItem fileItem,
			String... mimeTypes) {
		if (mimeTypes != null && fileItem != null) {
			String fileMimeType = fileItem.getContentType();
			for (String mimeType : mimeTypes) {
				if (mimeType.contains("/*")) {
					String mimeTypeStartsWith = mimeType.split("//*")[0];
					if (fileMimeType.toLowerCase().startsWith(
							mimeTypeStartsWith.toLowerCase())) {
						return true;
					}
				} else {
					if (fileMimeType.equalsIgnoreCase(mimeType)) {
						return true;
					}
				}
			}
		}
		return false;
	}

	

	public static boolean isEqualList(List<?> list1, List<?> list2) {
		if (list1 == null && list2 == null) {
			return true;
		} else if (list1 == null || list2 == null) {
			return false;
		} else if (list1.size() != list2.size()) {
			return false;
		} else {
			for (int i = 0; i < list1.size(); i++) {
				Object item1 = list1.get(i);
				Object item2 = list2.get(i);
				if (!item1.equals(item2)) {
					return false;
				}
			}
			return true;
		}
	}

	public static String[] strToArray(String str, String regex) {
		String[] parts = null;

		if (!Api.isEmptyString(str)) {
			parts = str.trim().split(regex);
		}

		return parts;
	}

	public static List<String> strToList(String str, String regex) {
		ArrayList<String> list = new ArrayList<String>();

		if (!Api.isEmptyString(str)) {
			String[] parts = strToArray(str, regex);
			for (String part : parts) {
				if (!Api.isEmptyString(part)) {
					list.add(part.trim());
				}
			}
		}

		return list;
	}

	public static Map<String, String> getCompanyLabelClientKeysMap() {
		if (companyLabelMap == null) {
			companyLabelMap = new HashMap<String, String>();
			companyLabelMap.put("1", "label_customer_singular");
			companyLabelMap.put("2", "label_customer_plural");
			companyLabelMap.put("3", "label_employee_singular");
			companyLabelMap.put("4", "label_employee_plural");
			companyLabelMap.put("5", "label_namedLocation_singular");
			companyLabelMap.put("6", "label_namedLocation_plural");
			companyLabelMap.put("7", "label_knowledgeBase_singular");
			companyLabelMap.put("8", "label_knowledgeBase_plural");
			companyLabelMap.put("9", "label_form_singular");
			companyLabelMap.put("10", "label_form_plural");
			companyLabelMap.put("11", "label_job_singular");
			companyLabelMap.put("12", "label_job_plural");
			companyLabelMap.put("13", "label_list_singular");
			companyLabelMap.put("14", "label_list_plural");

		}
		return companyLabelMap;
	}

	public static Object getFieldValue(Object obj, String fieldName)
			throws IllegalArgumentException, IllegalAccessException {
		if (fieldName != null && fieldName.trim().length() >= 0) {
			Field[] fields = obj.getClass().getDeclaredFields();
			for (Field field : fields) {
				String name = field.getName();
				if (name.equalsIgnoreCase(fieldName.trim())) {
					field.setAccessible(true);
					return field.get(obj);
				}
			}
		}

		return null;
	}

	public static String toCSV(List<?> list, String fieldName)
			throws IllegalArgumentException, IllegalAccessException {
		if (list != null) {
			String csv = "";
			for (Object obj : list) {
				if (csv.length() > 0) {
					csv += ",";
				}

				if (fieldName == null || fieldName.trim().length() == 0) {
					csv += obj.toString();
				} else {
					Object val = getFieldValue(obj, fieldName);
					csv += val == null ? "" : val.toString();
				}
			}

			return csv;
		} else {
			return null;
		}
	}
	
	
	public static String toCSV(List<?> list, String fieldName,CsvOptions csvOption){
	try{
		if (list != null) {
			String csv = "";
			for (Object obj : list) {
				String value=BeanUtils.getProperty(obj, fieldName);
					
				if(CsvOptions.FILTER_NULL_OR_EMPTY==csvOption && Api.isEmptyString(value)){
					continue;
				}
				
				if (csv.length() > 0) {
					csv += ",";
				}
				
					csv += value == null ? "" : value;
				}
			return csv;
		}
		 else {
			return null;
		}
	}catch(Exception ex){
	//	Log.debug(Api.class, "in toCSV", ex);
		return null;
	}
}
	
	
	public static String toCSV(List<?> list, String fieldName,String valuInCaseNull)
			throws IllegalArgumentException, IllegalAccessException {
		if (list != null) {
			String csv = "";
			for (Object obj : list) {
				if (csv.length() > 0) {
					csv += ",";
				}

				if (fieldName == null || fieldName.trim().length() == 0) {
					csv += obj.toString();
				} else {
					Object val = getFieldValue(obj, fieldName);
					csv += val == null ? valuInCaseNull : val.toString();
				}
			}

			return csv;
		} else {
			return null;
		}
	}
	
	public static String getListFieldValueWithGiveKey(List<?> list, String requiredFieldValueName,String requiredKeyFieldName,String keyValue) {
	 try{
		if(requiredKeyFieldName!=null && requiredFieldValueName !=null){
		for (Object object : list) {
		String value =BeanUtils.getProperty(object, requiredKeyFieldName);
		if(value!=null&&value.equalsIgnoreCase(keyValue)){
			return BeanUtils.getProperty(object, requiredFieldValueName);
		}
	}
 }	
		}catch(Exception ex){
		 
	 }		
	 return null;
	}
	
	
	public static boolean islistContainsGivenValue(List<?> list, String requiredPropertyName,String giveValue) {
		 try{
			if(requiredPropertyName!=null){
			for (Object object : list) {
			String value =BeanUtils.getProperty(object, requiredPropertyName);
			if(value!=null&&value.equalsIgnoreCase(giveValue)){
				return true;
			}
		}
	 }	
			}catch(Exception ex){
			 
		 }		
		 return false;
		}
	
	
	public static boolean islistContainsAtleastOneValueInGivenValues(List<?> list, String requiredPropertyName,List<?> giveValues) {
		 try{
			if(requiredPropertyName!=null){
			for (Object object : list) {
			Object value =PropertyUtils.getProperty(object, requiredPropertyName);    //getProperty(object, requiredPropertyName);
			if(value!=null && giveValues.contains(value)){
				return true;
			}
		}
	 }	
			}catch(Exception ex){
			 
		 }		
		 return false;
		}
	
	
	public static Map<Object,Object> getMapFromList(List<?> list, String requiredFieldKeyName) {
		Map<Object,Object> map=new HashMap<Object,Object>();
		try{
			if(requiredFieldKeyName!=null){
			for (Object object : list) {
			//String valueKey =BeanUtils.getProperty(object, requiredFieldKeyName);
			Object valueKey=PropertyUtils.getProperty(object, requiredFieldKeyName);
			map.put(valueKey, object);
		}
	 }	
			}catch(Exception ex){
			 
		 }		
		 return map;
		}
	
	public static void removeDuplicatesFromList(List<?> list, String requiredFieldKeyName) {
		Map<String,Object> map=new HashMap<String,Object>();
		try{
			Iterator listTerator=list.iterator();
			while (listTerator.hasNext()) {
				Object object = (Object) listTerator.next();
				String valueKey=BeanUtils.getProperty(object, requiredFieldKeyName);
				if(map.containsKey(valueKey)){
					listTerator.remove();
				}else{
					map.put(valueKey, "");
				}
			}
			
			}catch(Exception ex){
			 
		 }		
		}
	
	
	public static Map<Object,List<Object>> getGroupedMapFromList(List<?> list, String requiredFieldKeyName) {
		Map<Object,List<Object>> map=new HashMap<Object,List<Object>>();
		try{
			if(requiredFieldKeyName!=null){
			for (Object object : list) {
			//String valueKey =BeanUtils.getProperty(object, requiredFieldKeyName);
			Object valueKey=PropertyUtils.getProperty(object, requiredFieldKeyName);
			List<Object> groupedObjectList=map.get(valueKey);
			if(groupedObjectList==null){
			 groupedObjectList=new ArrayList<Object>();
				map.put(valueKey, groupedObjectList);
			}
			groupedObjectList.add(object);
		}
	 }	
			}catch(Exception ex){
			 
		 }		
		 return map;
		}
	
	public static boolean isNumber(String number){
		try {
			Double.parseDouble(number);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	

	/*public static String getTimeZoneDates(String date, String myTimeZone,
			String employeeTimeZone) {

		try {
			if (employeeTimeZone != null && myTimeZone != null) {

				String myTimeZoneDate = Api.getDateTimeInTz(
						Api.getCalendar(Api.getDateTimeInUTC(date)), myTimeZone);
				String employeeTimeZoneDate = Api.getDateTimeInTz(
						Api.getCalendar(Api.getDateTimeInUTC(date)),
						employeeTimeZone);
				date = myTimeZoneDate + "(" + employeeTimeZoneDate + ")";

			} else if (myTimeZone != null) {
				String myTimeZoneDate = Api.getDateTimeInTz(
						Api.getCalendar(Api.getDateTimeInUTC(date)), myTimeZone);
				date = myTimeZoneDate;

			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return date;
	}*/
	
	public static String processStringValuesList(List<String> givenvalues) {
		//List<String> givenvalues = Api.csvToList(value);
		if (givenvalues != null) {
			List<String> tempList = new ArrayList<String>();
			for (String string : givenvalues) {
				string = string.replaceAll("'", "");
				string = "'" + string + "'";
				tempList.add(string);
			}

			return Api.toCSV(tempList);
		}
		return null;
	}
	 
	public static String processValue(String value){
	   if(!Api.isEmptyString(value)){
	    value = value.replaceAll("'", "");
	    value = "'" + value + "'";
	    }
	   return value;
	}

	public static String toCSVFromList(List<?> list, String fieldName){
		try{
			return toCSV(list, fieldName);
		}catch(Exception ex){
			
		}
		
		return null;
	}
	
	
	
	
	public static String toCSVFromList(List<?> list, String fieldName,String  valueIncaseNull){
		try{
			return toCSV(list, fieldName,valueIncaseNull);
		}catch(Exception ex){
			
		}
		
		return null;
	}
	
	

	public static String getTimeZoneDates(String date, String myTimeZone,
			String employeeTimeZone) {

		try {
			if ((employeeTimeZone != null && !employeeTimeZone.equalsIgnoreCase("null")) && (myTimeZone != null && !myTimeZone.equalsIgnoreCase("null") )) {

				String myTimeZoneDate = Api.getDateTimeInTz(DatatypeConverter.parseDateTime(date), myTimeZone);
						/*
						Api.getDateTimeInTz(
						Api.getCalendar(Api.getDateTimeInUTC(date)), myTimeZone);*/
				
				if(!myTimeZone.equalsIgnoreCase(employeeTimeZone)) {
					String employeeTimeZoneDate =Api.getDateTimeInTz(DatatypeConverter.parseDateTime(date), employeeTimeZone);
							/*Api.getDateTimeInTz(
							Api.getCalendar(Api.getDateTimeInUTC(date)),
							employeeTimeZone);*/
					myTimeZoneDate = myTimeZoneDate + " (" + employeeTimeZoneDate + ")";
				}
				date = myTimeZoneDate;

			} else if (myTimeZone != null) {
				/*String myTimeZoneDate = Api.getDateTimeInTz(
						Api.getCalendar(Api.getDateTimeInUTC(date)), myTimeZone);*/
				String myTimeZoneDate = Api.getDateTimeInTz(DatatypeConverter.parseDateTime(date), myTimeZone);
				date = myTimeZoneDate;

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return date;
	}

	public static String getTimeZoneDatesInDBFromDB(String date, String myTimeZone,
			String employeeTimeZone) {

		try {
			if ((employeeTimeZone != null && !employeeTimeZone.equalsIgnoreCase("null")) && (myTimeZone != null && !myTimeZone.equalsIgnoreCase("null") )) {

				String myTimeZoneDate = 
						Api.getDateTimeInTz(
						Api.getCalendar(Api.getDateTimeInUTC(date)), myTimeZone);
				
				if(!myTimeZone.equalsIgnoreCase(employeeTimeZone)) {
					String employeeTimeZoneDate =Api.getDateTimeInTz(
							Api.getCalendar(Api.getDateTimeInUTC(date)),
							employeeTimeZone);
					myTimeZoneDate = myTimeZoneDate + " (" + employeeTimeZoneDate + ")";
				}
				date = myTimeZoneDate;
			} else if (myTimeZone != null) {
				String myTimeZoneDate = Api.getDateTimeInTz(
						Api.getCalendar(Api.getDateTimeInUTC(date)), myTimeZone);
				date = myTimeZoneDate;

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return date;
	}
	public static String getTimeZoneDatesInLTZ(String date, String myTimeZone,
			String employeeTimeZone) {

		try {
			if ((employeeTimeZone != null && !employeeTimeZone.equalsIgnoreCase("null")) && (myTimeZone != null && !myTimeZone.equalsIgnoreCase("null") )) {

				String myTimeZoneDate = Api.getDateTimeInTz(Api.getCalendar(Api.getDateTimeInUTC(date)), myTimeZone);

				
				if(!myTimeZone.equalsIgnoreCase(employeeTimeZone)) {
					String employeeTimeZoneDate =Api.getDateTimeInTz(Api.getCalendar(Api.getDateTimeInUTC(date)), employeeTimeZone);
							
					myTimeZoneDate = myTimeZoneDate + " (" + employeeTimeZoneDate + ")";
				}
				date = myTimeZoneDate;

			} else if (myTimeZone != null) {
				String myTimeZoneDate = Api.getDateTimeInTz(Api.getCalendar(Api.getDateTimeInUTC(date)), myTimeZone);
				date = myTimeZoneDate;

			}else if (employeeTimeZone != null && !employeeTimeZone.equalsIgnoreCase("null")){
				String myTimeZoneDate = Api.getDateTimeInTz(Api.getCalendar(Api.getDateTimeInUTC(date)), employeeTimeZone);
				date = myTimeZoneDate;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return date;
	}
	
	public static String getJsonFromGivenObject(Object object){
		
		try {
			return Api.toJson(object);
		} catch (JsonGenerationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "[]";
	}


	public static String toGivenDelimeter(List<?> list,String delimeter) {
		if (list != null) {
			String csv = "";
			for (Object obj : list) {
				if (csv.length() > 0) {
					csv += delimeter;
				}
				
				csv += obj.toString();
			}

			return csv;
		} else {
			return null;
		}
	}

        public static Date getDateFromString(String dateTime) {
	  Date date;
	  try {
	      date = DateUtils.parseDate(dateTime, new String[]{"yyyy-MM-dd HH:mm:ss","yyyy-MM-dd HH:mm:ss.s"});
	      return date;
	  } catch (ParseException e) {
	      // TODO Auto-generated catch block
	      e.printStackTrace();
	      return null;
	  }
        }
	
      public static void copyGivenProperties(Object source,Object destination,List<String> objProp) throws IllegalAccessException, InvocationTargetException, NoSuchMethodException{
    	  
    	  for (String property : objProp) {
    		  Object value=PropertyUtils.getProperty(source, property);
    		  PropertyUtils.setProperty(destination, property, value);
		}
      }  
      
      public static String getCurrentTimeTz24(){
//      	return  DateFormatUtils.format(new Date(), "yyyy-MM-dd HH:mm:ss");
    	  	 Calendar cal = Calendar.getInstance();
    	  	 cal.add(Calendar.MINUTE, 15);
    	     SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    	     
    	     return sdf.format(cal.getTime());
      }
}
