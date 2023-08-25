import java.io.*;
import java.util.*;

public class Main {
	static int n, m, count = Integer.MAX_VALUE;
	static int[][] office;

	static class Point {
		int x;
		int y;
		int num;

		Point(int x, int y, int num) {
			this.x = x;
			this.y = y;
			this.num = num;
		}
	}

	static ArrayList<Point> cctv = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		office = new int[n][m];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				office[i][j] = Integer.parseInt(st.nextToken());
				if (office[i][j] != 0 && office[i][j] != 6) {
					cctv.add(new Point(i, j, office[i][j]));
				}
			}
		}
		dfs(0, office);
		System.out.println(count);
	}

	public static void dfs(int depth, int[][] office) {
		if (depth == cctv.size()) { // cctv 방향 다 정했을때 0 공간 개수
			count = Math.min(count, chkSpace(office));
			return;
		}
		int x = cctv.get(depth).x;
		int y = cctv.get(depth).y;
		int num = cctv.get(depth).num;
		int[][] copy;
		if (num == 1) {
			copy = copy(office);
			chkRight(copy, x, y);
			dfs(depth + 1, copy);

			copy = copy(office);
			chkLeft(copy, x, y);
			dfs(depth + 1, copy);

			copy = copy(office);
			chkTop(copy, x, y);
			dfs(depth + 1, copy);

			copy = copy(office);
			chkBottom(copy, x, y);
			dfs(depth + 1, copy);

		} else if (num == 2) {
			copy = copy(office);
			chkRight(copy, x, y);
			chkLeft(copy, x, y);
			dfs(depth + 1, copy);

			copy = copy(office);
			chkTop(copy, x, y);
			chkBottom(copy, x, y);
			dfs(depth + 1, copy);
		} else if (num == 3) {
			copy = copy(office);
			chkTop(copy, x, y);
			chkRight(copy, x, y);
			dfs(depth + 1, copy);

			copy = copy(office);
			chkRight(copy, x, y);
			chkBottom(copy, x, y);
			dfs(depth + 1, copy);

			copy = copy(office);
			chkLeft(copy, x, y);
			chkBottom(copy, x, y);
			dfs(depth + 1, copy);

			copy = copy(office);
			chkTop(copy, x, y);
			chkLeft(copy, x, y);
			dfs(depth + 1, copy);

		} else if (num == 4) {
			copy = copy(office);
			chkTop(copy, x, y);
			chkBottom(copy, x, y);
			chkRight(copy, x, y);
			dfs(depth + 1, copy);

			copy = copy(office);
			chkBottom(copy, x, y);
			chkLeft(copy, x, y);
			chkRight(copy, x, y);
			dfs(depth + 1, copy);

			copy = copy(office);
			chkTop(copy, x, y);
			chkLeft(copy, x, y);
			chkBottom(copy, x, y);
			dfs(depth + 1, copy);

			copy = copy(office);
			chkTop(copy, x, y);
			chkLeft(copy, x, y);
			chkRight(copy, x, y);
			dfs(depth + 1, copy);
		} else if (num == 5) {
			copy = copy(office);
			chkTop(copy, x, y);
			chkLeft(copy, x, y);
			chkRight(copy, x, y);
			chkBottom(copy, x, y);
			dfs(depth + 1, copy);
		}

	}

	public static int chkSpace(int[][] arr) {
		int cnt = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (arr[i][j] == 0)
					cnt++;
			}
		}
		return cnt;
	}

	public static int[][] copy(int[][] arr) {
		int[][] map = new int[n][m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				map[i][j] = arr[i][j];
			}
		}
		return map;
	}

	public static void chkRight(int[][] arr, int x, int y) {
		for (int i = y - 1; i >= 0; i--) {
			if (arr[x][i] == 6)
				return;
			if (arr[x][i] != 0)
				continue;
			arr[x][i] = -1;
		}
	}

	public static void chkLeft(int[][] arr, int x, int y) {
		for (int i = y + 1; i < m; i++) {
			if (arr[x][i] == 6)
				return;
			if (arr[x][i] != 0)
				continue;
			arr[x][i] = -1;
		}
	}

	public static void chkTop(int[][] arr, int x, int y) {
		for (int i = x - 1; i >= 0; i--) {
			if (arr[i][y] == 6)
				return;
			if (arr[i][y] != 0)
				continue;
			arr[i][y] = -1;
		}
	}

	public static void chkBottom(int[][] arr, int x, int y) {
		for (int i = x + 1; i < n; i++) {
			if (arr[i][y] == 6)
				return;
			if (arr[i][y] != 0)
				continue;
			arr[i][y] = -1;
		}
	}

}
