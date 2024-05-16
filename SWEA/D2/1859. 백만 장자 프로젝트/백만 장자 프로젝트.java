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
			
			int N = Integer.parseInt(br.readLine());
			int[] nums = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::valueOf).toArray();
			
			int maxIdx = -1;
			long profit = 0;
			while(true) {
				nums = Arrays.copyOfRange(nums, maxIdx + 1, nums.length);
				int max = Arrays.stream(nums).max().getAsInt();
				maxIdx = Arrays.stream(nums).boxed().collect(Collectors.toList()).indexOf(max);
				for(int i = 0; i < maxIdx; i++) {
					if(nums[i] < max) profit += (max - nums[i]);
				}

				if(maxIdx == nums.length-1) break;
			}
			System.out.printf("#%d %d\n", idx++, profit);
		}
	}

}