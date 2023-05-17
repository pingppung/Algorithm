import java.io.*;
import java.util.*;
public class Main {
	static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
	static int[] visited;
	static int n, m, k, x;
    public static void main(String[] args) throws IOException{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	
    	n = Integer.parseInt(st.nextToken());
    	m = Integer.parseInt(st.nextToken());
    	k = Integer.parseInt(st.nextToken());
    	x = Integer.parseInt(st.nextToken());
    	
    	visited = new int[n+1];
    	for(int i = 0; i <= n; i++) {
    		graph.add(new ArrayList<>());
    		visited[i] = -1;
    	}
    	for(int i = 0; i < m; i++) {
    		st = new StringTokenizer(br.readLine());
    		int a = Integer.parseInt(st.nextToken());
    		int b = Integer.parseInt(st.nextToken());
    		graph.get(a).add(b);
    	}
    	bfs(x);
    	boolean chk = false;
    	for(int i = 1; i <= n; i++) {
    		if(visited[i]==k) {
    			System.out.println(i);
    			chk = true;
    		}
    	}
    	if(!chk) System.out.println(-1);
    	
    }
    static void bfs(int start) {
    	Queue<Integer> q = new LinkedList<>();
    	visited[start] = 0;
    	q.offer(start);
    	while(!q.isEmpty()) {
    		int now = q.poll();
    		for(int i : graph.get(now)) {
    			if(visited[i] == -1) {
    				visited[i] = visited[now]+1;
    				q.offer(i);
    			}
    		}
    	}
    }
}
