import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	
    	int n = Integer.parseInt(st.nextToken());
    	int k = Integer.parseInt(st.nextToken());
    	char[] arr = br.readLine().toCharArray();
    	boolean[] chk = new boolean[n];
    	
    	int count = 0;
    	for(int i = 0; i < n; i++) {
    		if(arr[i] == 'P') {
    			int start = Math.max(i-k, 0);
    			int end = Math.min(i+k, n-1);
    			for(int j = start; j <= end; j++) {
    				if(arr[j] == 'H' && !chk[j]) {
    					chk[j] = true;
    					count++;
    					break;
    				}
    			}
    		}
    	}
    	System.out.println(count);
    }
}
