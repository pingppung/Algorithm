import java.io.*;
import java.util.*;
public class Main {
	static class Point {
		int x;
		int y;
		int cnt;
		int destroyed;
		public Point(int x, int y, int cnt, int destroyed) {
			this.x = x;
			this.y = y;
			this.cnt = cnt;
			this.destroyed = destroyed;
		}
	}

	static int n, m;
	static int[][] arr;
	static boolean[][][] visited;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	static int result = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());

    	n = Integer.parseInt(st.nextToken());
    	m = Integer.parseInt(st.nextToken());
    	
    	
    	arr = new int[n][m];
    	visited = new boolean[n][m][2];
    	
    	for(int i = 0; i < n; i++) {
    		String[] s = br.readLine().split("");
    		for(int j = 0; j < m; j++) {
        		int num = Integer.parseInt(s[j]);
        		arr[i][j] =  num;
        		
    		}
    	}
    	
    	System.out.println(bfs(0,0));
    
    }
    public static int bfs(int x, int y) {
    	Queue<Point> q = new LinkedList<>();
    	q.offer(new Point(x, y, 1, 0));
    	visited[x][y][0] = true;
    	visited[x][y][1] = true;
    	while(!q.isEmpty()) {
    		Point p = q.poll();
    		if(p.x == (n-1) && p.y == (m-1)) {
    			return p.cnt;
    		}
    		for(int i = 0; i < 4; i++) {
        		int xx = p.x + dx[i];
        		int yy = p.y + dy[i];
        		if(xx >= 0 && yy >= 0  && xx < n && yy < m) {
        			if(arr[xx][yy] == 0) {
        				if(!visited[xx][yy][p.destroyed]) {
                			q.offer(new Point(xx, yy, p.cnt+1, p.destroyed));
                			visited[xx][yy][p.destroyed] = true;
        				} 
        			} else {
        				if(p.destroyed == 0 && !visited[xx][yy][1]) {
        					q.add(new Point(xx, yy, p.cnt+1, 1));
        					visited[xx][yy][1] = true;
        				}
        			}
        		} 
        	}
    	}
    	return -1;
    	
    }
    
}
