import java.io.*;
import java.util.*;
public class Main {
	static int n, baby = 2, time = 0, count  =0;
	static int[][] map;
	static boolean[][] visited;
	
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	static class Point{
		int x, y, dis;
		Point(int x, int y, int dis){
			this.x = x;
			this.y = y;
			this.dis = dis;
		}
	}
	static Point shark;
	static PriorityQueue<Point> fishes = new PriorityQueue<>((p1, p2) -> {
		if (p1.dis != p2.dis) {
            return Integer.compare(p1.dis, p2.dis);
        } else if (p1.x != p2.x) {
            return Integer.compare(p1.x, p2.x);
        } else {
            return Integer.compare(p1.y, p2.y);
        }
	});
    public static void main(String[] args) throws IOException{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    	n = Integer.parseInt(br.readLine());
    	map = new int[n][n];
    	
    	
    	for(int i = 0; i < n; i++) {
    		StringTokenizer st = new StringTokenizer(br.readLine());
    		for(int j = 0; j < n; j++) {
    			map[i][j] = Integer.parseInt(st.nextToken());
    			if(map[i][j] == 9) {
    				shark = new Point(i, j, 0);
    				map[i][j] = 0;
    			}
    		}
    	}
    	
    	while(true) {
    		bfs();
        	if(fishes.isEmpty()) break;
        	eatFish();
        	count++;
        	if(baby == count) {
        		baby++;
        		count = 0;
        	}
        	fishes.clear();
    	}
    	System.out.println(time);
    }
    private static void eatFish() {
    	Point fish = fishes.poll();
    	time += fish.dis;
    	map[fish.x][fish.y] = 0;
    	shark = new Point(fish.x, fish.y, 0);
    }
    private static void bfs() {
    	Queue<Point> q = new LinkedList<>();
    	q.offer(shark);
    	visited = new boolean[n][n];
    	while(!q.isEmpty()) {
    		Point p = q.poll();
    		for(int i = 0; i < 4; i++) {
    			int xx = p.x + dx[i];
    			int yy = p.y + dy[i];
    			if(xx < 0 || yy < 0 || xx >= n || yy >= n) continue;
    			if(!visited[xx][yy]) {
	    			visited[xx][yy] = true;
    				if(map[xx][yy] == baby || map[xx][yy] == 0) {
    	    			q.offer(new Point(xx, yy, p.dis+1));
    				} else if(map[xx][yy] < baby) {
    					fishes.offer(new Point(xx, yy, p.dis+1));
    				}
    			}
    		}
    	}
    	
    }
    
}
