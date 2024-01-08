import java.io.*;
import java.util.*;
public class Main {
	static ArrayList<ArrayList<Integer>> graph;
	static int[] area;
    public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	int K = Integer.parseInt(br.readLine());
    	while(K-- > 0) {

        	StringTokenizer st = new StringTokenizer(br.readLine());
    		int V = Integer.parseInt(st.nextToken());
    		int E = Integer.parseInt(st.nextToken());
    		graph = new ArrayList<>();
    		area = new int[V+1];
    		for(int i = 0; i <= V; i++) {
    			graph.add(new ArrayList<>());
    		}
    		for(int i = 0; i < E; i++) {
    			st = new StringTokenizer(br.readLine());
    			int u = Integer.parseInt(st.nextToken());
    			int v = Integer.parseInt(st.nextToken());
    			graph.get(u).add(v);
    			graph.get(v).add(u);
    		}
    		
    		String result = "";
    		for(int i = 1; i <= V; i++) {
    			if(area[i] == 0) {
    				result = bfs(i);
    				if(result.equals("NO")) break;
    			}
    		}
    		System.out.println(result);
    		
    	}
    		
    }
    private static String bfs(int start) {
    	Queue<Integer> q = new LinkedList<>();
    	q.offer(start);
    	area[start] = 1;
    	while(!q.isEmpty()) {
    		int num = q.poll();
    		for(int i :graph.get(num)) {
    			if(area[i] == area[num]) {
    				return "NO";
    			} else if(area[i] == 0) {
    				area[i] = area[num]  * -1;
    				q.offer(i);
    			}
    		}
    	}
    	return "YES";
    }
}  