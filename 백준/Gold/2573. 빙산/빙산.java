import java.io.*;
import java.util.*;
public class Main {
	static int n, m, day = 0;
	static int[][] map;
	static boolean[][] visited;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	static class Point{
		int x, y;
		Point(int x, int y){
			this.x = x;
			this.y = y;
		}
	}
    public static void main(String[] args) throws IOException{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	n = Integer.parseInt(st.nextToken());
    	m = Integer.parseInt(st.nextToken());
    	map = new int[n][m];
    	for(int i = 0; i < n; i++) {
    		st = new StringTokenizer(br.readLine());
    		for(int j = 0; j < m; j++) {
    			map[i][j] = Integer.parseInt(st.nextToken());
    		}
    	}
    	int year = 0;
    	while(true) {
    		visited = new boolean[n][m];
    		int count = 0;
        	for(int i = 0; i < n; i++) {
        		for(int j = 0; j < m; j++) {
        			if(!visited[i][j] && map[i][j] > 0) {
        				count++;
        				dfs(i, j);
        			}
        		}
        	}
        	if(count >= 2) break;
        	else if(count == 0) {
        		year = 0;
        		break;
        	}
        	bfs();
        	year++;
    	}
    	System.out.println(year);
    	
    }
    private static void dfs(int x, int y) {
    	visited[x][y] = true;
    	for(int i = 0; i < 4; i++) {
    		int xx = x + dx[i];
    		int yy = y + dy[i];
    		if(xx < 0 || yy < 0 || xx >= n || yy >= m) continue;
    		if(!visited[xx][yy] && map[xx][yy] > 0) {
    			dfs(xx, yy);
    		}
    	}
    }
    private static void bfs() {
    	Queue<Point> q = new LinkedList<>();
    	boolean[][] iceberg = new boolean[n][m];
    	for(int i = 0; i < n; i++) {
    		for(int j = 0; j < m; j++) {
    			if(map[i][j] > 0) {
    				q.offer(new Point(i, j));
    				iceberg[i][j] = true;
    			}
    		}
    	}
    	while(!q.isEmpty()) {
    		Point p = q.poll();
    		int seaBorderCount = 0;
    		for(int i = 0; i < 4; i++) {
    			int xx = p.x + dx[i];
    			int yy = p.y + dy[i];
    			if(xx < 0 || yy < 0 || xx >= n || yy >= m) continue;
    			if(!iceberg[xx][yy] && map[xx][yy] == 0) {
    				seaBorderCount++;
    			}
    		}
    		map[p.x][p.y] -= seaBorderCount;
    		if(map[p.x][p.y] < 0) map[p.x][p.y] = 0;
    	}
    }
    
}
