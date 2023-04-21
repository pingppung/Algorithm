import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st;
    	int t = Integer.parseInt(br.readLine());
    	long[] dp = new long[1000001];
    	dp[1] = 1; dp[2] = 2; dp[3] = 4;
    	for(int i = 4; i < 1000001; i++) {
    		dp[i] = (dp[i-1]+dp[i-2]+dp[i-3])%1000000009;
    	}
    	while(t-- > 0) {
    		int n = Integer.parseInt(br.readLine());
    		System.out.println(dp[n]);
    	}
    	
    			
    }
}
