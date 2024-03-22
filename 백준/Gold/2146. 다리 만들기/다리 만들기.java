import java.io.*;
import java.util.*;
public class Main {
	static int n,count = 0, minLen = Integer.MAX_VALUE;
	static int[][] map;
	static boolean[][] visited;
	static class Point{
		int x, y, bridgeLen;
		Point(int x, int y, int bridgeLen){
			this.x = x;
			this.y = y;
			this.bridgeLen = bridgeLen;
		}
	}
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
    public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	n = Integer.parseInt(st.nextToken());
    	map = new int[n][n];
    	
    	
    	for(int i = 0; i < n; i++) {
    		String[] arr = br.readLine().split(" ");
    		for(int j = 0; j < n; j++) {
    			map[i][j] = Integer.parseInt(arr[j]);
    		}
    	}
    	
    	visited = new boolean[n][n];
    	for(int i = 0; i < n; i++) {
    		for(int j = 0; j < n; j++) {
    			if(!visited[i][j] && map[i][j] == 1) {
    				count++;
    				findIsland(i, j);
    			}
    		}
    	}
    	for(int i = 0; i < n; i++) {
    		for(int j = 0; j < n; j++) {
    			if(map[i][j] >= 1) {
    				visited = new boolean[n][n];
    				bridge(i, j);
    			}
    		}
    	}
    	
    	System.out.println(minLen);
    	
    }
    private static void findIsland(int x, int y) {
    	visited[x][y] = true;
    	map[x][y] = count;
    	for(int i = 0; i < 4; i++) {
    		int xx = x + dx[i];
    		int yy = y + dy[i];
    		if(xx < 0 || yy < 0 || xx >= n || yy >= n) continue;
    		if(!visited[xx][yy] && map[xx][yy] == 1) {
    			findIsland(xx, yy);
    		}
    	}
    }
    private static void bridge(int x, int y) {
    	Queue<Point> q= new LinkedList<>();
    	q.offer(new Point(x, y, 0));
    	while(!q.isEmpty()) {
    		Point p = q.poll();
    		for(int i = 0; i < 4; i++) {
        		int xx = p.x + dx[i];
        		int yy = p.y + dy[i];
        		if(xx < 0 || yy < 0 || xx >= n || yy >= n) continue;
        		if(!visited[xx][yy] && map[xx][yy] != map[x][y]) {
        			visited[xx][yy] = true;
        			if(map[xx][yy] == 0){
	        			q.offer(new Point(xx, yy, p.bridgeLen + 1));
	        		} else {
	        			minLen = Math.min(minLen, p.bridgeLen);
	        		}
        		}
        	}
    	}
    }
}  