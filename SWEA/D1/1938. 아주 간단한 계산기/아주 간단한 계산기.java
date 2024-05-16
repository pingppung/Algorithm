import java.io.*;
import java.util.*;
public class Solution {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] nums = br.readLine().split(" ");
		int a = Integer.parseInt(nums[0]);
		int b = Integer.parseInt(nums[1]);
		System.out.printf("%d\n%d\n%d\n%d\n", a+b, a-b, a*b, a/b);
		
	}

}
