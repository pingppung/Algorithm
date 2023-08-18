import java.io.*;
import java.util.*;
public class Main {
	static int n, m;
	static int[][] map;
	static boolean[][] visited;
	static int[] dx = {-1,1,0,0,1,-1,1,-1}, dy = {0,0,-1,1,1,-1,-1,1};
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
		
		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		
		map = new int[m][n];
		visited = new boolean[m][n];

		
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int count = 0;
		for(int i = 0; i < m; i++) {
			for(int j = 0; j < n; j++) {
				if(map[i][j] == 1 && !visited[i][j]) {
					count++;
					bfs(i, j);
				}
			}
		}
		System.out.println(count);
		
	}
	public static void bfs(int x, int y) {
		Queue<Point> q = new LinkedList<>();
		q.offer(new Point(x, y));
		visited[x][y] = true;
		
		while(!q.isEmpty()) {
			Point p = q.poll();
			for(int i = 0; i < 8; i++) {
				int xx = p.x + dx[i];
				int yy = p.y + dy[i];
				if(xx < 0 || yy<0 || xx>=m || yy>=n) continue;
				if(map[xx][yy] == 1 && !visited[xx][yy]) {
					visited[xx][yy] = true;
					q.offer(new Point(xx, yy));
				}
			}
		}
		
	}
	
}


