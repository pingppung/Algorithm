import java.io.*;
import java.util.*;
public class Main {
	static int n, m, count;
	static char[][] map;
	static boolean[][] visited;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	static class Point{
		int x, y;
		Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
    public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	n = Integer.parseInt(st.nextToken());
    	m = Integer.parseInt(st.nextToken());
    	
    	map = new char[m][n];
    	visited = new boolean[m][n];
    	
    	//w-우리, b-적군
    	for(int i = 0; i < m; i++) {
    		String soldier = br.readLine();
    		for(int j = 0; j < n; j++) {
    			map[i][j] = soldier.charAt(j);
    		}
    	}

    	int white = 0, blue = 0;
    	for(int i = 0; i < m; i++) {
    		for(int j = 0; j < n; j++) {
    			if(!visited[i][j]) {
    				char color = map[i][j];
    				count = 0;
    				dfs(i, j, map[i][j]);
    				if(color == 'W') white += count * count;
    				else blue += count * count;
    			}
    		}
    	}
		System.out.println(white + " "+ blue);
    }
    
	private static void dfs(int x, int y, char color) {
		visited[x][y] = true;
		count++;
		for(int i = 0; i < 4; i++) {
			int xx = x  + dx[i];
			int yy = y + dy[i];

			if(xx < 0 || yy < 0 || xx >= m || yy >= n) continue;
			if(!visited[xx][yy] && map[xx][yy] == color) {
				dfs(xx, yy, map[xx][yy]);
			}
		}

	}
} 