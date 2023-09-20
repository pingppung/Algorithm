import java.io.*;
import java.util.*;
public class Main {
	static int n, m, count = 0;
	static int[][] graph;
	static boolean[] visited;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringBuilder sb = new StringBuilder();
		
		n = Integer.parseInt(br.readLine());
		m = Integer.parseInt(br.readLine());
		graph = new int[n+1][n+1];
		visited = new boolean[n+1];
		for(int i = 0; i < m; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			graph[a][b] = graph[b][a] = 1;
		}
		bfs(1);
		System.out.println(count);
	}
	public static void bfs(int start) {
		Queue<Integer> q = new LinkedList<>();
		q.offer(start);
		visited[start] = true;
		while(!q.isEmpty()) {
			int now = q.poll();
			for(int i = 1; i <= n; i++) {
				if(graph[now][i] == 1 && !visited[i]) {
					q.offer(i);
					visited[i] = true;
					count++;
				}
			}
		}
	}
}
