import java.io.*;
import java.util.Arrays;
import java.util.stream.Stream;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] nums = Arrays.stream(br.readLine().split(" "))
							.mapToInt(Integer::valueOf)
							.sorted()
							.toArray();
		
		int value = nums[0];
		int count = 0;
		while(true) {
			for(int num : nums) {
				if(value % num == 0) {
					count++;
				}
			}
			if(count >= 3) break;
			value++;
			count = 0;
		}
		System.out.println(value);
	}
}