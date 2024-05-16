import java.io.*;
import java.util.*;

public class Solution{

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] nums = Arrays.stream(br.readLine().split("")).mapToInt(Integer::valueOf).toArray();
		System.out.println(Arrays.stream(nums).sum());
	}

}
