import java.io.*;
import java.util.*;
public class Main {
	static boolean[][] visited;
	static int n, r2, c2;
	static int[][] map;
	// (r-2, c-1), (r-2, c+1), (r, c-2), (r, c+2), (r+2, c-1), (r+2, c+1)
	static int[] dx = {-2, -2, 0, 0, 2, 2}, dy = {-1, 1, -2, 2, -1, 1};
	static class Point {
		int x, y, cnt;
		public Point(int x, int y, int cnt) {
			this.x =x;
			this.y = y;
			this.cnt = cnt;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		StringBuilder sb = new StringBuilder();
		n = Integer.parseInt(br.readLine());
		
		map = new int[n][n];
		visited = new boolean[n][n];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int x = 0, y = 0;
		
		int r1 = Integer.parseInt(st.nextToken());
		int c1 = Integer.parseInt(st.nextToken());
		r2 = Integer.parseInt(st.nextToken());
		c2 = Integer.parseInt(st.nextToken());

		bfs(r1, c1);
		
		
	}
	public static void bfs(int x, int y) {
		Queue<Point> q = new LinkedList<>();
		q.offer(new Point(x, y, 0));
		visited[x][y] = true;
		while(!q.isEmpty()) {
			Point p = q.poll();
			if(p.x == r2 && p.y == c2) {
				System.out.println(p.cnt);
				return;
			}
			for(int i = 0; i < 6; i++) {
				int xx = p.x + dx[i];
				int yy = p.y + dy[i];
				if(xx < 0 || yy<0 || xx>=n || yy>=n) continue;
				if(!visited[xx][yy]) {
					visited[xx][yy] = true;
					q.offer(new Point(xx, yy, p.cnt+1));
				}
			}
		}
		System.out.println(-1);
		
	}
	
}


