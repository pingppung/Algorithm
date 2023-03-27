import java.io.*;
import java.util.*;
public class Main {
	static int R,C;
	static int[][] arr;
	static boolean[] visited;
	static int result = 0;
    public static void main(String[] args) throws IOException{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	StringBuilder sb = new StringBuilder();
    	
    	
    	R = Integer.parseInt(st.nextToken());
    	C = Integer.parseInt(st.nextToken());
    	
    	arr = new int[R][C];
    	visited = new boolean[26];
    	for(int i = 0; i < R; i++) {
    		String s = br.readLine();
    		for(int j = 0; j < C; j++) {
    			char alph = s.charAt(j);
    			arr[i][j] = alph -'A';
    		}
    	}

		dfs(0,0,0);
    	System.out.println(result);
    	
    } 	
    public static void dfs(int x, int y, int cnt) {
    	if(visited[arr[x][y]]) {
        	result = Math.max(result, cnt);
    		return;
    	}else {
	    	visited[arr[x][y]] = true;
	    	int[] dx = {-1, 1, 0, 0};
	    	int[] dy = {0, 0, -1, 1};
	    	
	    	for(int i = 0; i < 4; i++) {
	    		int xx = dx[i] + x;
	    		int yy = dy[i] + y;
	    		
	    		if(xx >= 0 && yy >=0 && xx < R && yy <C) {
	    			dfs(xx,yy ,cnt+1);
	    			
	    		}
	    	}
			visited[arr[x][y]] = false;
    	}
    }
}
