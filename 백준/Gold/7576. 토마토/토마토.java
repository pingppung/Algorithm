import java.io.*;
import java.util.*;
public class Main {
	static class Point {
		int x;
		int y;
		int day;
		public Point(int x, int y, int day) {
			this.x = x;
			this.y = y;
			this.day = day;
		}
	}

	static int m, n;
	static int[][] arr;
	static boolean[][] visited;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	static Queue<Point> q = new LinkedList<>();
	static int result = 0;
	
    public static void main(String[] args) throws IOException{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());

    	m = Integer.parseInt(st.nextToken());
    	n = Integer.parseInt(st.nextToken());
    	
    	arr = new int[n][m];
    	visited = new boolean[n][m];
    	
    	for(int i = 0; i < n; i++) {
    		st = new StringTokenizer(br.readLine());
    		for(int j = 0; j < m; j++) {
    			arr[i][j] = Integer.parseInt(st.nextToken());
    			if(arr[i][j] == 1) q.offer(new Point(i, j, 0));
    		}
    	}
    	bfs();
    	
    	for(int i = 0; i < n; i++) {
    		for(int j = 0; j < m; j++) {
    			if(arr[i][j] == 0) {
    				result = -1;
    				break;
    			}
    		}
    	}
    	if(result != -1) System.out.println(result -1);
    	else System.out.println(result);
    }
    public static void bfs() {
    	while(!q.isEmpty()) {
    		Point p = q.poll();
    		int period = p.day + 1;
    		for(int i = 0; i < 4; i++) {
        		int xx = p.x + dx[i];
        		int yy = p.y + dy[i];
        		if(xx >= 0 && yy >= 0 && xx < n && yy < m) {
        			result = period;
        			if(arr[xx][yy] == 0) {
        				q.offer(new Point(xx, yy, period));
        				arr[xx][yy] = 1;
        			}
        		}
        		
        		
        	}
    	}
    
    	
    }
	
}
