import java.io.*;
import java.util.*;
import java.util.stream.IntStream;
public class Solution {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		int idx = 1;
		while(T-- > 0) {
			int[] nums = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::valueOf).toArray();
			Arrays.sort(nums);
			double avg = IntStream.rangeClosed(1, nums.length-2).map(i-> nums[i]).average().getAsDouble();
			System.out.printf("#%d %d\n", idx++, Math.round(avg));
		}
	}

}