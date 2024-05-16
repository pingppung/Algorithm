import java.io.*;
import java.util.*;
public class Solution {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		int idx = 1;
		int[] days = {31, 28, 31, 30,31, 30, 31, 31, 30, 31, 30, 31};
		while(T-- > 0) {
			String date = br.readLine();
			int year = Integer.parseInt(date.substring(0, 4));
			int month = Integer.parseInt(date.substring(4, 6));
			int day = Integer.parseInt(date.substring(6, 8));
			if((month < 1 || month > 12) || (days[month-1] < 0 || days[month-1] < day)) date = "-1";
			if(date != "-1") date = date.replaceAll("(\\d{4})(\\d{2})(\\d{2})", "$1/$2/$3");
			System.out.println("#"+ idx++ + " "+ date);
		}
	}

}
