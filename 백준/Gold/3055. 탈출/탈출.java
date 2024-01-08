import java.io.*;
import java.util.*;
public class Main {
	static int R, C, time = Integer.MAX_VALUE;
	static char[][] map;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	static Queue<int[]> dochi = new LinkedList<>();
	static Queue<int[]> water = new LinkedList<>();
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
        		if(map[i][j] == 'S') {
        			dochi.add(new int[] {i, j, 0});
        		} else if(map[i][j] == '*') {
        			water.add(new int[] {i, j});
        		}
        		
        	}
    	}
    	bfs();
    	if(time == Integer.MAX_VALUE) System.out.println("KAKTUS");
    	else System.out.println(time);
    	
    }
    private static void bfs() {
    	while(!dochi.isEmpty()) {
    		int wLen = water.size();
    		for(int i = 0; i < wLen; i++) {
    			int[] p = water.poll();
        		for(int j = 0; j < 4; j++) {
        			int xx = p[0] + dx[j];
        			int yy = p[1] + dy[j];
        			if(xx < 0 || yy < 0 || xx >= R || yy >= C) continue;
        			if(map[xx][yy] == '.') {
        				map[xx][yy] = '*';
        				water.offer(new int[] {xx, yy});
        			}
        		}
    		}
    		int dLen = dochi.size();
        	for(int i = 0; i < dLen; i++) {
        		int[] p = dochi.poll();
        		for(int j = 0; j < 4; j++) {
        			int xx = p[0] + dx[j];
        			int yy = p[1] + dy[j];
        			int count = p[2];
        			if(xx < 0 || yy < 0 || xx >= R || yy >= C) continue;
        			if(map[xx][yy] == 'D') {
        				time = Math.min(time, count+1);
        				return;
        			}
        			if(map[xx][yy] == '.') {
        				map[xx][yy] = 'S';
        				dochi.offer(new int[] {xx, yy, count+1});
        			}
        		}
        	}
    	}
    }
}  