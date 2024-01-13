import java.io.*;
import java.util.*;
public class Main {
	static int R, C, time = Integer.MAX_VALUE;
	static char[][] map;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	static Queue<int[]> jh = new LinkedList<>();
	static Queue<int[]> fire = new LinkedList<>();
    public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	R = Integer.parseInt(st.nextToken());
    	C = Integer.parseInt(st.nextToken());
    	
    	map = new char[R][C];
    	
    	for(int i = 0; i < R; i++) {
    		String s = br.readLine();
    		for(int j = 0; j < C; j++) {
    			map[i][j] = s.charAt(j);
        		if(map[i][j] == 'J') {
        			if(i == 0 || j == 0 || i == R-1 || j == C-1) {
						System.out.println(1);
						return;
					}
        			map[i][j] = '.';
        			jh.add(new int[] {i, j, 0});
        		} else if(map[i][j] == 'F') {
        			fire.add(new int[] {i, j});
        		}
    		}
    	}
    	bfs();
    	if(time == Integer.MAX_VALUE) System.out.println("IMPOSSIBLE");
    	else System.out.println(time);
    }
    private static void bfs() {
    	while(!jh.isEmpty()) {
    		int fire_area = fire.size();
    		for(int i = 0; i < fire_area; i++) {
    			int[] p = fire.poll();
    			for(int j = 0; j < 4; j++) {
        			int xx = p[0] + dx[j];
        			int yy = p[1] + dy[j];
        			if(xx < 0 || yy < 0 || xx >= R || yy >= C) continue;
        			if( map[xx][yy] == '#' || map[xx][yy] == 'F') continue;
        			
        			map[xx][yy] = 'F';
        			fire.add(new int[] {xx, yy});
        			
        		}
    		}
    		int jh_area = jh.size();
    		for(int i = 0; i < jh_area; i++) {
    			int[] p = jh.poll();
    			for(int j = 0; j < 4; j++) {
        			int xx = p[0] + dx[j];
        			int yy = p[1] + dy[j];
        			int count = p[2];
        			if(xx < 0 || yy < 0 || xx >= R || yy >= C) {
        				time = Math.min(time, count+1);
        				return;
        			}
        			if(map[xx][yy] == '#' || map[xx][yy] == 'F'|| map[xx][yy] == 'J') continue;
        			
        			map[xx][yy] = 'J';
        			jh.add(new int[] {xx, yy, count+1});
        			
        		}
    		}
    	}
    }
}  