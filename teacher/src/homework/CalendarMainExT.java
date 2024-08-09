package homework;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

class CalendarExT {
	Calendar cal = new GregorianCalendar();
	private int year, month, week, lastDay;
	
	public CalendarExT() {
		System.out.println("선생님 버전");
		Scanner scan = new Scanner(System.in);
		
		System.out.print("년도 입력: ");
		year = scan.nextInt();
		System.out.print("월 입력: ");
		month = scan.nextInt();
		
		scan.close();
	}
	public void calc() {
		//시스템 날짜를 기준으로 생성
		Calendar cal = Calendar.getInstance();
		
		//cal.set(Calendar.YEAR, year);
		//cal.set(Calendar.MONTH, month-1);
		//cal.set(Calendar.DAY_OF_MONTH,1);
		cal.set(year,month-1,1);
		
		week = cal.get(Calendar.DAY_OF_WEEK);	//1일의 요일 구하기
		System.out.println(week);
		lastDay = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
	}
	public void display() {
		System.out.println("일\t월\t화\t수\t목\t금\t토");
		for(int i = 1; i < week; i++) {
			System.out.print("\t");
		}
		for(int i = 1; i <= lastDay; i++) {
			System.out.print(i+"\t");
			if(week % 7 == 0) {
				System.out.println();
			}
			week++;
		}
	}
}
public class CalendarMainExT {
	
	public static void main(String[] args) {
		CalendarExT calendarExT = new CalendarExT();
		calendarExT.calc();
		calendarExT.display();
	}
}
