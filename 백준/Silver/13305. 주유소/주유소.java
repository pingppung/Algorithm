import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st;
    	int n = Integer.parseInt(br.readLine());
    	
    	int[] dis = new int[n-1];
    	int[] cost = new int[n];
    	st = new StringTokenizer(br.readLine());
    	for(int i = 0; i < n-1; i++) {
    		dis[i] = Integer.parseInt(st.nextToken());
    	}
    	
    	st = new StringTokenizer(br.readLine());
    	for(int i = 0; i < n; i++) {
    		cost[i] = Integer.parseInt(st.nextToken());
    	}
    	
    	int sum = 0;
    	int min = cost[0];
    	for(int i = 0; i < n-1; i++) {
    		if(cost[i] < min) min = cost[i];
    		sum += min * dis[i];
    	}
    	System.out.println(sum);
    }
}
