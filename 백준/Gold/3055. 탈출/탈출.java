import java.io.*;
import java.util.*;
public class Main {
	static int r, c, result = Integer.MAX_VALUE;
	static char[][] forest;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	static Queue<int[]> dochi = new LinkedList<>();
	static Queue<int[]> water = new LinkedList<>();
    public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	r = Integer.parseInt(st.nextToken());
    	c = Integer.parseInt(st.nextToken());

    	forest = new char[r][c];
    	for(int i = 0; i < r; i++) {
    		char[] arr = br.readLine().toCharArray();
 		   	for(int j = 0; j < c; j++) {
 			   forest[i][j] = arr[j];
 			   if(forest[i][j] == '*') water.offer(new int[] {i, j});
 			   if(forest[i][j] == 'S') dochi.offer(new int[] {i, j, 0});
 		   	}
 	   	}
    	
    	while(!dochi.isEmpty()) {
    		flood();
    		move();
    	}
    	if(result == Integer.MAX_VALUE) System.out.println("KAKTUS");
    	else System.out.println(result);
    	
    }
    private static void flood() {
    	int wLen = water.size();
		for(int i = 0; i < wLen; i++) {
			int[] p = water.poll();
    		for(int j = 0; j < 4; j++) {
    			int xx = p[0] + dx[j];
    			int yy = p[1] + dy[j];
    			if(xx < 0 || yy < 0 || xx >= r || yy >= c) continue;
    			if(forest[xx][yy] == '.') {
    				forest[xx][yy] = '*';
    				water.offer(new int[] {xx, yy});
    			}
    		}
		}
   }
   
    private static void move() {
    	int dLen = dochi.size();
    	for(int i = 0; i < dLen; i++) {
    		int[] p = dochi.poll();
    		for(int j = 0; j < 4; j++) {
    			int xx = p[0] + dx[j];
    			int yy = p[1] + dy[j];
    			int count = p[2];
    			if(xx < 0 || yy < 0 || xx >= r || yy >= c) continue;
    			if(forest[xx][yy] == 'D') {
    				result = Math.min(result, count+1);
    				return;
    			}
    			if(forest[xx][yy] == '.') {
    				forest[xx][yy] = 'S';
    				dochi.offer(new int[] {xx, yy, count+1});
    			}
    		}
    	}
   }
}  