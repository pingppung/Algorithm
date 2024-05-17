import java.io.*;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
public class Solution {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		int idx = 1;
		while(T-- > 0) {
			int[] times = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::valueOf).toArray();
			int hour = times[0] + times[2];
			int min = times[1] + times[3];
			if(min >= 60) {
				hour += min/60;
				min %= 60;
			}
			hour %= 12;
			if(hour == 0) hour = 12;
			System.out.printf("#%d %d %d\n", idx++, hour, min);
		}
	}

}