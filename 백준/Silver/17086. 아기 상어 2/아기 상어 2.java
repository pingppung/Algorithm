import java.io.*;
import java.util.*;
public class Main {
	static int[][] map, depth;
	static boolean[][] visited;
	static int n, m;
	
	static int[] dx = {-1,1,0,0,1,-1,1,-1};
	static int[] dy = {0,0,-1,1,1,-1,-1,1};
	static class Node{
		int start, end, depth;
		public Node(int start, int end, int depth) {
			this.start = start;
			this.end = end;
			this.depth = depth;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int result = 0;
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				if(map[i][j] == 0) {
					visited = new boolean[n][m];
					int depth = bfs(i, j);
					result = Math.max(result, depth);
				}
			}
		}
		System.out.println(result);

	}
	
	public static int bfs(int x, int y) {
		Queue<Node> q = new LinkedList<>();
		q.offer(new Node(x, y, 0));
		visited[x][y] = true;
		while(!q.isEmpty()) {
			Node node = q.poll();
			for(int i = 0; i < 8; i++) {
				int xx = node.start+dx[i];
				int yy = node.end+dy[i];
				int depth = node.depth;
				
				if(xx < 0 || yy < 0 || xx >= n ||  yy >= m) continue;
				if(visited[xx][yy]) continue;
				if(map[xx][yy] == 1) return depth+1;
		
				q.offer(new Node(xx, yy, depth+1));
				visited[xx][yy] = true;
			}
		}
		return 0;
		
	}
}
