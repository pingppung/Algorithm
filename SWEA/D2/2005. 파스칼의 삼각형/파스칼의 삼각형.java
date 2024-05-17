import java.io.*;
import java.util.*;
public class Solution {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		int[][] dp = new int[11][11];
		dp[1][1] = 1;
		for(int i =  2; i < 11; i++) {
			for(int j = 1; j <= i; j++) {
				dp[i][j] = dp[i-1][j-1] + dp[i-1][j];
			}
		}
		int idx = 1;
		while(T-- > 0) {
			int N = Integer.parseInt(br.readLine());
			System.out.println("#" + idx++ );
			for(int i =  1; i <= N; i++) {
				for(int j = 1; j <= i; j++) {
					System.out.print(dp[i][j] + " ");
				}
				System.out.println();
			}
		}
	}

}