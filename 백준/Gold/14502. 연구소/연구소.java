import java.io.*;
import java.util.*;
public class Main {
	static int n, m, result = 0;
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
    		for(int j = 0; j < m ; j++) {
    			map[i][j] = Integer.parseInt(arr[j]);
    		}
    	}
    	buildWall(0);
    	System.out.println(result);
    	
    }
    private static void buildWall(int wall) {
    	if(wall == 3) {
    		virus();
    		return;
    	}
    	for(int i = 0; i < n; i++) {
    		for(int j = 0; j < m ; j++) {
    			if(map[i][j] == 0) {
    				map[i][j] = 1;
    				buildWall(wall+1);
    				map[i][j] = 0;
    			}
    		}
    	}
    }
    private static void virus() {
    	Queue<int[]> q = new LinkedList<>();
    	int[][] newMap = new int[n][m];
    	for(int i = 0; i < n; i++) {
    		for(int j = 0; j < m ; j++) {
    			newMap[i][j] = map[i][j];
    			if(newMap[i][j] == 2) q.offer(new int[] {i, j});
    		}
    	}
    	while(!q.isEmpty()) {
    		int[] p = q.poll();
    		
    		for(int i = 0; i < 4; i++) {
    			int xx = p[0] + dx[i];
    			int yy = p[1] + dy[i];
    			if(xx < 0 || yy < 0 || xx >= n || yy >= m) continue;
    			if(newMap[xx][yy] == 0) {
    				newMap[xx][yy] = 2;
    				q.offer(new int[] {xx, yy});
    			}
    		}
    	}
    	result = countSafe(newMap);
    }
    private static int countSafe(int[][] newMap) {
    	int count = 0;
    	for(int i = 0; i < n; i++) {
    		for(int j = 0; j < m; j++) {
    			if(newMap[i][j] == 0) count++;
    		}
    	}
    	return Math.max(result, count);
    }
} 