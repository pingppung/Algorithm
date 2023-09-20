import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	int t = Integer.parseInt(br.readLine());

    	long[] dp = new long[101];

    	dp[1] = dp[2] = dp[3] = 1;
    	for(int i = 0; i < t; i++) {
    		int n = Integer.parseInt(br.readLine());
	    	for(int j = 4; j <=n; j++) {
	    		dp[j] = dp[j-3] + dp[j-2];
	    	}
	    	System.out.println(dp[n]);
    	}
    }
    
}  
