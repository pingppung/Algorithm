import java.io.*;
import java.util.*;
public class Main {
	static int n, count = 0, blindCount = 0;
	static boolean[][] visited;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
    public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	n = Integer.parseInt(br.readLine());
    	char[][] map = new char[n][n];
    	char[][] mapBlind = new char[n][n];
    	for(int i = 0; i < n; i++) {
    		String s = br.readLine();
    		for(int j = 0; j < n; j++) {
    			char color = s.charAt(j);
    			map[i][j] = color;
    			mapBlind[i][j] = color;
    			if(color == 'G') mapBlind[i][j] = 'R';
    		}
    	}

    	visited = new boolean[n][n];
    	for(int i = 0; i < n; i++) {
    		for(int j = 0; j < n; j++) {
    			if(!visited[i][j]) {
        	    	dfs(i, j, map);
        	    	count++;
    			}
    		}
    	}

    	visited = new boolean[n][n];
    	for(int i = 0; i < n; i++) {
    		for(int j = 0; j < n; j++) {
    			if(!visited[i][j]) {
        	    	dfs(i, j, mapBlind);
        	    	blindCount++;
    			}
    		}
    	}
    	System.out.println(count+ " "+blindCount);
    }
    private static void dfs(int x, int y, char[][] map) {
    	visited[x][y] = true;
		char color = map[x][y];
    	for(int i = 0; i < 4; i++) {
    		int xx = x + dx[i];
    		int yy = y + dy[i];
    		if(xx < 0 || yy < 0 || xx >= n || yy >= n) continue;
    		if(!visited[xx][yy] && color == map[xx][yy]) {
    			dfs(xx, yy, map);
    		}
    	}
    }
} 