import java.io.*;
import java.util.*;
public class Main {
	static boolean[][] visited;
	static int[][] arr;
	static int count;
	static int m, n, k;
    public static void main(String[] args) throws IOException{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st;
    	int t = Integer.parseInt(br.readLine());
    	for(int i = 0; i < t; i++) {
    		count = 0;
        	st = new StringTokenizer(br.readLine());
        	m = Integer.parseInt(st.nextToken());
        	n = Integer.parseInt(st.nextToken());
        	k = Integer.parseInt(st.nextToken());
        	
        	arr = new int[m][n];
        	visited = new boolean[m][n];
        	
        	for(int j = 0;  j < k; j++) {
        		st = new StringTokenizer(br.readLine());
            	int x = Integer.parseInt(st.nextToken());
            	int y = Integer.parseInt(st.nextToken());
            	arr[x][y] = 1;
        	}
        	for(int q = 0; q < m; q++) {
        		for(int p = 0; p < n; p++) {
        			if(arr[q][p] == 1 && visited[q][p] == false) {
        				dfs(q, p);
        				count++;
        			}
        		}
        	}
        	System.out.println(count);
    	}
    }

	static void dfs(int x, int y) {
		visited[x][y] = true;
		int[] Xs = {0, 0, -1, +1};
        int[] Ys = {-1, +1, 0, 0};
		for(int i = 0; i < 4; i++) {
			int xx = x + Xs[i];
            int yy = y + Ys[i];
            if(xx < 0 || xx >= m || yy < 0 || yy >= n){
                continue;
            }

            if(arr[xx][yy] == 1 & !visited[xx][yy]){
                dfs(xx, yy);
            }
		}
	}
}  