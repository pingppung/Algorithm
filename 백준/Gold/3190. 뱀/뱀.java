import java.io.*;
import java.util.*;
public class Main {
	static int n;
	static int[][] map;
	static int[] dx = {0, 1, 0, -1};  //동남서북
	static int[] dy = {1, 0, -1, 0};
	static Map<Integer, String> moveInfo;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		n = Integer.parseInt(br.readLine());
		map = new int[n][n];
		moveInfo = new HashMap<>();
		int k = Integer.parseInt(br.readLine());
		for(int i = 0; i < k; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken())-1;
			int y = Integer.parseInt(st.nextToken())-1;
			
			map[x][y] = 1;
		}
		int l = Integer.parseInt(br.readLine());
		for(int i = 0; i < l; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			String c = st.nextToken();
			moveInfo.put(x,  c);
		}
		System.out.println(move());
	}
	private static int move() {
		Queue<int[]> q = new LinkedList<>();
		int snake_x = 0, snake_y = 0;
		q.add(new int[] {snake_x, snake_y});
		int dir = 0; //동남서북 0123
		int time = 0;
		while(true) {
			int xx = snake_x + dx[dir];
			int yy = snake_y + dy[dir];
			
			time++;
			if(xx < 0 || yy < 0 || xx >= n || yy >= n) return time;
			
			for (int[] snake : q) {
	            if (snake[0] == xx && snake[1] == yy) return time;
	        }
			
			if(map[xx][yy] == 1) { //사과
				map[xx][yy] = 0;
				q.add(new int[]{xx, yy});
			} else {
				q.add(new int[]{xx, yy});
				q.poll();
			}
			
			if(moveInfo.containsKey(time)) {
				String next_dir = moveInfo.get(time);
				if(next_dir.equals("D")) {
					dir++;
					if(dir == 4) dir = 0;
				} else {
					dir--;
					if(dir == -1) dir = 3;
				}
			}
			snake_x = xx;
			snake_y = yy;
			
		}
	}
}
