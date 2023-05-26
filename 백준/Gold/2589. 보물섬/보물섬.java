import java.io.*;
import java.util.*;
public class Main {
	static class Point{
		int x, y, count;
		Point(int x, int y, int count){
			this.x = x;
			this.y = y;
			this.count = count;
		}
	} 
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	static int N,M,count;
	static char[][] map;
	static boolean[][] visited;
    public static void main(String[] args) throws IOException{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	
    	N = Integer.parseInt(st.nextToken());
    	M = Integer.parseInt(st.nextToken());
    	map = new char[N][M];
    	for(int i = 0; i < N; i++) {
    		String s = br.readLine();
    		for(int j = 0; j < M; j++) {
    			map[i][j] = s.charAt(j);
    		}
    	}
    	for(int i = 0; i < N; i++) {
    		for(int j = 0; j < M; j++) {
    			if(map[i][j]=='L') {
    				visited = new boolean[N][M];
    				bfs(i, j, 0);
    				
    			}
    		}
    	}
    	System.out.println(count);
    }
    public static void bfs(int x, int y, int cnt) {
    	Queue<Point> q = new LinkedList<>();
    	q.offer(new Point(x, y, cnt));
    	visited[x][y] = true;
    	while(!q.isEmpty()) {
    		Point p = q.poll();
        	for(int i = 0; i < 4; i++) {
        		int xx = p.x+dx[i];
        		int yy = p.y+dy[i];
        		if(xx < 0 || xx >= N || yy < 0 || yy >=M) continue;
        		if(map[xx][yy] =='L'&& !visited[xx][yy]) {
        			visited[xx][yy] = true;
        			q.offer(new Point(xx, yy, p.count+1));
        			count = Math.max(count, p.count+1);
        		}
        	}
    		
    	}
    }
}
