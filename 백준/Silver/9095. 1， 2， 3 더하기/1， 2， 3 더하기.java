import java.io.*;
import java.util.*;
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		int[] dp = new int[11];
		dp[0] = dp[1] = 1;
		dp[2] = 2;
		for(int i = 3; i < 11; i++) {
			dp[i] = dp[i-3] + dp[i-2] + dp[i-1];
		}
		while(t-- > 0) {
			int n = Integer.parseInt(br.readLine());
			System.out.println(dp[n]);
		}
	}
}