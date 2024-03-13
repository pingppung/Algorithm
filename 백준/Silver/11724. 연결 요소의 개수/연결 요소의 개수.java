import java.io.*;
import java.util.*;
public class Main {
	static int n;
	static int[][] graph;
	static boolean[] visited;
    public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	n = Integer.parseInt(st.nextToken());
    	int m = Integer.parseInt(st.nextToken());
    	graph = new int[n+1][n+1];
    	visited = new boolean[n+1];
    	for(int i= 0; i < m; i++) {
    		st = new StringTokenizer(br.readLine());
    		int u = Integer.parseInt(st.nextToken());
    		int v = Integer.parseInt(st.nextToken());
    		graph[u][v] = graph[v][u] = 1;
    	}
    	int count = 0;
    	for(int i = 1; i <= n; i++) {
    		if(!visited[i]) {
    			count++;
    			dfs(i);
    		}
    	}
    	System.out.println(count);
    }
    private static void dfs(int num) {
    	for(int i = 1; i <= n; i++) {
    		if(!visited[i] && graph[num][i] == 1) {
    			visited[i] = true;
    			dfs(i);
    		}
    		
    	}
    }
} 