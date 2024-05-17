import java.io.*;
import java.util.*;
import java.util.stream.Collectors;
public class Solution {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		int[] money = {50000, 10000, 5000, 1000, 500, 100, 50, 10};
		int idx = 1;
		while(T-- > 0) {
			int N = Integer.parseInt(br.readLine());
			int[] change = new int[money.length];
			for(int i = 0; i < money.length; i++) {
				int count = N / money[i];
				change[i] = count;
				N %= money[i];
			}
			System.out.println("#"+ idx++);
			String result = Arrays.stream(change).mapToObj(String::valueOf).collect(Collectors.joining(" "));
			System.out.println(result);
		}
	}

}