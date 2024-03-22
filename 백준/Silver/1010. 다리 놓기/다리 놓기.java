import java.io.*;
import java.util.*;
public class Main {
	static int[][] dp = new int[31][31];
    public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	int t = Integer.parseInt(br.readLine());
    	while(t-- > 0) {
    		StringTokenizer st = new StringTokenizer(br.readLine());
    		int n = Integer.parseInt(st.nextToken());
    		int m = Integer.parseInt(st.nextToken());
    		System.out.println(bridge(n, m));
    	}
    }
    private static int bridge(int n, int m) {
    	if(n == 0 || n == m) return dp[n][m] = 1;
    	if(dp[n][m] > 1) return dp[n][m];
    	return dp[n][m] = bridge(n-1, m-1) + bridge(n, m-1);
    	
    }
    
}  