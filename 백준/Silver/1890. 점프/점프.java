import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st;
    	int n = Integer.parseInt(br.readLine());
    	
    	int[][] arr = new int[n+1][n+1];
    	long[][] dp = new long[n+1][n+1];
    	
    	for(int i = 1; i <= n; i++) {
    		st = new StringTokenizer(br.readLine());
    		for(int j = 1; j <= n; j++) {
    			arr[i][j] = Integer.parseInt(st.nextToken());
    		}
    	}
    	dp[1][1] = 1;
    	for(int i = 1; i <= n; i++) {
    		for(int j = 1; j <= n; j++) {
    			if(i == n && j == n) continue;
    			int num= arr[i][j];
    			if(i+num <= n) dp[i+num][j] +=dp[i][j];
    			if(j+num <= n) dp[i][j+num] +=dp[i][j];
    		}
    	}
    	System.out.println(dp[n][n]);
    	
    }
    
}
