import java.io.*;
import java.util.*;
public class Main {
	static boolean[] visited;
	static int[] parent;
	static int n;
	static ArrayList<ArrayList<Integer>> list = new ArrayList<>();
    public static void main(String[] args) throws IOException{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st;
    	n = Integer.parseInt(br.readLine());
    	parent = new int[n+1];
    	visited = new boolean[n+1];
    	for(int i = 0; i <= n; i++) {
    		list.add(new ArrayList<>());
    	}
    	for(int i = 0; i < n-1; i++) {
    		st = new StringTokenizer(br.readLine());
    		int a = Integer.parseInt(st.nextToken());
    		int b = Integer.parseInt(st.nextToken());
    		list.get(a).add(b);
    		list.get(b).add(a);
    	}
    	dfs(1);
    	for(int i = 2; i < parent.length; i++) {
    		System.out.println(parent[i]);
    	}
    }
	static void dfs(int idx) {
		visited[idx] = true;
		for(int i : list.get(idx)) {
			if(visited[i] == false) {
				parent[i] = idx;
				dfs(i);
			}
		}
	}
}  