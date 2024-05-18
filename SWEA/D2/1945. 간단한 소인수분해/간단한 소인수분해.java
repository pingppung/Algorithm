import java.io.*;
import java.util.*;
import java.util.stream.Collectors;
public class Solution {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		int idx = 1;
		int[] nums = {2,3,5,7,11};
		while(T-- > 0) {
			int N = Integer.parseInt(br.readLine());
			int[] count = new int[5];
			for(int i = 0; i < nums.length; i++) {
				while(N % nums[i] == 0) {
					count[i]++;
					N /= nums[i];
				}
			}
			String result = Arrays.stream(count).mapToObj(String::valueOf).collect(Collectors.joining(" "));
			System.out.printf("#%d %s\n", idx++, result);
		}
	}

}