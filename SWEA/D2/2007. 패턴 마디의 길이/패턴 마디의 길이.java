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
			String s = br.readLine();
			String result = "";
			for (int i = 1; i < 15; i++) {
				if (s.charAt(0) == s.charAt(i)) {
					if (s.substring(0, i).equals(s.substring(i, i + i))) {
						result = s.substring(0, i);
						break;
					}
				}
			}
			System.out.printf("#%d %d\n", idx++, result.length());
		}
	}

}