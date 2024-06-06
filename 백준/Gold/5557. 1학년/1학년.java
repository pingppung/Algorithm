import java.io.*;
import java.util.*;
public class Main {
	static int n;
	static int[] nums;
    public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	n = Integer.parseInt(br.readLine());
    	nums = new int[n-1];
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	for(int i = 0; i < n-1; i++) {
    		nums[i] = Integer.parseInt(st.nextToken());
    	}
    	int result = Integer.parseInt(st.nextToken());
    	System.out.println(find(result));
    }
    private static long find(int result) {
    	long[][] dp = new long[n][21];
    	
    	dp[0][nums[0]] = 1;
    	for(int i = 1; i < n - 1; i++) {
    		for (int sum = 0; sum <= 20; sum++) {
                if (dp[i - 1][sum] > 0) {
                    if (sum + nums[i] <= 20) {
                        dp[i][sum + nums[i]] += dp[i - 1][sum];
                    }
                    if (sum - nums[i] >= 0) {
                        dp[i][sum - nums[i]] += dp[i - 1][sum];
                    }
                }
            }
    	}
    	return dp[n - 2][result];
    }
}

