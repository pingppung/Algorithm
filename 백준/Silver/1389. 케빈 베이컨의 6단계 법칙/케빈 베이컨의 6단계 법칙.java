import java.io.*;
import java.util.*;
public class Main {
	static boolean[] visited;
	static int[][] arr;
	static int n, m, result;
	static int min = Integer.MAX_VALUE;
	static class Node{
		int x;
		int y;
		public Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	static Queue<Node> q = new LinkedList<>();
    public static void main(String[] args) throws IOException{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	n = Integer.parseInt(st.nextToken());
    	m = Integer.parseInt(st.nextToken());
    	
    	arr = new int[n+1][n+1];
    	for(int i = 0; i < m; i++) {
    		st = new StringTokenizer(br.readLine());
    		int x = Integer.parseInt(st.nextToken());
    		int y = Integer.parseInt(st.nextToken());
    		arr[y][x] = arr[x][y] = 1;
    	}
    	for(int i = 1; i <= n; i++) {
        	visited = new boolean[n+1];
    		bfs(i);
    	}
    	System.out.println(result);
    	
    }
	static void bfs(int start){
		int count = 0;
		visited[start] = true;
		q.add(new Node(start, 0));
		while(!q.isEmpty()) {
			Node node = q.poll();
			count += node.y;
			for(int i = 1; i <= n; i++) {
				if(arr[node.x][i] == 1 && !visited[i]) {
					visited[i] = true;
					q.add(new Node(i, node.y+1));
				}
			}
		}
		if(min > count) {
			min = count;
			result = start;
		}
	}
}  