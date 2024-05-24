import java.io.*;
import java.util.*;
public class Main {
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	static int m, n, result;
	static Queue<int[]> q = new LinkedList<>();
    public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	m = Integer.parseInt(st.nextToken());
    	n = Integer.parseInt(st.nextToken());
    	int[][] box = new int[n][m];
    	for(int i = 0; i < n; i++) {
    		st = new StringTokenizer(br.readLine());
    		for(int j = 0; j < m; j++) {
    			box[i][j] = Integer.parseInt(st.nextToken());
    			if(box[i][j] == 1) q.offer(new int[] {i, j, 0});
    		}
    	}
    	bfs(box);
    	for(int i = 0; i < n; i++) {
    		for(int j = 0; j < m; j++) {
    			if(box[i][j] == 0) {
    				System.out.println(-1);
    				return;
    			}
    		}
    	}
    	System.out.println(result);
    }
    private static void bfs(int[][] box) {
    	while(!q.isEmpty()) {
    		int[] now = q.poll();
    		int date = now[2] + 1;
    		for(int i = 0; i < 4; i++) {
    			int xx = now[0] + dx[i];
        		int yy = now[1] + dy[i];
        		if(xx < 0 || yy < 0 || xx >= n || yy >= m) continue;
        		if(box[xx][yy] == 0) {
        			box[xx][yy] = 1;
        			q.offer(new int[] {xx, yy, date});
        			result = date;
        		}
        	}
    	}
    }
}