import java.io.*;
import java.util.*;
public class Main {
	static int n, m, maxP = 0;
	static int[][] paper;
	static boolean[][] visited;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
    public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	n = Integer.parseInt(st.nextToken());
    	m = Integer.parseInt(st.nextToken());

    	paper = new int[n][m];
    	visited = new boolean[n][m];
    	for(int i = 0; i < n; i++) {
    		String[] arr = br.readLine().split(" ");
 		   	for(int j = 0; j < m; j++) {
 			   paper[i][j] = Integer.parseInt(arr[j]);
 		   	}
 	   	}
    	
    	int count = 0;
    	for(int i = 0; i < n; i++) {
 		   	for(int j = 0; j < m; j++) {
 		   		if(!visited[i][j] && paper[i][j] == 1) {
 		   			int area = picture(i, j, 0);
 		   			count++;
 		   			maxP = Math.max(maxP, area);
 		   		}
 		   	}
 	   	}
    	System.out.println(count);
    	System.out.println(maxP);
    }
    private static int picture(int x, int y, int size) {
    	visited[x][y] = true;
		int area = size + 1;
    	for(int i = 0; i < 4; i++) {
    		int xx = x + dx[i];
    		int yy = y + dy[i];
    		if(xx < 0 || yy < 0 || xx >= n || yy >= m) continue;
    		if(!visited[xx][yy] && paper[xx][yy] == 1) {
    			area = picture(xx, yy, area);
    			visited[xx][yy] = true;
    		}
    	}
    	return area;
    }
   
}  