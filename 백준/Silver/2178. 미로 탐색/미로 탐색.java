import java.io.*;
import java.util.*;
public class Main {
	static int n, m;
	static int[][] map;
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
    	
    	map = new int[n+1][m+1];
    	visited = new boolean[n+1][m+1];
    	
    	for(int i = 1; i <= n; i++) {
    		String nums = br.readLine();
    		for(int j = 1; j <= m; j++) {
    			map[i][j] = nums.charAt(j-1) - '0';
    		}
    	}

    	
		bfs(1,1);
		System.out.println(map[n][m]);
    }
    
	private static void bfs(int x, int y) {
		Queue<Point> q = new LinkedList<>();
		q.offer(new Point(x, y));
		visited[x][y] = true;
		while(!q.isEmpty()) {
			Point p = q.poll();
			for(int i = 0; i < 4; i++) {
				int xx = p.x + dx[i];
				int yy = p.y + dy[i];
				if(xx < 1 || yy < 1 || xx >= n+1 || yy >= m+1) continue;
				if(!visited[xx][yy] && map[xx][yy] == 1) {
					visited[xx][yy] = true;
					q.offer(new Point(xx, yy));
					map[xx][yy] = map[p.x][p.y] + 1;
					if(xx == n && yy == m) return;
				}
			}
		}
	}
} 