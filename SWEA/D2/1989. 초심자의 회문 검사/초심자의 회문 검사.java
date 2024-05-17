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
			String word = br.readLine();
			String reverse = new StringBuilder(word).reverse().toString();
			int result = 0;
			if(word.equals(reverse)) result = 1;
			System.out.printf("#%d %d\n", idx++, result);
		}
	}

}