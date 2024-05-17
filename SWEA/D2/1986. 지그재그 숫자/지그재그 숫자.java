import java.io.*;
import java.util.*;
import java.util.stream.IntStream;
public class Solution {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		int idx = 1;
		while(T-- > 0) {
			int N = Integer.parseInt(br.readLine());
			
			int sum = IntStream.rangeClosed(1, N).map(i -> (i % 2 == 0) ? -i : i).sum();
			System.out.printf("#%d %d\n", idx++, sum);
		}
	}

}