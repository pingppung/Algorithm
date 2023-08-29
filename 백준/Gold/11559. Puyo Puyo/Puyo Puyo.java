import java.io.*;
import java.util.*;

public class Main {

	static char[][] map;
	static boolean[][] visited;

	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { 1, -1, 0, 0 };

	static class Point {
		int x, y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	static ArrayList<Point> list;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		//StringTokenizer st = new StringTokenizer(br.readLine());
		
		
		map = new char[12][6];
		for (int i = 0; i < 12; i++) {
			String s = br.readLine();
			for (int j = 0; j < 6; j++) {
				map[i][j] = s.charAt(j);
			}
		}
		int count = 0;
		while (true) {
			boolean chk = true;
			visited = new boolean[12][6];
			for (int i = 0; i < 12; i++) {
				for (int j = 0; j < 6; j++) {
					if (map[i][j] != '.') {
						list = new ArrayList<>();
						bfs(i, j);
						if (list.size() >= 4) {
							chk = false;
							for (Point p : list) {
								map[p.x][p.y] = '.';
							}
						}
					}
				}
			}
			if(chk) break;
			fall();
			count++;
		}
		System.out.println(count);

	}

	public static void bfs(int x, int y) {
		Queue<Point> q = new LinkedList<>();
		q.offer(new Point(x, y));
		list.add(new Point(x, y));
		visited[x][y] = true;
		char c = map[x][y];
		
		while (!q.isEmpty()) {
			Point p = q.poll();
			for (int i = 0; i < 4; i++) {
				int xx = p.x + dx[i];
				int yy = p.y + dy[i];
				if (xx < 0 || yy < 0 || xx >= 12 || yy >= 6)
					continue;
				if (!visited[xx][yy] && map[xx][yy] == c) {
					visited[xx][yy] = true;
					q.offer(new Point(xx, yy));
					list.add(new Point(xx, yy));

				}

			}
		}

	}
	public static void fall() {
		for (int i = 0; i < 6; i++) {
			for (int j = 11; j > 0; j--) {
				if(map[j][i] == '.') {
					for(int k = j-1; k >= 0; k--) {
						if(map[k][i] != '.') {
							map[j][i] = map[k][i];
							map[k][i] = '.';
							break;
						}
					}
				}
				
			}
		}
	}
}
