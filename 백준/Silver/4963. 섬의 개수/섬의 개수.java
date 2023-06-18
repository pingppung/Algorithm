import java.io.*;
import java.util.*;
public class Main {
	static boolean[][] visited;
	static int[][] arr;
	static int count;
	static int w, h;
    public static void main(String[] args) throws IOException{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st;
    	while(true) {
    		st = new StringTokenizer(br.readLine());
    		w = Integer.parseInt(st.nextToken());
    		h = Integer.parseInt(st.nextToken());
    		if(w == 0 && h == 0) break;
    		arr = new int[h][w];
    		visited = new boolean[h][w];
    		for(int i = 0; i<h; i++) {
    			st = new StringTokenizer(br.readLine());
    			for(int j = 0; j <w; j++) {
    				arr[i][j] = Integer.parseInt(st.nextToken());
    			}
    		}
    		count = 0;
    		for(int i = 0; i<h; i++) {
    			for(int j = 0; j <w; j++) {
    				if(arr[i][j] == 1 && visited[i][j] == false) {
    					dfs(i, j);
    					count++;
    				}
    			}
    		}
    		System.out.println(count);
    	}
    }

	static void dfs(int x, int y) {
		visited[x][y] = true;
		int[] Xs = {-1,1,0,0,1,-1,1,-1};
        int[] Ys = {0,0,-1,1,1,-1,-1,1};
		for(int i = 0; i < 8; i++) {
			int xx = x + Xs[i];
            int yy = y + Ys[i];
            if(xx >=  0 && yy >=0 && xx < h && yy < w){
                if(arr[xx][yy] == 1 && !visited[xx][yy]){
                    dfs(xx, yy);
                }
                
            }
		}
	}
}  