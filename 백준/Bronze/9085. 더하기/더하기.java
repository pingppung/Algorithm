import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st;
    	int t = Integer.parseInt(br.readLine());
    
    	while(t-- > 0) {
    		int sum = 0;
    		int n = Integer.parseInt(br.readLine());
    		st = new StringTokenizer(br.readLine());
    		for(int i = 0; i < n; i++) {
    			sum += Integer.parseInt(st.nextToken());
    		}
    		System.out.println(sum);
    	}
    }
    
}
