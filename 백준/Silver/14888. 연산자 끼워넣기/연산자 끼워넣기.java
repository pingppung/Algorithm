import java.io.*;
import java.util.*;
public class Main {
	static StringBuilder sb = new StringBuilder();
	static int n;
	static int max = Integer.MIN_VALUE;
	static int min = Integer.MAX_VALUE;
	static int[] arr;
	static int[] op;
    public static void main(String[] args) throws IOException{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st;
    	n = Integer.parseInt(br.readLine());

    	arr = new int[n];
    	
    	st = new StringTokenizer(br.readLine());
    	for(int i = 0; i < n; i++) {
    		arr[i] = Integer.parseInt(st.nextToken());
    	}
    	
    	op = new int[4];
    	st = new StringTokenizer(br.readLine());
    	for(int i = 0; i < 4; i++) {
    		op[i] = Integer.parseInt(st.nextToken());
    	}
    	
    	dfs(arr[0], 1);
    	System.out.println(max+"\n"+min);
    	
    } 
    public static void dfs(int num, int depth) {
    	if(depth == n) {
    		max = Math.max(max, num);
    		min = Math.min(min, num);
    		return;
    	}
    	for(int i = 0; i < 4; i++) {
    		if(op[i] > 0) {
    			op[i]--;
    			switch(i) {
	    			case 0 : 
	    				dfs(num+arr[depth], depth+1);
	    				break;
	    			case 1 : 
	    				dfs(num-arr[depth], depth+1);
	    				break;
	    			case 2 : 
	    				dfs(num*arr[depth], depth+1);
	    				break;
	    			case 3 : 
	    				dfs(num/arr[depth], depth+1);
	    				break;
    			}
    			op[i]++;
    		}
    	}
    }
}
