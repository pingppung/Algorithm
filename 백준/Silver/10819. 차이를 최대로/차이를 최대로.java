import java.io.*;
import java.util.*;
public class Main {
	static int n;
	static int result = 0;
	static int[] arr, selected;
	static boolean[] visited;
	static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st;
        n = Integer.parseInt(br.readLine());
    	
    	arr = new int[n];
    	selected = new int[n];
    	visited = new boolean[n];
    	
    	st = new StringTokenizer(br.readLine());
    	for(int i = 0; i < n; i++) {
    		arr[i] = Integer.parseInt(st.nextToken());
    	}
    	dfs(0);
    	System.out.println(result);
    			
    }
    public static void dfs(int depth) {
    	if(depth == n) {
    		int sum = 0;
    		for(int i = 0; i < n-1; i++) {
    			sum += Math.abs(selected[i] - selected[i+1]);
    		}
    		result = Math.max(sum, result);
    	}
    	for(int i = 0; i < n; i++) {
    		if(!visited[i]) {
    			visited[i] = true;
    			selected[depth] = arr[i];
    			dfs(depth+1);
    			visited[i] = false;
    		}
    	}
    }
}
