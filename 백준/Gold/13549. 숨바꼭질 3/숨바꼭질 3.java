import java.io.*;
import java.util.*;
public class Main {
	static int n, k, min = Integer.MAX_VALUE;
	static int max = 100000;
	static boolean[] visited = new boolean[max + 1];
	static class Node {
		int x, time;
		Node(int x, int time){
			this.x = x;
			this.time = time;
		}
	}
    public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	n = Integer.parseInt(st.nextToken());
    	k = Integer.parseInt(st.nextToken());
    	
    	bfs();
    	System.out.println(min);
    		
    }
    private static void bfs() {
    	Queue<Node> q = new LinkedList<>();
    	q.add(new Node(n, 0));
    	while(!q.isEmpty()) {
    		Node node = q.poll();
    		visited[node.x] = true;
    		if(node.x == k) min = Math.min(min, node.time);
    		if(node.x * 2 <= max && !visited[node.x * 2])  q.add(new Node(node.x * 2 , node.time));
    		if(node.x + 1 <= max && !visited[node.x + 1])  q.add(new Node(node.x + 1 , node.time+1));
    		if(node.x - 1 >= 0 && !visited[node.x - 1])  q.add(new Node(node.x - 1 , node.time+1));
    	}
    	
    }
}  