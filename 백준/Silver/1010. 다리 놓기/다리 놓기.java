import java.io.*;
import java.util.*;
public class Main {
	static int[][] dp = new int[31][31];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(br.readLine());
		while(t-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			System.out.println(combination(m, n));	
		}
	}
	public static int combination(int m, int n) { //재귀
		if(dp[m][n] > 0) return dp[m][n];
		if(n == 0 || n == m) return dp[m][n] = 1;
		else return dp[m][n] = combination(m-1, n-1) + combination(m-1,n);
	}
}
