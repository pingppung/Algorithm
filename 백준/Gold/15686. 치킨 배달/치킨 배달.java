import java.io.*;
import java.util.*;
public class Main {
	static int n, m;
	static int result = Integer.MAX_VALUE;
	static int[][] arr;
	static boolean[] visited;
	static class Node{
		int x, y;
		public Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	static ArrayList<Node> house = new ArrayList<>();
	static ArrayList<Node> chicken = new ArrayList<>();
    public static void main(String[] args) throws IOException{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	
    	n = Integer.parseInt(st.nextToken());
    	m = Integer.parseInt(st.nextToken());
    	for(int i = 1; i <= n; i++) {
    		st = new StringTokenizer(br.readLine());
    		for(int j = 1; j <= n; j++) {
    			int point = Integer.parseInt(st.nextToken());
    			if(point == 1) house.add(new Node(i, j));
    			else if(point == 2) chicken.add(new Node(i, j));
    		}
    	}

    	visited = new boolean[chicken.size()];
    	dfs(0,0);
    	System.out.println(result);
    }
    public static void dfs(int start, int depth) {
    	if(depth == m) {
    		int sum = 0;
    		for(int i = 0; i < house.size(); i++) {
				int distance_Sum = Integer.MAX_VALUE;
    			for(int j = 0; j < chicken.size(); j++) {
    				if(visited[j]) {
    					int dis = Math.abs(house.get(i).x-chicken.get(j).x)
    							+Math.abs(house.get(i).y-chicken.get(j).y);
    					distance_Sum = Math.min(distance_Sum, dis);
    				}
    				
    			}
    			sum+= distance_Sum;
    		}
    		result = Math.min(sum, result);
    		return;
    	}
    	for(int i = start; i < chicken.size(); i++) {
    		visited[i] = true;
    		dfs(i+1, depth+1);
    		visited[i] = false;
    	}
        
    }
}
