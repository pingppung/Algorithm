import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st;
    	int L = Integer.parseInt(br.readLine());
    	st = new StringTokenizer(br.readLine());
    	int[] s = new int[L];
    	for(int i = 0; i < L; i++) {
    		s[i] = Integer.parseInt(st.nextToken());
    	}
    	Arrays.sort(s);
    	int n = Integer.parseInt(br.readLine());
    	
    	int count = 0;
    	int min = 1, max = 1;
    	for(int i = 0; i < L; i++) {
    		if(s[i] == n) break;
    		if(s[i] > n) {
    			max = s[i] - 1;
    			if(i > 0) min = s[i-1] + 1;
    			break;
    		}
    	}
    	
    	for(int i = min; i <= n; i++) {
    		for(int j = n; j <= max; j++) {
        		if(i == j) continue;
        		count++;
        	} 
    	}
    	System.out.println(count);
    	
    }
}
