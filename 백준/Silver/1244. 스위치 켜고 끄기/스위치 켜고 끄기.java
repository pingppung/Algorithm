import java.io.*;
import java.util.*;
public class Main {
	static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st;
    	int n = Integer.parseInt(br.readLine());
    	int[] switches = new int[n+1];
    	st = new StringTokenizer(br.readLine());
    	for(int i = 1; i <= n; i++) {
    		switches[i] = Integer.parseInt(st.nextToken());
    	}
    	
    	int m = Integer.parseInt(br.readLine());
    	
    	for(int i = 1; i <= m; i++) {
    		st = new StringTokenizer(br.readLine());
    		int gender = Integer.parseInt(st.nextToken());
    		int num = Integer.parseInt(st.nextToken());
    		
    		if(gender == 1) {
    			for(int j = 1; j <= n; j++) {
    				if(j % num == 0) 
    					switches[j] = switches[j] == 1? 0 : 1; 
    			} 
    		} else {
    			int left = num - 1;
    			int right = num + 1;
    			while(left >= 1 && right <= n) {
    				if(switches[left] != switches[right]) break;
    				left--;
    				right++;
    			}
    			left++; right--;
    			for(int j = left; j <= right; j++) {
    				switches[j] = switches[j] == 1? 0 : 1;
    			}
    		}
    	}
    	for(int i=1; i<= n; i++) {
			sb.append(switches[i] + " ");
			if(i % 20 == 0)
				sb.append("\n");
		}
    	System.out.println(sb);
	
    }
}
