import java.io.*;
import java.util.*;
public class Main {
	static StringBuilder sb = new StringBuilder();
	static int[][] graph;
	static boolean[] visited;
	static int n,m,count = 0;
	public static void main(String[] args) throws IOException{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	
    	n = Integer.parseInt(st.nextToken());
    	m = Integer.parseInt(st.nextToken());
    	
        graph = new int[n+1][n+1];
        visited = new boolean[n+1];
        for(int i = 0; i < m; i++) {
        	st = new StringTokenizer(br.readLine());
        	int u = Integer.parseInt(st.nextToken());
        	int v = Integer.parseInt(st.nextToken());
        	graph[u][v] = graph[v][u] = 1;
        }
        for(int i = 1; i <= n; i++) {
        	if(!visited[i]) {
        		bfs(i);
        		count++;
        	}
    	}
    	System.out.println(count);
    }
    static void bfs(int start) {
    	Queue<Integer> q = new LinkedList<>();
    	q.add(start);
    	while(!q.isEmpty()) {
    		start = q.poll();
    		visited[start] = true;
    		for(int i = 1; i <= n; i++) {
    			if(graph[start][i] == 1 && !visited[i]) {
        			q.add(i);
        			visited[i] = true;
        		}
    		}
    	}
    
    }
}
