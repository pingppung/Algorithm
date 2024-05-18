import java.io.*;
import java.util.*;
public class Solution {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		int idx = 1;
		int[] days = {31,28,31,30,31,30,31,31,30,31,30,31};
		while(T-- > 0) {
			int[] dates = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::valueOf).toArray();
			int diff = 0;
			if(dates[0] == dates[2]) {
				diff = dates[3] - dates[1] + 1;
			}
			else {
				diff = (days[dates[0]-1] - dates[1]) + dates[3] + 1;
				for(int i= dates[0]+1; i < dates[2]; i++) {
					diff += days[i-1];
				}
			}
			System.out.printf("#%d %d\n", idx++, diff);
		}
	}

}