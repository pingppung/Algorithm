import java.io.*;
import java.util.*;
public class Main {
	static class Node {
		int x;
		int y;
		public Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	static int n, m, result = Integer.MAX_VALUE;
	static int[][] arr;
	static ArrayList<Node> house = new ArrayList<>();
	static ArrayList<Node> chicken = new ArrayList<>();
	static boolean[] visited;
    public static void main(String[] args) throws IOException{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());

    	n = Integer.parseInt(st.nextToken());
    	m = Integer.parseInt(st.nextToken());
    	
    	arr = new int[n][n];
    	
    	for(int i = 0; i < n; i++) {
        	st = new StringTokenizer(br.readLine());
        	for(int j = 0; j < n; j++) {
        		arr[i][j] = Integer.parseInt(st.nextToken());
        		
        		if(arr[i][j] == 1) house.add(new Node(i, j));
        		else if(arr[i][j] == 2) chicken.add(new Node(i, j));
        	}
    	}

    	visited = new boolean[chicken.size()];
    	dfs(0, 0);
    	System.out.println(result);
    } 
    public static void dfs(int start, int depth) {
    	if(depth == m) {
    		int sum = 0;
    		for(int i = 0; i < house.size(); i++) {
        		int disMin = Integer.MAX_VALUE;
            	for(int j = 0; j < chicken.size(); j++) {
            		if(visited[j]) {
            			int distance = Math.abs(house.get(i).x - chicken.get(j).x) 
            				+ Math.abs(house.get(i).y - chicken.get(j).y);
            			disMin = Math.min(disMin, distance);
            		}
            	}
            	sum += disMin;
        	}
    		result = Math.min(result, sum);
    		return;
    	}
    	for(int i = start; i < chicken.size(); i++) {
    		visited[i] = true;
    		dfs(i+1, depth+1);
    		visited[i] = false;
    	} 
    }
}
