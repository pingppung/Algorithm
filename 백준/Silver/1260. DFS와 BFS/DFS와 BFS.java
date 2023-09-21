import java.io.*;
import java.util.*;
public class Main {
	static Queue<Integer> q = new LinkedList<>();
	static boolean[] visited;
	static int[][] arr;
	static StringBuilder sb = new StringBuilder();
	static int n, m, v;
	
    public static void main(String[] args) throws IOException{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
   
    	n = Integer.parseInt(st.nextToken());
    	m = Integer.parseInt(st.nextToken());
    	v = Integer.parseInt(st.nextToken());
    	
    	arr = new int[n+1][n+1];
    	visited = new boolean[n+1];
    	
    	for(int i = 0; i < m; i++) {
        	st = new StringTokenizer(br.readLine());
    		int a= Integer.parseInt(st.nextToken());
    		int b = Integer.parseInt(st.nextToken());
    		arr[a][b] = arr[b][a] = 1;
    	}
    	dfs(v);
    	sb.append("\n");
    	visited = new boolean[n+1];
    	bfs(v);
    	
    	System.out.println(sb);
    }

	static void dfs(int v) {
		visited[v] = true;
		sb.append(v + " ");
		for(int j = 0; j <= n; j++) {
			if(arr[v][j] == 1 && visited[j] == false) {
				dfs(j);
			}
		}
	}
	static void bfs(int v) {
		q.add(v);
		visited[v] = true;
		while(!q.isEmpty()) {
			v = q.poll();
			sb.append(v + " ");
			for(int j = 1; j <= n; j++) {
				if(arr[v][j] == 1 && visited[j] == false) {
					q.add(j);
					visited[j] = true;
				}
			}
		}
	}
}  