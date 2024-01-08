import java.io.*;
import java.util.*;
public class Main {
	static int N, L, R, count = 0;
	static int[][] countries;
	static boolean[][] visited;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	static class Point {
		int x, y;
		Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	static ArrayList<Point> list;
    public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	N = Integer.parseInt(st.nextToken());
    	L = Integer.parseInt(st.nextToken());
    	R = Integer.parseInt(st.nextToken());
    	countries = new int[N][N];
    	
    	for(int i = 0; i < N; i++) {
    		st = new StringTokenizer(br.readLine());
    		for(int j = 0; j < N; j++) {
    			countries[i][j] = Integer.parseInt(st.nextToken());
    		}
    	}
    	while(true) {
    		boolean moveChk = false;
    		visited = new boolean[N][N];
    		for(int i = 0; i < N; i++) {
    			for(int j = 0; j < N; j++) {
    				if(!visited[i][j]) {
    					int sum = bfs(i, j);
    					if(list.size() > 1) {
    						move(sum);
    						moveChk = true;
    					}
    				}
    			}
    		}
    		if(!moveChk) {
    			System.out.println(count);
    			return;
    		} 
    		count++;
    	}
    		
    }
    private static int bfs(int x, int y) {
    	Queue<Point> q = new LinkedList<>();
    	q.offer(new Point(x, y));
    	list = new ArrayList<>();
    	list.add(new Point(x, y));
    	visited[x][y] = true;
    	
    	int sum = countries[x][y];
    	while(!q.isEmpty()) {
    		Point p = q.poll();
    		for(int i = 0; i < 4; i++) {
    			int xx = p.x + dx[i];
    			int yy = p.y + dy[i];
    			if(xx < 0 || yy < 0 || xx >= N || yy >= N) continue;
    			int diff = Math.abs(countries[p.x][p.y] - countries[xx][yy]);
    			if(!visited[xx][yy] && diff >= L && diff <= R) {
    				visited[xx][yy] = true;
    				q.offer(new Point(xx, yy));
    				list.add(new Point(xx, yy));
    				sum += countries[xx][yy];
    			}
    		}
    	}
    	return sum;
    }
    
    private static void move(int sum) {
    	int avg = sum / list.size();
    	for(Point p : list) {
    		countries[p.x][p.y] = avg;
    	}
    }
}  