import java.io.*;
import java.util.*;
public class Main {
	static int n, m, h, time = 0;
	static int[][][] tomatoes;
	static boolean[][] visited;
	static int[] dx = {-1, 1, 0, 0, 0, 0};
	static int[] dy = {0, 0, -1, 1, 0, 0};
	static int[] dz = {0, 0, 0, 0, -1, 1};
	static class Tomato {
		int x, y, z, day;
		public Tomato(int x, int y, int z, int day) {
			this.x = x;
			this.y = y;
			this.z = z;
			this.day = day;
		}
	}
	static Queue<Tomato> q = new LinkedList<>();
    public static void main(String[] args) throws IOException{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	m = Integer.parseInt(st.nextToken());
    	n = Integer.parseInt(st.nextToken());
    	h = Integer.parseInt(st.nextToken());
    	
    	tomatoes = new int[n][m][h];
    	for(int i = 0; i < h; i++) {
    		for(int j = 0; j < n; j++) {
        		st = new StringTokenizer(br.readLine());
    			for(int k = 0; k < m; k++) {
    				tomatoes[j][k][i] = Integer.parseInt(st.nextToken());
    				if(tomatoes[j][k][i] == 1) q.offer(new Tomato(j, k, i, 0));
    			}
    		}
    	}
    	bfs();
    	for(int i = 0; i < h; i++) {
    		for(int j = 0; j < n; j++) {
    			for(int k = 0; k < m; k++) {
    				if(tomatoes[j][k][i] == 0) {
    					time = -1;
    					break;
    				}
    			}
    		}
    	}
    	System.out.println(time);
    	
    }
    private static void bfs() {
    	while(!q.isEmpty()) {
    		Tomato t = q.poll();
    		int period = t.day + 1;
    		for(int i = 0; i < 6; i++) {
    			int xx = t.x + dx[i];
    			int yy = t.y + dy[i];
    			int zz = t.z + dz[i];
    			if(xx < 0 || yy < 0 || zz < 0 || xx >= n || yy >= m || zz >= h)
    				continue;
    			if(tomatoes[xx][yy][zz] == 0) {
    				time = period;
    				tomatoes[xx][yy][zz] = 1;
    				q.offer(new Tomato(xx, yy, zz, period));
    				
    			}
    		}
    	}
    }
}
