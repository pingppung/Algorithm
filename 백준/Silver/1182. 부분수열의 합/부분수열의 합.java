import java.io.*;
import java.util.*;
public class Main {
	static int n, s;
	static int count = 0;
	static int[] arr;
    public static void main(String[] args) throws IOException{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	
    	n = Integer.parseInt(st.nextToken());
    	s = Integer.parseInt(st.nextToken());
    	arr = new int[n];
        
    	st = new StringTokenizer(br.readLine());
    	for(int i = 0; i < n; i++) {
    		arr[i] = Integer.parseInt(st.nextToken());
    	}
    	
    	dfs(0, 0);
    	if(s == 0) count--;
    	System.out.println(count);
    	
    }
    public static void dfs(int sum, int depth) {
    	if(depth == n) {
    		if(sum == s) count++;
    		return;
    	}
    	dfs(sum, depth+1);
    	dfs(sum+arr[depth], depth+1);
    }
}
