import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st;
    	int n = Integer.parseInt(br.readLine());
    	int[] t = new int[n];
    	int[] p = new int[n];
    	for(int i = 0; i < n; i++) {
    		st = new StringTokenizer(br.readLine());
    		t[i] = Integer.parseInt(st.nextToken());
    		p[i] = Integer.parseInt(st.nextToken());
    	}
    	long[] dp = new long[1001];
    
    	for(int i = 0; i < n; i++) {
	    	if(i+t[i] <= n) {
	    		dp[i+t[i]] = Math.max(dp[i+t[i]], dp[i]+p[i]);
	    	}
	    	dp[i+1] = Math.max(dp[i+1], dp[i]);
    	}

    	
    	System.out.println(dp[n]);
    }
    
}  
