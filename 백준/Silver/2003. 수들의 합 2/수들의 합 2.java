import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());

    	int n = Integer.parseInt(st.nextToken());
    	int m = Integer.parseInt(st.nextToken());
    	
    	int[] arr = new int[n+1];
    	st = new StringTokenizer(br.readLine());
    	for(int i = 1; i <= n; i++) {
    		arr[i] = Integer.parseInt(st.nextToken());
    	}
    	int cnt = 0;
    	int start_idx = 0;
    	int end_idx = 0;
    	int sum = 0;
    	while(start_idx <= n) {
    		while(++end_idx <= n) {
    			sum += arr[end_idx];
    			if(sum >= m) {
    				if(sum == m) cnt++;
    				break;
    			}
    			
    		}
    		while(++start_idx <= n) {
    			sum -= arr[start_idx];
    			if(sum <= m) {
    				if(sum == m) cnt++;
    				break;
    			}
    		}
    	}
    	System.out.println(cnt);
    	
    	
	
    }
}
