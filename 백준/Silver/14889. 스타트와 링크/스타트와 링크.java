import java.io.*;
import java.util.*;
public class Main {
	static StringBuilder sb = new StringBuilder();
	static int n;
	static int min = Integer.MAX_VALUE;
	static int[][] arr;
	static boolean[] visited;
    public static void main(String[] args) throws IOException{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st;
        n = Integer.parseInt(br.readLine());

    	arr = new int[n+1][n+1];
    	visited = new boolean[n+1];
    	for(int i = 1; i <= n; i++) {

        	st = new StringTokenizer(br.readLine());
    		for(int j = 1; j <= n; j++) {
    			arr[i][j] = Integer.parseInt(st.nextToken());
    		}
    	}
    	
    	
    	dfs(1, 0);
    	System.out.println(min);
    	
    } 
    public static void dfs(int start, int depth) {
    	if(depth == n/2) {
    		int startT = 0;
    		int linkT = 0;
    		for(int i = 1; i < n; i++) {
    			for(int j = i+1; j <= n; j++) {
    				if(visited[i] && visited[j]) {
    					startT += (arr[i][j] + arr[j][i]);
    				} else if(!visited[i] && !visited[j]){
    					linkT += (arr[i][j] + arr[j][i]);
    				}
    			}
    		}
    		int diff = Math.abs(startT-linkT);
    		min = Math.min(min, diff);
    		return;
    	}
    	for(int i = start; i <= n; i++) {
    		if(!visited[i]) {
    			visited[i] = true;
    			dfs(i+1, depth+1);
    			visited[i] = false;
    		}
    	}
    }
}
