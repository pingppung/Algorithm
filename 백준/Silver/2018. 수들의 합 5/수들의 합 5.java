import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  
    	int n = Integer.parseInt(br.readLine());
    
    	int cnt = 0;
    	int start = 0;
    	int end = 0;
    	int sum = 0;
    	while(start <= n) {
    		while(++end <= n) {
    			sum += end;
    			if(sum >= n) {
    				if(sum == n) cnt++;
    				break;
    			}
    		}
    		while(++start <= n) {
    			sum -= start;
    			if(sum <= n) {
    				if(sum == n) cnt++;
    				break;
    			}
    		}
    	}
    	System.out.println(cnt);
	
    }
}
