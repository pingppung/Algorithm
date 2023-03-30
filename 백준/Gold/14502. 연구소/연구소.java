import java.io.*;
import java.util.*;
public class Main {
	static class Point {
		int x;
		int y;
		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	static int m, n;
	static int[][] arr;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	static int result = 0;
	
    public static void main(String[] args) throws IOException{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	
    	n = Integer.parseInt(st.nextToken());
    	m = Integer.parseInt(st.nextToken());
    	
    	arr = new int[n][m];
    	
    	for(int i = 0; i < n; i++) {
    		st = new StringTokenizer(br.readLine());
    		for(int j = 0; j < m; j++) {
    			arr[i][j] = Integer.parseInt(st.nextToken());
    		}
    	}
    	dfs(0);
    	
    	System.out.println(result);
    }
    public static void dfs(int depth) {
    	if(depth == 3) {
    		bfs();
    		return;
    	}
    	for(int i = 0; i < n; i++) {
    		for(int j = 0; j < m; j++) {
    			if(arr[i][j] == 0) {
    				arr[i][j] = 1;
    				dfs(depth +1);
    				arr[i][j] = 0;
    			}
    		}
    	}
    }
    public static void bfs() {
    	Queue<Point> q = new LinkedList<>();
    	int[][] newWall = new int[n][m];
    	for(int i = 0; i < n; i++) {
    		for(int j = 0; j < m; j++) {
    			newWall[i][j] = arr[i][j];
    			if(newWall[i][j] == 2) q.offer(new Point(i, j));
    		}
    	}
    	while(!q.isEmpty()) {
    		Point p = q.poll();
    		for(int i = 0; i < 4; i++) {
        		int xx = p.x + dx[i];
        		int yy = p.y + dy[i];
        		if(xx >= 0 && yy >= 0 && xx < n && yy < m) {
        			if(newWall[xx][yy] == 0) {
        				q.offer(new Point(xx, yy));
        				newWall[xx][yy] = 2;
        			} 
        		}
        	}
    	}
    
    	int count = 0;
    	for(int i = 0; i < n; i++) {
    		for(int j = 0; j < m; j++) {
    			if(newWall[i][j] == 0) {
    				count++;
    			}
    		}
    	}
    	result = Math.max(result, count);
    }
    
}
