import java.io.*;
import java.util.*;
public class Main {
	static int n, m;
	static int[] arr;
	static boolean[] visited;
	static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
 	
    	n = Integer.parseInt(st.nextToken());
    	m = Integer.parseInt(st.nextToken());
    	
    	arr = new int[m];
    	visited = new boolean[n];
    	dfs(0, 0);
    	System.out.println(sb);
    	
    }
    public static void dfs(int start, int depth) {
    	if(depth == m) {
    		for(int i : arr) sb.append(i +" ");
    		sb.append("\n");
    		return;
    	}
    	for(int i = 0; i < n; i++) {
    		if(!visited[i]) {
    			visited[i] = true;
    			arr[depth] = i+1;
    			dfs(i, depth+1);
    			visited[i] = false;
    		}
    	}
    }
}
