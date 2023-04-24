import java.io.*;
import java.util.*;
public class Main {
	static int n, m, r;
	static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st;
    	int t = Integer.parseInt(br.readLine());
    	while(t-- > 0) {
    		int n = Integer.parseInt(br.readLine());
    		st = new StringTokenizer(br.readLine());
    		long[] stock = new long[n];
    		for(int i = 0; i < n; i++) {
    			stock[i] = Integer.parseInt(st.nextToken());
    		}
    		long max = 0;
    		long profit = 0;
      		for(int i = n-1; i >= 0; i--) {
      			if(stock[i] > max) max = stock[i];
      			else profit += max - stock[i];
      		}
      		sb.append(profit+"\n");
    	}
    	System.out.println(sb);
    }
}
