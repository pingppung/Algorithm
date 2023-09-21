import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st;
    	int n = Integer.parseInt(br.readLine());
    	int[] dp = new int[n + 1];
    	st = new StringTokenizer(br.readLine());
    	dp[1]  = Integer.parseInt(st.nextToken());
    	int max = dp[1];
    	for(int i = 2; i <= n; i++) {
    		int num = Integer.parseInt(st.nextToken());
    		dp[i] = Math.max(dp[i-1] + num, num);
    		max = Math.max(max, dp[i]);
    	}
    	System.out.println(max);
    }
    
}  
