import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	int n = Integer.parseInt(br.readLine());
    	int[][] map = new int[n][n];
    	for(int i = 0; i < n; i++) {
    		StringTokenizer st = new StringTokenizer(br.readLine());
    		for(int j = 0; j < n; j++) {
    			map[i][j] = Integer.parseInt(st.nextToken());
    		}
    	}
    	int[][][] dp = new int[n][n][3]; //가로 세로 대각선
    	dp[0][1][0] = 1;
    	
    	for(int i = 0; i < n; i++) {
    		for(int j = 2; j < n; j++) {
    			if(map[i][j] != 0) continue;
    		    dp[i][j][0] = dp[i][j-1][0] + dp[i][j-1][2];
                
    			if(i == 0) continue;
    			dp[i][j][1] = dp[i-1][j][1] + dp[i-1][j][2];
    			if(map[i-1][j] == 0 && map[i][j-1] == 0) { 
                	dp[i][j][2] = dp[i-1][j-1][0] + dp[i-1][j-1][1] + dp[i-1][j-1][2];
                }
    		}
    	}
    	System.out.println(dp[n-1][n-1][0] + dp[n-1][n-1][1] + dp[n-1][n-1][2]);
    }
}  