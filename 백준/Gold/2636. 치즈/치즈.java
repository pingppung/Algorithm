import java.io.*;
import java.util.*;
public class Main {
	static int n, m, time = 0;
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
    public static void main(String[] args) throws Exception {
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
    	
    	boolean chk = true;
    	int beforeMelt = 0;
    	while(chk) {
    		time++;
    		visited = new boolean[n][m];
    		beforeMelt = getCheese();
    		bfs();
    		meltCheese();
    		int count = getCheese();
    		if(count == 0) chk = false;
    	}
    	System.out.println(time);
    	System.out.println(beforeMelt);
    	
    }
    private static void bfs() {
    	Queue<Point> q = new LinkedList<>();
    	q.add(new Point(0, 0));
    	visited[0][0] = true;
    	while(!q.isEmpty()) {
    		Point p = q.poll();
    		for(int i = 0; i < 4; i++) {
        		int xx = p.x + dx[i];
        		int yy = p.y + dy[i];

        		if(xx < 0 || yy < 0 || xx >= n || yy >= m) continue;
        		if(!visited[xx][yy]) {
    				visited[xx][yy] = true;
    				if(map[xx][yy] == 0) {
        				q.add(new Point(xx, yy));
        			}
    				else if(map[xx][yy] == 1) {
        				map[xx][yy] = 2;
        			}
        			
        		}
        	}
    	}
    }
    private static void meltCheese() {
    	for(int i = 0; i < n; i++) {
    		for(int j = 0; j < m; j++) {
    			if(map[i][j] == 2) {
    				map[i][j] = 0;
    			}
    		}
    	}
    }
    private static int getCheese() {
    	int count = 0;
    	for(int i = 0; i < n; i++) {
    		for(int j = 0; j < m; j++) {
    			if(map[i][j] == 1) {
    				count++;
    			}
    		}
    	}
    	return count;
    }
}  