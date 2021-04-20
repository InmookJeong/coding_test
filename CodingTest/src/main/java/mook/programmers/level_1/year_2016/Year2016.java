package mook.programmers.level_1.year_2016;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/**
 * Programmers Coding Test Level 1<br/>
 * 2016년
 * 
 * @author Dev.Mook
 * @since 2021.04.15
 */
public class Year2016 {

	public static void main(String[] args) {
		System.out.println(solution(5, 24));
	}
	
	/** 내가 생각한 Solution<br/>
	 * Google 검색을 통해 소스코드 작성.
	 * 
	 * @param a
	 * @param b
	 * @return
	 */
	public static String solution(int a, int b) {
		String answer = "";
		
		try {
			Date date = new SimpleDateFormat("yyyy-MM-dd").parse("2016-"+a+"-"+b);
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(date);
			int dayNumber = calendar.get(Calendar.DAY_OF_WEEK);
			
			answer = getWeek(dayNumber);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		return answer;
	}
	
	public static String getWeek(int dayNumber) {
		String week = "";
		switch(dayNumber){
			case 1:
				week = "SUN";
				break ;
			case 2:
				week = "MON";
				break ;
			case 3:
				week = "TUE";
				break ;
			case 4:
				week = "WED";
				break ;
			case 5:
				week = "THU";
				break ;
			case 6:
				week = "FRI";
				break ;
			case 7:
				week = "SAT";
				break ;
		}
		
		return week;
	}
	
	/** 다른 프로그래머의 풀이 1<br/>
	 *  Calendar 사용
	 * 
	 * @param month
	 * @param day
	 * @return
	 */
	public String solution_1(int month, int day) {
		Calendar cal = new Calendar.Builder().setCalendarType("iso8601").setDate(2016, month - 1, day).build();
		return cal.getDisplayName(Calendar.DAY_OF_WEEK, Calendar.SHORT, new Locale("ko-KR")).toUpperCase();
	}
	
	/** 다른 프로그래머의 풀이 2<br/>
	 *  월 별 누적 일수 계산
	 * 
	 * @param a
	 * @param b
	 * @return
	 */
	public String solution_2(int a, int b) {
		String answer = "";
		String[] day = { "FRI", "SAT", "SUN", "MON", "TUE", "WED", "THU" };
		int[] date = { 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
		int allDate = 0;
		for (int i = 0; i < a - 1; i++) {
			allDate += date[i];
		}
		allDate += (b - 1);
		answer = day[allDate % 7];
		
		return answer;
	}
	
	/** 다른 프로그래머의 풀이 3<br/>
	 *  다른 프로그래머의 풀이 2와 비슷, Switch 사용
	 * 
	 * @param a
	 * @param b
	 * @return
	 */
	public String solution_3(int a, int b) {
		String answer = " ";
		int[] monthDay={31,29,31,30,31,30,31,31,30,31,30,31};
		for (int i = 1; i < a; i++) {
			b+=monthDay[i-1];
		}
		switch(b%7){
			case 3:answer="SUN";break;
			case 4:answer="MON";break;
			case 5:answer="TUE";break;
			case 6:answer="WED";break;
			case 0:answer="THU";break;
			case 1:answer="FRI";break;
			case 2:answer="SAT";break;
		}
		
		return answer;
	}
	
	/** 다른 프로그래머의 풀이 4<br/>
	 *  LocalDate 사용
	 * 
	 * @param a
	 * @param b
	 * @return
	 */
	public String solution_4(int a, int b) {
		LocalDate date = LocalDate.of(2016, a, b);
		return date.getDayOfWeek().toString().substring(0, 3);
	}
	
	/** 다른 프로그래머의 풀이 5<br/>
	 *  다른 프로그래머의 풀이 4와 동일, LocalDate 사용
	 * 
	 * @param a
	 * @param b
	 * @return
	 */
	public String solution_5(int a, int b) {
		return LocalDate.of(2016, a, b).getDayOfWeek().toString().substring(0,3);
	}
	
	/** 다른 프로그래머의 풀이 6<br/>
	 * 	월 별 누적일수 계산.
	 * 
	 * @param a
	 * @param b
	 * @return
	 */
	public String solution_6(int a, int b) {
		int date=0;
		String answer = "day";
		if(a==1){
			date=0+b;
		} else if(a==2){
			date=31+b;
		} else if(a==3){
			date=31+29+b;
		} else if(a==4){
			date=31+29+31+b;
		} else if(a==5){
			date=31+29+31+30+b;
		} else if(a==6){
			date=31+29+31+30+31+b;
		} else if(a==7){
			date=31+29+31+30+31+30+b;
		} else if(a==8){
			date=31+29+31+30+31+30+31+b;
		} else if(a==9){
			date=31+29+31+30+31+30+31+31+b;
		} else if(a==10){
			date=31+29+31+30+31+30+31+31+30+b;
		} else if(a==11){
			date=31+29+31+30+31+30+31+31+30+31+b;
		} else if(a==12){
			date=31+29+31+30+31+30+31+31+30+31+30+b;
		}
		
		if(date%7==0){
			answer = "THU";
		} else if(date%7==1){
			answer = "FRI";
		} else if(date%7==2){
			answer = "SAT";
		} else if(date%7==3){
			answer = "SUN";
		} else if(date%7==4){
			answer = "MON";
		} else if(date%7==5){
			answer = "TUE";
		} else if(date%7==6){
			answer = "WED";
		}
	
		return answer;
	}
	
	/** 다른 프로그래머의 풀이 7<br/>
	 *  월 별 누적일수 계산, 엄청난 노력.
	 * 
	 * @param a
	 * @param b
	 * @return
	 */
	public String solution_7(int a, int b) {
		String answer = "";
		switch(a) {
			case 1:
				if(b % 7 == 1)
				  answer = "FRI";
				else if(b % 7 == 2)
				  answer = "SAT";
				else if(b % 7 == 3)
				  answer = "SUN";
				else if(b % 7 == 4)
				  answer = "MON";
				else if(b % 7 == 5)
				  answer = "TUE";
				else if(b % 7 == 6)
				  answer = "WED";
				else
				  answer = "THU";
				break;
			case 2:
				if(b % 7 == 1)
				  answer = "MON";
				else if(b % 7 == 2)
				  answer = "TUE";
				else if(b % 7 == 3)
				  answer = "WED";
				else if(b % 7 == 4)
				  answer = "THU";
				else if(b % 7 == 5)
				  answer = "FRI";
				else if(b % 7 == 6)
				  answer = "SAT";
				else
				  answer = "SUN";
				break;
			case 3:
				if(b % 7 == 1)
				  answer = "TUE";
				else if(b % 7 == 2)
				  answer = "WED";
				else if(b % 7 == 3)
				  answer = "THU";
				else if(b % 7 == 4)
				  answer = "FRI";
				else if(b % 7 == 5)
				  answer = "SAT";
				else if(b % 7 == 6)
				  answer = "SUN";
				else
				  answer = "MON";
				break;
			case 4:
				if(b % 7 == 1)
				  answer = "THU";
				else if(b % 7 == 2)
				  answer = "FRI";
				else if(b % 7 == 3)
				  answer = "SAT";
				else if(b % 7 == 4)
				  answer = "SUN";
				else if(b % 7 == 5)
				  answer = "MON";
				else if(b % 7 == 6)
				  answer = "TUE";
				else
				  answer = "WED";
				break;  
			case 5:
				  if(b % 7 == 1)
				  answer = "SUN";
				else if(b % 7 == 2)
				  answer = "MON";
				else if(b % 7 == 3)
				  answer = "TUE";
				else if(b % 7 == 4)
				  answer = "WED";
				else if(b % 7 == 5)
				  answer = "THU";
				else if(b % 7 == 6)
				  answer = "FRI";
				else
				  answer = "SAT";
				break;
			case 6:
				  if(b % 7 == 1)
				  answer = "WED";
				else if(b % 7 == 2)
				  answer = "THU";
				else if(b % 7 == 3)
				  answer = "FRI";
				else if(b % 7 == 4)
				  answer = "SAT";
				else if(b % 7 == 5)
				  answer = "SUN";
				else if(b % 7 == 6)
				  answer = "MON";
				else
				  answer = "TUE";
				break;
			case 7:
				  if(b % 7 == 1)
				  answer = "FRI";
				else if(b % 7 == 2)
				  answer = "SAT";
				else if(b % 7 == 3)
				  answer = "SUN";
				else if(b % 7 == 4)
				  answer = "MON";
				else if(b % 7 == 5)
				  answer = "TUE";
				else if(b % 7 == 6)
				  answer = "WED";
				else
				  answer = "THU";
				break;
			case 8:
				  if(b % 7 == 1)
				  answer = "MON";
				else if(b % 7 == 2)
				  answer = "TUE";
				else if(b % 7 == 3)
				  answer = "WED";
				else if(b % 7 == 4)
				  answer = "THU";
				else if(b % 7 == 5)
				  answer = "FRI";
				else if(b % 7 == 6)
				  answer = "SAT";
				else
				  answer = "SUN";
				break;
			case 9:
				  if(b % 7 == 1)
				  answer = "THU";
				else if(b % 7 == 2)
				  answer = "FRI";
				else if(b % 7 == 3)
				  answer = "SAT";
				else if(b % 7 == 4)
				  answer = "SUN";
				else if(b % 7 == 5)
				  answer = "MON";
				else if(b % 7 == 6)
				  answer = "TUE";
				else
				  answer = "WED";
				break;
			case 10:
				  if(b % 7 == 1)
				  answer = "SAT";
				else if(b % 7 == 2)
				  answer = "SUN";
				else if(b % 7 == 3)
				  answer = "MON";
				else if(b % 7 == 4)
				  answer = "TUE";
				else if(b % 7 == 5)
				  answer = "WED";
				else if(b % 7 == 6)
				  answer = "THU";
				else
				  answer = "FRI";
				break;
			case 11:
				  if(b % 7 == 1)
				  answer = "TUE";
				else if(b % 7 == 2)
				  answer = "WED";
				else if(b % 7 == 3)
				  answer = "THU";
				else if(b % 7 == 4)
				  answer = "FRI";
				else if(b % 7 == 5)
				  answer = "SAT";
				else if(b % 7 == 6)
				  answer = "SUN";
				else
				  answer = "MON";
				break;
			case 12:
				  if(b % 7 == 1)
				  answer = "THU";
				else if(b % 7 == 2)
				  answer = "FRI";
				else if(b % 7 == 3)
				  answer = "SAT";
				else if(b % 7 == 4)
				  answer = "SUN";
				else if(b % 7 == 5)
				  answer = "MON";
				else if(b % 7 == 6)
				  answer = "TUE";
				else
				  answer = "WED";
				break;
		}
		return answer;
	}
}