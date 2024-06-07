import java.io.*;
import java.util.*;
public class Main {
	static int n;
	static int[] t, p, dp;
    public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	n = Integer.parseInt(br.readLine());
    	t = new int[n+1];
    	p = new int[n+1];
    	dp = new int[n+1];
    	
    	for(int i = 0; i < n; i++) {
        	StringTokenizer st = new StringTokenizer(br.readLine());
    		t[i]= Integer.parseInt(st.nextToken());
    		p[i] = Integer.parseInt(st.nextToken());
    	}
    	int max = 0;
    	for(int i = 0; i <= n; i++) {
    		max = Math.max(dp[i], max);
    		int finish = i + t[i];
    		if(finish <= n) {
    			dp[finish] = Math.max(dp[finish], max + p[i]);
    		}
    	}
    	System.out.println(max);
    }
}

