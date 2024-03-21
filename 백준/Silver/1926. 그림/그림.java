import java.io.*;
import java.util.*;
public class Main {
	static boolean[][] visited;
	static int[][] arr;
	static int n, m;
	static int count, area = 0;
    public static void main(String[] args) throws IOException{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	n = Integer.parseInt(st.nextToken());
    	m = Integer.parseInt(st.nextToken());
    	arr = new int[n][m];
    	visited = new boolean[n][m];
    	
    	for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
    		for(int j = 0; j < m; j++) {
    			arr[i][j] = Integer.parseInt(st.nextToken());
    		}
    	}
    	
    	int c = 0;
    	for(int i = 0; i < n; i++) {
    		for(int j = 0; j < m; j++) {
    			if(!visited[i][j] && arr[i][j] ==1) {
    				c++;
    				count = 0;
    				dfs(i, j);
    				area = Math.max(area, count);
    			}
    		}
    	}
    	System.out.println(c);
    	System.out.println(area);
    }
	static void dfs(int x, int y){
		visited[x][y] = true;
		count++;
		int[] dx = {-1, 1, 0, 0};
		int[] dy = {0, 0, -1, 1};
		for(int i = 0; i < 4; i++) {
			int xx = x + dx[i];
			int yy = y + dy[i];
			
			if(xx >= 0 && yy >= 0 && xx < n && yy < m) {
				if(!visited[xx][yy] && arr[xx][yy] == 1) {
					visited[xx][yy] = true;
					dfs(xx, yy);
				}
			}
		}
	
	}
		
}  