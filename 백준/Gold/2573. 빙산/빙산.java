import java.io.*;
import java.util.*;
public class Main {
	static int n, m;
	static int[][] area;
	static boolean[][] visited;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
    public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	n = Integer.parseInt(st.nextToken());
    	m = Integer.parseInt(st.nextToken());
    	
    	area = new int[n][m];
    	for(int i = 0; i < n; i++) {
    		st = new StringTokenizer(br.readLine());
    		for(int j = 0; j < m; j++) {
    			area[i][j] = Integer.parseInt(st.nextToken());
    		}
    	}

		int year = 0;
    	while(true) {
    		int icebergCount = 0;
    		visited= new boolean[n][m];
        	for(int i = 0; i < n; i++) {
        		for(int j = 0; j < m; j++) {
        			if(!visited[i][j] && area[i][j] > 0) {
        				icebergCount++;
        				countIceBerg(i, j);
        			}
        		}
        	}
        	if(icebergCount >= 2) break;
        	if(icebergCount == 0) {
        		year = 0;
        		break;
        	}
        	bfs();
        	year++;
        	
    	}
    	System.out.println(year);
    }
    private static void countIceBerg(int x, int y) {
    	visited[x][y] = true;
    	for(int i = 0; i < 4; i++) {
    		int xx = x + dx[i];
    		int yy = y + dy[i];
    		if(xx < 0 || yy < 0 || xx >= n || yy >= m) continue;
    		if(!visited[xx][yy] && area[xx][yy] > 0) {
    			countIceBerg(xx, yy);
    		}
    	}
    }
    private static void bfs() {
    	Queue<int[]> q = new LinkedList<>();
    	boolean[][] iceberg = new boolean[n][m];
    	
    	for(int i = 0; i < n; i++) {
    		for(int j = 0; j < m; j++) {
    			if(area[i][j] > 0) {
    				q.offer(new int[] {i, j});
    				iceberg[i][j] = true;
    			}
    		}
    	}
    	while(!q.isEmpty()) {
    		int[] now = q.poll();
    		int seaCount = 0;
    		for(int i= 0; i < 4; i++) {
    			int xx = now[0] + dx[i];
    			int yy = now[1] + dy[i];
    			if(xx < 0 || yy< 0 || xx >= n|| yy >= m) continue;
    			if(!iceberg[xx][yy] && area[xx][yy] == 0) {
    				seaCount++;
    			}
    		}
    		area[now[0]][now[1]] -= seaCount;
    		if(area[now[0]][now[1]] < 0) area[now[0]][now[1]] = 0;
    	}
    }
}  