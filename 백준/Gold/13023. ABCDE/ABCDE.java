import java.io.*;
import java.util.*;
public class Main {
	static int n, m, result = 0;
	static boolean[] visited;
	static List<List<Integer>> list = new ArrayList<>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		for(int i = 0; i < n ; i++) {
			list.add(new ArrayList<>());
		}
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			list.get(a).add(b);
			list.get(b).add(a);
		}
		for(int i = 0; i < n; i++) {
			visited = new boolean[n];
			dfs(i, 0);
		}
		System.out.println(0);
	
		
	
	}
	public static void dfs(int start, int depth) {
		visited[start] = true;
		if(depth >= 4) {
			System.out.println(1);
			System.exit(0);
		}
		for(int next : list.get(start)) {
			if(!visited[next]) {
				visited[next] = true;
				dfs(next, depth+1);
				visited[next] = false;
			}
		}
		visited[start] = false;
		return;
	}
}
