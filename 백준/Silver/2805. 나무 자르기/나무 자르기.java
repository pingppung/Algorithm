import java.io.*;
import java.util.*;
public class Main {
	static int n, m;
	static int[] arr;
    public static void main(String[] args) throws IOException{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	
    	n = Integer.parseInt(st.nextToken());
    	m = Integer.parseInt(st.nextToken());
    	arr = new int[n];
        
    	int minTree = 0;
    	int maxTree = 0;
    	
    	st = new StringTokenizer(br.readLine());
    	for(int i = 0; i < n; i++) {
    		arr[i] = Integer.parseInt(st.nextToken());
    		maxTree = Math.max(maxTree, arr[i]);
    	}
    	
    	while(minTree < maxTree) {
    		int mid = (minTree + maxTree)/2;
    		long sum = 0;
    		for(int i = 0; i < n; i++) {
    			if(arr[i] - mid > 0)
    				sum+= (arr[i] - mid);
    		}
    		if(sum < m) maxTree = mid;
    		else minTree = mid + 1;
    	}
    	
    	System.out.println(maxTree -1);
    	
    }
}
