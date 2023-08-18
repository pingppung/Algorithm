import java.io.*;
import java.util.*;
public class Main {
	static boolean[][] visited;
	static int n, m;
	static int[][] map, result;
	static int[] dx = {0,0,-1,1}, dy = {-1,1,0,0};
	static class Point {
		int x, y;
		public Point(int x, int y) {
			this.x =x;
			this.y = y;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		map = new int[n][m];
		result = new int[n][m];
		visited = new boolean[n][m];
		
		int x = 0, y = 0;
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 0) visited[i][j] = true;
				if(map[i][j] == 2) {
					x = i; y = j;
				}
			}
		}
		bfs(x, y);
		result[x][y] = 0;
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				if(!visited[i][j]) sb.append(-1+" ");
				else sb.append(result[i][j]+" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
	public static void bfs(int x, int y) {
		Queue<Point> q = new LinkedList<>();
		q.offer(new Point(x, y));
		visited[x][y] = true;
		while(!q.isEmpty()) {
			Point p = q.poll();
			for(int i = 0; i< 4; i++) {
				int xx = p.x + dx[i];
				int yy = p.y + dy[i];
				if(xx < 0 || yy<0 || xx>=n || yy>=m) continue;
			
				if(!visited[xx][yy] && map[xx][yy] == 1) {
					
					result[xx][yy] = result[p.x][p.y]+1;
					visited[xx][yy] = true;
					q.offer(new Point(xx, yy));
				}
			}
		}
		
		
	}
	
}


