import java.io.*;
import java.util.*;
public class Main {
	static int n, a, b, result = -1;
	static int[][] map;
	static boolean[] visited;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		map = new int[n+1][n+1];
		visited = new boolean[n+1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		a = Integer.parseInt(st.nextToken()); 
		b = Integer.parseInt(st.nextToken()); 
		
		int m = Integer.parseInt(br.readLine());
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken()); 
			int y = Integer.parseInt(st.nextToken()); 
			map[x][y] = map[y][x] = 1;
		}
		dfs(a, 0);
		System.out.println(result);
		

	}
	public static void dfs(int x, int depth) {
		visited[x] = true;
		if(x == b) {
			result = depth;
			return;
		}
		for(int i = 1; i <= n; i++) {
			if(map[x][i] == 1 && !visited[i]) dfs(i, depth+1);
		}
	}

}
