import java.io.*;
import java.util.*;
public class Main {
	static boolean[][] visited;
	static int[][] arr;
	static int n, result = 0;
	static int[] count;
    public static void main(String[] args) throws IOException{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st;
    	n = Integer.parseInt(br.readLine());
    	
    	arr = new int[n][n];
    	visited = new boolean[n][n];
    	count = new int[n*n];
    	for(int i = 0; i < n; i++) {
    		String[] s = br.readLine().split("");
    		for(int j = 0; j < n; j++) {
    			arr[i][j] = Integer.parseInt(s[j]);
    		}
    	}
    	
    	for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				if(arr[i][j] == 1 && visited[i][j] == false) {
					result++;
					dfs(i, j);
				}
			}
		}
    	System.out.println(result);
    	Arrays.sort(count);
    	for(int i = 0; i <count.length; i++) {
    		if(count[i] != 0) System.out.println(count[i]);
    	}
    }
	static void dfs(int x, int y){
		visited[x][y] = true;
		count[result]++;
		int[] dx = {1,-1,0,0};
		int[] dy = {0,0,1,-1};
		for(int i = 0; i < 4; i++) {
			int xx = x + dx[i];
			int yy = y + dy[i];
			if(xx >=0 && yy >=0 && xx < n && yy < n){
				if(visited[xx][yy] == false && arr[xx][yy] == 1) {
					dfs(xx,yy);
				}
			}
		}
	}
}  