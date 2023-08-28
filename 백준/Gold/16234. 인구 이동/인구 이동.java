import java.io.*;
import java.util.*;

public class Main {
	static int N, L, R, count = 0;
	static int[][] map;
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
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		map = new int[N][N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		while (true) { // 인구 이동이 안될 때가지 반복
			boolean chk = false;
			visited = new boolean[N][N];
			for(int i = 0; i < N; i++) {
                for(int j = 0; j < N; j++) {
                    if(!visited[i][j]) {
                    	int sum = bfs(i, j);
                    	if(list.size() > 1) {
                            change(sum);
                            chk = true;
                    	}
                    }
                }
            }
			if(!chk) {
				System.out.println(count);
				return;
			} else count++;
		}
	}

	public static int bfs(int x, int y) {
		Queue<Point> q = new LinkedList<>();
		list = new ArrayList<>();
		q.offer(new Point(x, y));
		list.add(new Point(x, y));
		visited[x][y] = true;
		int sum = map[x][y];

		while (!q.isEmpty()) {
			Point p = q.poll();
			for (int i = 0; i < 4; i++) {
				int xx = p.x + dx[i];
				int yy = p.y + dy[i];
				if (xx < 0 || yy < 0 || xx >= N || yy >= N) continue;
				int diff = Math.abs(map[p.x][p.y] - map[xx][yy]);
				if (!visited[xx][yy] && diff >= L && diff <= R) {
					visited[xx][yy] = true;
					q.offer(new Point(xx, yy));
					list.add(new Point(xx, yy));
					sum += map[xx][yy];
				}

			}
		}
		return sum;

	}
	public static void change(int sum) {
		int avg = sum / list.size();
		for(int i = 0; i < list.size(); i++) {
			map[list.get(i).x][list.get(i).y] = avg;
		}
	}

}
