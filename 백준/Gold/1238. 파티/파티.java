import java.util.*;
import java.io.*;

public class Main {
	static int N, X, min_time = Integer.MAX_VALUE, max_time = 0;
	static List<List<int[]>> roads = new ArrayList<>();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		
		for(int i = 0; i <= N; i++) {
			roads.add(new ArrayList<>());
		}
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int time = Integer.parseInt(st.nextToken());
			
			roads.get(start).add(new int[] {end, time});
		}
		
		int[] timeToHome = calcTime(X); //집 갈때
		
		for(int i = 1; i <= N; i++) {
			if(i == X) continue;
			int[] timeToParty = calcTime(i); //파티 갈때
			int rountTime = timeToHome[i] + timeToParty[X];
			max_time = Math.max(rountTime, max_time);
		}
		System.out.println(max_time);
		
	}

	private static int[] calcTime(int start) {
		int[] dist = new int[N + 1];
		Arrays.fill(dist, Integer.MAX_VALUE);
		dist[start] = 0;
		
		PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
		pq.add(new int[] {start, 0});
		
		while(!pq.isEmpty()) {
			int[] cur = pq.poll();
			int node = cur[0];
			int time = cur[1];
			
			if(dist[node] < time) continue;
			for(int[] next : roads.get(node)) {
				int nextNode = next[0];
				int nextTime = next[1];
				
				if(dist[nextNode] > dist[node] + nextTime) {
					dist[nextNode] = dist[node] + nextTime;
					pq.add(new int[] {nextNode, dist[nextNode]});
				}
			}
		}
		return dist;
		
	}
}
