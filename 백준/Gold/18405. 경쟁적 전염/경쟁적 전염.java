import java.io.*;
import java.util.*;

public class Main {
	static int n, k, s;
	static int[][] map;
	static boolean[][] visited;

	static int[] dx = {0, 0, -1,1};
	static int[] dy = {1, -1, 0, 0};

	static class Point {
		int x, y, virus, time;

		public Point(int x, int y, int virus, int time) {
			this.x = x;
			this.y = y;
			this.virus = virus;
			this.time = time;
			
		}
	}
	static Queue<Point> q = new LinkedList<>();
	static ArrayList<Point> list = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		
		map = new int[n+1][n+1];
		visited = new boolean[n+1][n+1];
		for(int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 1; j <= n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] > 0) list.add(new Point(i, j, map[i][j], 0));
			}
		}
		Collections.sort(list, new Comparator<Point>() { //바이러스 순대로 오름차순
			public int compare(Point p1, Point p2) {
				return p1.virus - p2.virus;
			}
		});
		
		st = new StringTokenizer(br.readLine());
		s = Integer.parseInt(st.nextToken());
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
		

		for(Point p : list) {
			q.offer(p);
		}
		bacteria();
		System.out.println(map[x][y]);
	}
	public static void bacteria() {
		while(!q.isEmpty()) {
			Point p = q.poll();
			int x = p.x, y = p.y;
			if(p.time == s) return;
			for(int i = 0; i < 4; i++) {
				int xx = x + dx[i];
				int yy = y + dy[i];
				if(xx < 1 || yy < 1 || xx >= n+1 || yy >= n+1) continue;
				if(map[xx][yy] == 0) {
					map[xx][yy] = p.virus;
					q.offer(new Point(xx, yy, p.virus, p.time+1));
				}
				
			}
		}
		
	}
}
