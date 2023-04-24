import java.io.*;
import java.util.*;
public class Main {
	static int n, m, r;
	static ArrayList<ArrayList<Integer>> list = new ArrayList<>();
	static int[] visited;
    public static void main(String[] args) throws IOException{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	
    	n = Integer.parseInt(st.nextToken());
    	m = Integer.parseInt(st.nextToken());
    	r = Integer.parseInt(st.nextToken());
    	
    	visited = new int[n+1];
    	for(int i = 0; i <= n; i++) {
    		list.add(new ArrayList<>());
    	}
    	for(int i = 0; i < m; i++) {
        	st = new StringTokenizer(br.readLine());
    		int u = Integer.parseInt(st.nextToken());
    		int v = Integer.parseInt(st.nextToken());
    		
    		list.get(u).add(v);
    		list.get(v).add(u);
    	}
    	for(int i = 1; i<= n; i++)
            Collections.sort(list.get(i));
    	bfs(r);
    	for(int i = 1; i <= n; i++) {
    		System.out.println(visited[i]);
    	}
    			
    }
    public static void  bfs(int start) {

    	Queue<Integer> q = new LinkedList<>();
    	q.offer(start);
    	int count = 1;
    	visited[start] = count++;
    	
    	while(!q.isEmpty()) {
    		int num = q.poll();
    		for(int i = 0;  i < list.get(num).size(); i++) {
    			int nextV = list.get(num).get(i);
    			if(visited[nextV] != 0) continue;
    			q.offer(nextV);
    			visited[nextV] = count++;
    			
    		}
    	}
    }
}
