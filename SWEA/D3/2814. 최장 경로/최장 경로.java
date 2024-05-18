import java.io.*;
import java.util.*;
public class Solution {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		int idx = 1;
		while(T-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			boolean[] visited = new boolean[N+1];
			int[][] graph = new int[N+1][N+1];
			
			for(int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				graph[x][y] = graph[y][x] = 1;
			}
			int max = 1;
			for(int i = 1; i <= N; i++) {
				max = Math.max(max, dfs(graph, visited, i));
			}
			System.out.printf("#%d %d\n", idx++, max);
		}
	}

	private static int dfs(int[][] graph, boolean[] visited, int start) {
		visited[start] = true;
		int maxDepth = 0;
		for(int i = 1; i < graph[0].length; i++) {
			if(!visited[i] && graph[start][i] == 1) {
				int depth = dfs(graph, visited, i);
				maxDepth = Math.max(maxDepth, depth);
			}
		}
		visited[start] = false;
		return maxDepth +1;
	}

}