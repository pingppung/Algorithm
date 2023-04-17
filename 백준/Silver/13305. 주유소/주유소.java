import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st;
    	int n = Integer.parseInt(br.readLine());
    	
    	long[] dis = new long[n-1];
    	long[] cost = new long[n];
    	st = new StringTokenizer(br.readLine());
    	for(int i = 0; i < n-1; i++) {
    		dis[i] = Long.parseLong(st.nextToken());
    	}
    	
    	st = new StringTokenizer(br.readLine());
    	for(int i = 0; i < n; i++) {
    		cost[i] = Long.parseLong(st.nextToken());
    	}
    	
    	long sum = 0;
    	long min = cost[0];
    	for(int i = 0; i < n-1; i++) {
    		if(cost[i] < min) min = cost[i];
    		sum += min * dis[i];
    	}
    	System.out.println(sum);
    }
}
