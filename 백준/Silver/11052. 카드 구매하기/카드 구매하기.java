import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st;
    	int n = Integer.parseInt(br.readLine());
    	st = new StringTokenizer(br.readLine());
    	int[] arr = new int[n+1];
    	int[] dp = new int[n+1];
    	for(int i = 1; i <= n; i++) {
    		arr[i] = Integer.parseInt(st.nextToken());
    	}
    	
    	for(int i = 1; i <= n; i++) {
    		 for (int j = 1; j <= i; j++) {
                 dp[i] = Math.max(dp[i], dp[i - j] + arr[j]);
             }
    	}
    	System.out.println(dp[n]);
    }
    
}
