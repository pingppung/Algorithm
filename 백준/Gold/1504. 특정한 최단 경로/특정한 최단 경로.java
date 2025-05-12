import java.util.*;
import java.io.*;

public class Main {
	static int N;
	static int INF = 1_000_000_000;
	static List<List<int[]>> graph = new ArrayList<>();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		
		for(int i = 0; i <= N; i++) {
			graph.add(new  ArrayList<>());
		}
		for(int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			graph.get(a).add(new int[] {b, c});
			graph.get(b).add(new int[] {a, c});
			
		}
		st = new StringTokenizer(br.readLine());
		int v1 = Integer.parseInt(st.nextToken());
		int v2 = Integer.parseInt(st.nextToken());
		
		int[] all_dist = findRoute(1);
		int[] v1_dist = findRoute(v1);
		int[] v2_dist = findRoute(v2);
		
		int path1 = all_dist[v1] + v1_dist[v2] + v2_dist[N];
		int path2 = all_dist[v2] + v2_dist[v1] + v1_dist[N];
		int min_dist = Math.min(path1, path2);
		if(all_dist[N] == Integer.MAX_VALUE) {
			System.out.println(-1);
		}
		else System.out.println(min_dist);
	}
	private static int[] findRoute(int start) {
		int[] dist = new int[N+1];
		Arrays.fill(dist, Integer.MAX_VALUE);
		dist[start] = 0;
		
		PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a->a[1]));
		pq.add(new int[] {start, 0});
		while(!pq.isEmpty()) {
			int[] cur = pq.poll();
			int cur_v = cur[0];
			int cur_d = cur[1];
			
			if(dist[cur_v] > cur_d) continue;
			for(int[] next : graph.get(cur_v)) {
				int next_v = next[0];
				int next_d = next[1];
				
				if(dist[next_v] > dist[cur_v] + next_d) {
					dist[next_v] = dist[cur_v] + next_d;
					pq.add(new int[] {next_v, dist[next_v]});
				}
			}
		}
		return dist;
		
	}
}
