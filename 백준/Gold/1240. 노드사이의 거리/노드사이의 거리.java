import java.io.*;
import java.util.*;
public class Main {
	private static class Node {
		int end, dist;
		public Node(int end, int dist) {
			this.end = end;
			this.dist = dist;
		}
	}

	private static boolean[] visited;
	private static List<List<Node>> list = new ArrayList<>();
    public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	int n = Integer.parseInt(st.nextToken());
    	int m = Integer.parseInt(st.nextToken());
    	
    	for(int i = 0; i <= n; i++) {
    		list.add(new ArrayList<>());
    	}
    	for(int i = 1; i < n; i++) {
    		st = new StringTokenizer(br.readLine());
    		int a = Integer.parseInt(st.nextToken());
    		int b = Integer.parseInt(st.nextToken());
    		int dist = Integer.parseInt(st.nextToken());
    		list.get(a).add(new Node(b, dist));
    		list.get(b).add(new Node(a, dist));
    	}
    	visited = new boolean[n+1];
    	for(int i = 1; i <= m; i++) {
    		st = new StringTokenizer(br.readLine());
    		int e1 = Integer.parseInt(st.nextToken());
    		int e2 = Integer.parseInt(st.nextToken());
    		visited[e1] = true;
    		calDist(e1, e2, 0);
    		visited[e1] = false;
    	}
    }
    private static void calDist(int cur, int end, int dist) {
    	if(cur == end) {
    		System.out.println(dist);
    		return;
    	}
    	for(int i = 0; i < list.get(cur).size(); i++) {
        	int next = list.get(cur).get(i).end;
        	int val = list.get(cur).get(i).dist;
        	if(!visited[next]) {
        		visited[next] = true;
        		calDist(next, end, dist+val);
        		visited[next] = false;
        	}
        }
    }
}

