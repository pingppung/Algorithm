import java.io.*;
import java.util.*;
public class Main {
	static int[] day = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int ty = Integer.parseInt(st.nextToken());
		int tm = Integer.parseInt(st.nextToken());
		int td = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int dy = Integer.parseInt(st.nextToken());
		int dm = Integer.parseInt(st.nextToken());
		int dd = Integer.parseInt(st.nextToken());
		
		
		//1000년 이상 차이
		if((dy - ty > 1000) || (dy - ty == 1000 && dm > tm)
				||(dy - ty == 1000 && dm == tm && dd >= td))
			System.out.println("gg");
		else {
			long day1 = diffDay(ty, tm, td);
			long day2 = diffDay(dy, dm, dd);
			System.out.println("D-"+ (day2 - day1));
		}
	}
	public static long diffDay(int y, int m , int d) {
		int date = 0;
		//1년 ~ d-day 년도 전
		for(int i = 1; i < y; i++){
			date += 365 + chkYear(i);
        }
        for(int i = 1; i < m; i++){
            if(i == 2) date += chkYear(y);
            date += day[i];
        }
		date += d;
		return date;
	}
	static int chkYear(int y){
        if((y % 4 == 0 && y % 100 != 0) || y % 400 == 0) return 1;
        else return 0;
    }
}
