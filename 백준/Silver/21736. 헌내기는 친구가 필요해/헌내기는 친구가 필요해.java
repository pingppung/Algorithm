import java.io.*;
import java.util.*;
public class Main {
	static boolean[][] visited;
	static int n, m, count = 0;
	static char[][] map;
	static int[] dx = {0,0,-1,1}, dy = {-1,1,0,0};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new char[n][m];
		visited = new boolean[n][m];
		int dy_x = 0, dy_y = 0;
		for(int i = 0; i < n; i++) {
			String s = br.readLine();
			for(int j = 0; j < s.length(); j++) {
				map[i][j] = s.charAt(j);
				if(map[i][j] == 'I') {
					dy_x = i;
					dy_y = j;
				}
			}
		}
		dfs(dy_x, dy_y);
		if(count == 0) System.out.println("TT");
		else System.out.println(count);

	}
	public static void dfs(int x, int y) {
		visited[x][y] = true;
		for(int i = 0; i < 4; i++) {
			int xx = x+dx[i];
			int yy = y+dy[i];
			if(xx < 0 || yy < 0 || xx >= n || yy >=m) continue;
			if(map[xx][yy] == 'X') continue;
			if(map[xx][yy] == 'O'&& !visited[xx][yy]) {
				visited[xx][yy] = true;
				dfs(xx, yy);
			}
			if(map[xx][yy] == 'P' && !visited[xx][yy]) {
				count++;
				visited[xx][yy] = true;
				dfs(xx,yy);
			}
		}
		
	}
	
}
