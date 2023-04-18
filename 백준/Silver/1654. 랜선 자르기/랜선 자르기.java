import java.io.*;
import java.util.*;
public class Main {
	static int[] arr;
    public static void main(String[] args) throws IOException{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	
    	int k = Integer.parseInt(st.nextToken());
    	int n = Integer.parseInt(st.nextToken());
    	
    	arr = new int[k];
        
    	long min = 0;
    	long max = 0;
    	
    	for(int i = 0; i < k; i++) {
    		arr[i] = Integer.parseInt(br.readLine());
    		max = Math.max(max, arr[i]);
    	}
    	max++;
    	
    	while(min < max) {
    		long mid = (min + max)/2;
    		long count = 0;
    		for(int i = 0;  i < k; i++) {
    			count += (arr[i]/mid);
    		}
    		if(count < n) max = mid;
    		else min = mid +1;
    	}
    	
    	System.out.println(min -1);
    	
    }
}
