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
			int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::valueOf).toArray();
			Arrays.sort(arr);
			String result = Arrays.stream(arr).mapToObj(String::valueOf).collect(Collectors.joining(" "));
			System.out.printf("#%d %s\n", idx++, result );
		}
	}

}