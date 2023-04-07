import java.io.*;
import java.util.*;
public class Main {
	static int n, m;
	static int[][] arr;
	static int[][] dp;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
    public static void main(String[] args) throws IOException{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());

    	m = Integer.parseInt(st.nextToken());
    	n = Integer.parseInt(st.nextToken());
    	
    	arr = new int[m+1][n+1];
    	dp = new int[m+1][n+1];
    	
    	for(int i = 1; i <= m; i++) {
    		st = new StringTokenizer(br.readLine());
    		for(int j = 1; j <= n; j++) {
    			arr[i][j] = Integer.parseInt(st.nextToken());
    			dp[i][j] = -1;
    		}
    	}
    	System.out.println(dfs(1, 1));
    	
    }
    public static int dfs(int x, int y) {
    	if(x == m && y == n) return 1;
    	if(dp[x][y] != -1) {
    		return dp[x][y];
    	} else {
    		dp[x][y] = 0;
    		for(int i = 0; i < 4; i++) {
    			int xx = x + dx[i];
    			int yy = y + dy[i];
    			if(xx < 1 || yy < 1 || xx > m || yy > n) continue;
    			if(arr[x][y] > arr[xx][yy]) {
    				dp[x][y] += dfs(xx, yy);
    			}
    		}
    	}
    	return dp[x][y];
    }
}
