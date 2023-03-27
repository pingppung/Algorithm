import java.io.*;
import java.util.*;
public class Main {
	static int n, X = 0, O = 0;
	static char[][] arr;
	static boolean[][] visited;
    public static void main(String[] args) throws IOException{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    	n = Integer.parseInt(br.readLine());
    	
    	arr = new char[n][n];
    	
    	
    	for(int i = 0; i < n; i++) {
    		String s = br.readLine();
    		for(int j = 0; j < n; j++) {
    			char color = s.charAt(j);
    			arr[i][j] = color;
    		}
    	}

    	visited = new boolean[n][n];
    	for(int i = 0; i < n; i++) {
    		for(int j = 0; j < n; j++) {
    			if(!visited[i][j]) {
    		    	X++;
    		    	dfs(i,j);
    			}
    		}
    	}

    	for(int i = 0; i < n; i++) {
    		for(int j = 0; j  < n; j++) {
    			if(arr[i][j] == 'G') 
    				arr[i][j] = 'R';
    		}
    	}
    	visited = new boolean[n][n];
    	for(int i = 0; i < n; i++) {
    		for(int j = 0; j < n; j++) {
    			if(!visited[i][j]) {
    		    	O++;
    		    	dfs(i,j);
    			}
    		}
    	}
    	System.out.println(X + " "+ O);
    	
    } 	
    public static void dfs(int x, int y) {
    	visited[x][y] = true;
    	int []dx= {-1,1,0,0};
    	int []dy= {0,0,-1,1};
    	
    	for(int i = 0; i < 4; i++) {
    		int xx = dx[i] + x;
    		int yy = dy[i] + y;
    		if (xx<0 || yy<0 || xx>=n || yy>=n) continue;
    		if(!visited[xx][yy] && arr[x][y] == arr[xx][yy]) {
    			dfs(xx,yy);
    		}
    		
    	}
    }
}
