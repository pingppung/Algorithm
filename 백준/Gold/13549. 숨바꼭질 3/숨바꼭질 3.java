import java.io.*;
import java.util.*;
public class Main {
	static class Node{
		int x, time;
		Node(int x, int time){
			this.x = x;
			this.time = time;
		}
	} 
	static int n, k, min = Integer.MAX_VALUE;
	static boolean[] visited = new boolean[100001];
    public static void main(String[] args) throws IOException{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	
    	n = Integer.parseInt(st.nextToken());
    	k = Integer.parseInt(st.nextToken());
    	bfs();
    	System.out.println(min);
    }
    public static void bfs() {
    	Queue<Node> q = new LinkedList<>();
    	q.offer(new Node(n, 0));
    	while(!q.isEmpty()) {
    		Node nd = q.poll();
        	visited[nd.x] = true;
    		if(nd.x == k) min = Math.min(min, nd.time);
    		
    		if(nd.x*2 <= 100000 && !visited[nd.x*2]) 
    			q.offer(new Node(nd.x*2, nd.time));
    		if(nd.x+1 <= 100000 && !visited[nd.x+1]) 
    			q.offer(new Node(nd.x+1, nd.time+1));
    		if(nd.x-1 >= 0 && !visited[nd.x-1]) 
    			q.offer(new Node(nd.x-1, nd.time+1));
    	}
    }
}
