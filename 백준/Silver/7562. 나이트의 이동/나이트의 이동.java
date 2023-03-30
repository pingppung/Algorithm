import java.io.*;
import java.util.*;
public class Main {
	static class Point {
		int x;
		int y;
		int cnt;
		public Point(int x, int y, int cnt) {
			this.x = x;
			this.y = y;
			this.cnt = cnt;
		}
	}
	static int m, n, l;
	static int end_x, end_y;
	static boolean[][] visited;
	static int[] dx = {-1,-2,-2,-1,1,2,2,1};
	static int[] dy = {-2,-1,1,2,2,1,-1,-2};
	static int result = 0;

    public static void main(String[] args) throws IOException{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st;
    	int t = Integer.parseInt(br.readLine());
    	
    	
    	while(t-- > 0) {
    		l = Integer.parseInt(br.readLine());
    		visited = new boolean[l][l];
    		Point[] p = new Point[2];
	    	st = new StringTokenizer(br.readLine());
	    	int start_x = Integer.parseInt(st.nextToken());
	    	int start_y = Integer.parseInt(st.nextToken());
	    	
	    	st = new StringTokenizer(br.readLine());
	    	end_x = Integer.parseInt(st.nextToken());
	    	end_y = Integer.parseInt(st.nextToken());
	    	
	    		    	
	    	System.out.println(bfs(start_x, start_y));
    	}
    
    }
    public static int bfs(int x, int y) {

    	Queue<Point> q = new LinkedList<>();
    	visited[x][y] = true;
    	q.offer(new Point(x, y, 0));
    	while(!q.isEmpty()) {
    		Point p = q.poll();
    		if(p.x == end_x && p.y == end_y) return p.cnt;
    		for(int i = 0; i < 8; i++) {
        		int xx = p.x + dx[i];
        		int yy = p.y + dy[i];
        		if(xx >= 0 && yy >= 0  && xx < l && yy < l && !visited[xx][yy]) {
        			q.offer(new Point(xx, yy, p.cnt+1));
        			visited[xx][yy] = true;
        		}
        	}
    	}
    	return -1;
    
    }
    
}
