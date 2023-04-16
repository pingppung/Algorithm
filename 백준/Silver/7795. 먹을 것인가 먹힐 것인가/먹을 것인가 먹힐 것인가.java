import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st;
    	int t = Integer.parseInt(br.readLine());
    	while(t-- > 0) {
    		st = new StringTokenizer(br.readLine());
    		int n = Integer.parseInt(st.nextToken());
    		int m = Integer.parseInt(st.nextToken());
    		int[] a = new int[n];
    		int[] b = new int[m];
    		st = new StringTokenizer(br.readLine());
    		for(int i = 0; i < n; i++) {
    			a[i] = Integer.parseInt(st.nextToken());
    		}
    		st = new StringTokenizer(br.readLine());
    		for(int i = 0; i < m; i++) {
    			b[i] = Integer.parseInt(st.nextToken());
    		}
    		Arrays.sort(a);
    		Arrays.sort(b);
    		int count = 0;
    		for(int j = 0; j < n; j++) {
    			for(int k = 0; k < m; k++) {
    				if(a[j] <= b[k]) break;
    				else count++;
    			}
    		}
    		System.out.println(count);
    	}
    	
    }
}
