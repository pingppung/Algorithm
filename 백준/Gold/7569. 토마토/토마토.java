import java.io.*;
import java.util.*;
public class Main {
	static class Point {
		int x;
		int y;
		int z;
		int day;
		public Point(int x, int y, int z, int day) {
			this.x = x;
			this.y = y;
			this.z = z;
			this.day = day;
		}
	}
	static int m, n, h;
	static int[][][] arr;
	static int[] dx = {-1, 1, 0, 0, 0, 0};
	static int[] dy = {0, 0, -1, 1 ,0 ,0};
	static int[] dz = {0, 0, 0, 0, -1, 1};
	static int result = 0;

	static Queue<Point> q = new LinkedList<>();
    public static void main(String[] args) throws IOException{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());

    	m = Integer.parseInt(st.nextToken());
    	n = Integer.parseInt(st.nextToken());
    	h = Integer.parseInt(st.nextToken());
    	
    	arr = new int[n][m][h];
    	
    	for(int k = 0; k < h; k++) {
	    	for(int i = 0; i < n; i++) {
	    		st = new StringTokenizer(br.readLine());
	    		for(int j = 0; j < m; j++) {
	        		arr[i][j][k] = Integer.parseInt(st.nextToken());
	        		if(arr[i][j][k] == 1) q.offer(new Point(i, j, k, 0));
	    		}
	    	}
    	}
    	bfs();
    	for(int k = 0; k < h; k++) {
    		for(int i = 0; i < n; i++) {
	    		for(int j = 0; j < m; j++) {
	        		if(arr[i][j][k] == 0) {
	        			result = -1;
	        			break;
	        		}
	    		}
	    	}
    	}
    	if(result != -1)System.out.println(result-1);
    	else System.out.println(result);
    }
    public static void bfs() {
    	while(!q.isEmpty()) {
    		Point p = q.poll();
    		int period = p.day + 1;
    		for(int i = 0; i < 6; i++) {
        		int xx = p.x + dx[i];
        		int yy = p.y + dy[i];
        		int zz = p.z + dz[i];
        		if(xx >= 0 && yy >= 0 && zz >= 0 && xx < n && yy < m && zz < h) {
        			result = period;
        			if(arr[xx][yy][zz] == 0) {
        				q.offer(new Point(xx, yy, zz, period));
        				arr[xx][yy][zz] = 1;
        			} 
        		}
        	}
    	}
    
    }
    
}
