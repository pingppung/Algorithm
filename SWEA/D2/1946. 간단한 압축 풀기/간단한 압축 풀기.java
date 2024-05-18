import java.io.*;
import java.util.*;
public class Solution {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		int idx = 1;
		int[] days = {31,28,31,30,31,30,31,31,30,31,30,31};
		while(T-- > 0) {
			int N = Integer.parseInt(br.readLine());
			String s = "";
			for(int i = 0; i < N; i++) {
				String[] alph = br.readLine().split(" ");
				int count = Integer.parseInt(alph[1]);
				s += String.join("", Collections.nCopies(count, String.valueOf(alph[0])));
			}
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < s.length(); i += 10) {
				sb.append(s.substring(i, Math.min(s.length(), i + 10))).append("\n");
	        }
			System.out.printf("#%d\n%s", idx++, sb.toString());
		}
	}

}