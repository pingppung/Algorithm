import java.io.*;
import java.util.*;
public class Main {
	static int n;
	static class Point{
		int x, y;
		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	static ArrayList<Point> list;
	static List<List<Integer>> move;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(br.readLine());
		
		while(t-- > 0) {
			n = Integer.parseInt(br.readLine());
			list = new ArrayList<>();
			for(int i = 0; i < n+2; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				
				list.add(new Point(x, y));
			}
			move = new ArrayList<>();
			for(int i = 0; i < n+2; i++) {
				move.add(new ArrayList<>());
			}
			for(int i = 0; i < n+2; i++) {
				for(int j = i+1; j < n+2; j++) {
					int diff = Math.abs(list.get(i).x - list.get(j).x)
							+ Math.abs(list.get(i).y - list.get(j).y);
					if(diff <= 1000) { //맥주 20캔으로 갈 수 있는 최대거리
						move.get(i).add(j);
						move.get(j).add(i);
					}
				}
			}
			if(bfs()) System.out.println("happy");
			else System.out.println("sad");
			
		}
		
	
	}
	public static boolean bfs() {
		Queue<Integer> q = new LinkedList<>();
		boolean[] visited = new boolean[n+2];
		q.offer(0);
		while(!q.isEmpty()) {
			int now = q.poll();
			if(now == n+1) { // 페스티벌에 도착할 경우
				return true;
			}
			for(int i = 0; i < move.get(now).size(); i++) { //시작점에서 맥주 20병으로 갈 수 있는 장소
				if(!visited[move.get(now).get(i)]) { 
					visited[move.get(now).get(i)] = true;
					q.offer(move.get(now).get(i));
				}
			}
		}
		return false;
	}
}
