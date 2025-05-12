import java.util.*;
import java.io.*;

public class Main {
	static int V;
	static int INF = 1_000_000_000;
	static List<List<int[]>> graph = new ArrayList<>();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(br.readLine());
		
		for(int i = 0; i <= V; i++) {
			graph.add(new ArrayList<>());
		}
		for(int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			
			graph.get(u).add(new int[] {v, w});
			
		}
		int[] dist = dijkstra(K);
		for(int i = 1; i <= V; i++) {
			System.out.println(dist[i] == INF ? "INF" : dist[i]);
		}
	}
	private static int[] dijkstra(int start) {
		int[] dist = new int[V+1];
		Arrays.fill(dist, INF);
		dist[start] = 0;
		
		PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a->a[1]));
		pq.add(new int[] {start, 0});
		while(!pq.isEmpty()){
			int[] cur = pq.poll();
			int curV = cur[0];
			int curD = cur[1];
			
			if(curD > dist[curV]) continue;
			for(int[] next : graph.get(curV)) {
				int nextV = next[0];
				int nextD = next[1];
				if(dist[nextV] > dist[curV] + nextD) {
					dist[nextV] = dist[curV] + nextD;
					pq.add(new int[] {nextV, dist[nextV]});
				}
			}
		}
		return dist;
	}
}
