import java.io.*;
import java.util.*;
public class Main {
	static int n, m;
	static int[][] tree;
	static boolean[] visited;
	static class Node {
		int end, dis;
		public Node(int end, int dis) {
			this.end = end;
			this.dis = dis;
		}
	}
	static List<List<Node>> list = new ArrayList<>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		visited = new boolean[n+1];
		for (int i = 0; i <= n; i++) {
			list.add(new ArrayList<Node>());
		}
		for(int i = 0; i < n-1; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int dis = Integer.parseInt(st.nextToken());
			list.get(a).add(new Node(b, dis));
			list.get(b).add(new Node(a, dis));
		}
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int d1 = Integer.parseInt(st.nextToken());
			int d2 = Integer.parseInt(st.nextToken());
			visited[d1] = true;
			dfs(d1, d2, 0);
			visited[d1] = false;
		}
		
	}
	public static void dfs(int start, int end, int dis) {
		if(start == end) {
			System.out.println(dis);
			return;
		}
		for(int i = 0; i < list.get(start).size(); i++) {
			int next = list.get(start).get(i).end;
			int value = list.get(start).get(i).dis;
			if(!visited[next]) {
				visited[next] = true;
				dfs(next, end, dis+value);
				visited[next] = false;
			}
		}
		
	}
	
}


