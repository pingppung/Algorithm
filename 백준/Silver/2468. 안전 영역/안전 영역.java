import java.io.*;
import java.util.*;
public class Main {
	static int n, maxH, result = 1;
	static int[][] map;
	static boolean[][] visited;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
    public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st;
    	n = Integer.parseInt(br.readLine());
    	map = new int[n][n];
    	
    	for(int i = 0; i < n; i++) {
    		st = new StringTokenizer(br.readLine());
    		for(int j = 0; j < n; j++) {
    			map[i][j] = Integer.parseInt(st.nextToken());
    			maxH = Math.max(maxH, map[i][j]);
    		}
    	}
    	for(int i = 1; i <= maxH; i++) {
    		int count = 0;
    		visited = new boolean[n][n];
    		for(int j = 0; j < n; j++) {
    			for(int k = 0; k < n; k++) {
    				if(!visited[j][k] && map[j][k] > i) {
    					count++;
    					findSafePlace(j, k, i);
    				}
    			}
    		}
    		result = Math.max(result, count);
    	}
    	System.out.println(result);
    }
    private static void findSafePlace(int x, int y, int height) {
    	visited[x][y] = true;
    	for(int i = 0; i < 4; i++) {
    		int xx = x + dx[i];
    		int yy = y + dy[i];
    		if(xx < 0 || yy < 0 || xx >= n || yy >= n) continue;
    		if(!visited[xx][yy] && map[xx][yy] > height) {
    			findSafePlace(xx, yy, height);
    		}
    	}
    }
} 