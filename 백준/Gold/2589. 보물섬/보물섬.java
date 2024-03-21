import java.io.*;
import java.util.*;
public class Main {
	static int n, m, result = 0;
	static char[][] map;
	static boolean[][] visited;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	static class Land {
		int x, y, time;
		public Land(int x, int y, int time) {
			this.x = x;
			this.y = y;
			this.time = time;
		}
	}
    public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	n = Integer.parseInt(st.nextToken());
    	m = Integer.parseInt(st.nextToken());
    	map = new char[n][m];
    	for(int i = 0; i < n; i++) {
    		char[] arr = br.readLine().toCharArray();
    		for(int j = 0; j < m; j++) {
    			map[i][j] = arr[j];
    		}
    	}
    	for(int i = 0; i < n; i++) {
    		for(int j = 0; j < m; j++) {
    			if(map[i][j]=='L') {
    				visited = new boolean[n][m];
    				bfs(i, j, 0);
    				
    			}
    		}
    	}
    	System.out.println(result);
    }
    private static void bfs(int x, int y, int time) {
    	Queue<Land> q = new LinkedList<>();
    	q.offer(new Land(x, y, time));
    	visited[x][y] = true;
    	while(!q.isEmpty()) {
    		Land now = q.poll();
    		for(int i =0 ;i < 4; i++) {
    			int xx = now.x + dx[i];
    			int yy = now.y + dy[i];
    			if(xx <0 || yy<0 || xx>=n || yy>=m) continue;
    			if(!visited[xx][yy] && map[xx][yy] == 'L') {
    				visited[xx][yy] = true;
    				q.offer(new Land(xx, yy, now.time + 1));

    				result = Math.max(result, now.time + 1);
    			}
    		}
    	}
    }
}  