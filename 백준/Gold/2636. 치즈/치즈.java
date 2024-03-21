import java.io.*;
import java.util.*;
public class Main {
	static int n, m, maxP = 0;
	static int[][] map;
	static boolean[][] visited;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
    public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	n = Integer.parseInt(st.nextToken());
    	m = Integer.parseInt(st.nextToken());
    	map = new int[n][m];
    	for(int i = 0; i < n; i++) {
    		String[] arr = br.readLine().split(" ");
    		for(int j = 0; j < m; j++) {
    			map[i][j] = Integer.parseInt(arr[j]);
    		}
    	}
    	int time = 0;
    	boolean zero = false;
    	int cheese = 0;
    	while(!zero) {
    		visited = new boolean[n][m];

    		time++;
    		cheese = getCheese();
    		contactAir(); 
    		melt();
    		int count = getCheese();
    		if(count == 0) zero = true;
    	}
    	System.out.println(time);
    	System.out.println(cheese);
    }
    private static void contactAir() {
    	Queue<int[]> q = new LinkedList<>();
    	q.add(new int[] {0, 0});
    	visited[0][0] = true;
    	while(!q.isEmpty()) {
    		int[] p = q.poll();
    		for(int i = 0; i < 4; i++) {
        		int xx = p[0] + dx[i];
        		int yy = p[1] + dy[i];

        		if(xx < 0 || yy < 0 || xx >= n || yy >= m) continue;
        		if(!visited[xx][yy]) {
    				visited[xx][yy] = true;
    				if(map[xx][yy] == 0) {
        				q.add(new int[] {xx, yy});
        			}
    				else if(map[xx][yy] == 1) {
        				map[xx][yy] = 2;
        			}
        			
        		}
        	}
    	}
    }
    private static int getCheese() {
    	int count = 0;
    	for(int i = 0; i < n; i++) {
    		for(int j = 0; j < m; j++) {
    			if(map[i][j] == 1) count++;
    		}
    	}
    	return count;
    }
    private static void melt() {
    	for(int i = 0; i < n; i++) {
    		for(int j = 0; j < m; j++) {
    			if(map[i][j] == 2) {
    				map[i][j] = 0;
    			}
    		}
    	}
    }
   
}  