import java.io.*;
import java.util.*;

public class Main {
	static int n, m, count = 0;
	static int[][] map;
	static boolean[][] visited;

	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, 1, 0, -1 };

	static class Point {
		int x, y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	static ArrayList<Point> list;

	// https://www.acmicpc.net/problem/14503
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		map = new int[n][m];
		st = new StringTokenizer(br.readLine());
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		Point p = new Point(r, c);
		int d = Integer.parseInt(st.nextToken()); // 0-북,1-동,2-남,3-서

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		cleanRobot(r, c, d);
		System.out.println(count);
	}

	public static void cleanRobot(int x, int y, int d) {
		int ewsn = d;
		while (true) {
			//System.out.println(x+" "+y+ " "+ ewsn);
			if (map[x][y] == 0) { // 청소되지 않은 경우, 현재 칸 청소
				map[x][y] = 2; //1-벽 2-청소완료
				count++;
			}
			int clean_cnt = 0;  //주변 4칸 중 청소되지 않은 빈 칸수 
			for (int i = 0; i < 4; i++) {
				int xx = x + dx[i];
				int yy = y + dy[i];
				if (xx < 0 || yy < 0 || xx >= n || yy >= m)
					continue;
				if (map[xx][yy] == 0)
					clean_cnt++;
			}

			if (clean_cnt == 0) { // 현재 칸 주변 4칸 중 청소되지 않은 빈칸이 없는 경우
				// 1.바라보는 방향을 유지한 채 한칸 후진할 수 있다면 하칸 후진하고 continue;
				Point backward = moveRobot_B(x, y, ewsn);
				if (backward != null) {
					x = backward.x;
					y = backward.y;
					continue;
				}
				// 2.바라보는 방향의 뒤쪽 칸 벽이라면 작동 중지 return
				else {
					return;
				}
			} else { // 청소되지 않은 빈 칸이 있는 경우
				// 1.반시계 방향으로 90도 회전
				ewsn = (ewsn+3) % 4;
				// 2.바라보는 방향을 기준으로 앞쪽 칸이 청소되지 않은 빈칸인 경우 한칸 전진
				Point forward = moveRobot_F(x, y, ewsn);
				if(forward != null) {
					x = forward.x;
					y = forward.y;
				}
				continue;
			}
		}
	}

	public static Point moveRobot_B(int x, int y, int ewsn) { // 후진
		if (ewsn == 0) {
			if (x + 1 < n) x += 1;
		} else if (ewsn == 1) {
			if (y - 1 >= 0) y -= 1;
		} else if (ewsn == 2) {
			if (x - 1 >= 0) x -= 1;
		} else {
			if (y + 1 < m) y += 1;
		}
		if(map[x][y] == 1) return null;//뒤쪽 칸이 벽이라 후진하지 못
		return new Point(x, y);
	}

	public static Point moveRobot_F(int x, int y, int ewsn) { // 전진

		if (ewsn == 0) {
			if (x - 1 >= 0) x -= 1;
		} else if (ewsn == 1) {
			if (y + 1 < m) y += 1;
		} else if (ewsn == 2) {
			if (x + 1 < n) x += 1;
		} else {
			if (y - 1 >= 0) y -= 1;
		}
		//앞쪽 칸이 청소되지 않은 빈 칸인 경우 전진
		if(map[x][y] == 0) return new Point(x, y); 
		else return null;
	}
}
