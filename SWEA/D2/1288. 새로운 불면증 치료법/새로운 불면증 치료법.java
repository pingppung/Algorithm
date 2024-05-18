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
			int[] nums = new int[10];
			int count = 0;

			String NString  = "";
			while(true) {
				boolean allTrue = Arrays.stream(nums).allMatch(v -> v == 1);
				if(allTrue) break;
				
				int temp = N * (count + 1);
				NString = String.valueOf(temp);
				for (int i = 0; i < NString.length(); i++) {
				    char digitChar = NString.charAt(i);
				    int digit = Character.getNumericValue(digitChar);

				    nums[digit] = 1;
				}

				count++;
			}
			System.out.printf("#%d %s\n", idx++, NString);
		}
	}
	

}