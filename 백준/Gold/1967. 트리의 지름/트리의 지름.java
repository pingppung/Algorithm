import java.util.*;
import java.io.*;

public class Main {
	static int n, max_W = 0, maxNode = 0;
	static List<List<int[]>> tree = new ArrayList<>();
	static boolean[] visited;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		
		for(int i = 0; i <= n; i++) {
			tree.add(new ArrayList<>());
		}
		
		for(int i = 1; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int parent = Integer.parseInt(st.nextToken());
			int child = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			tree.get(parent).add(new int[] {child, weight});
			tree.get(child).add(new int[] {parent, weight});
		}
		
		visited = new boolean[n+1];
		calDis(1, 0);
		
		visited = new boolean[n+1];
		max_W = 0;
		calDis(maxNode, 0);
		
		System.out.println(max_W);
	}
	private static void calDis(int node, int w) {
		visited[node] = true;
		if(w > max_W) {
			max_W = w;
			maxNode = node;
		}
		
		for(int[] next : tree.get(node)) {
			int nextNode = next[0];
			int weight = next[1];
			
			if(!visited[nextNode]) {
				calDis(nextNode, w + weight);
			}
		}
	}
}
