import java.io.*;
import java.util.*;
public class Main {
	static int n;
	static int[] arr, result;
	static boolean[] visited;
	static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st;
    	n = Integer.parseInt(br.readLine());
    	arr = new int[n];
    	visited = new boolean[n];
    	dfs(0);
    	System.out.println(sb);
    }
    public static void dfs(int depth) {
    	if(depth == n) {
    		for(int i = 0; i < n; i++) {
    			sb.append(arr[i] +" ");
    		}
    		sb.append("\n");
    		return;
    	}
    	for(int i = 0; i < n; i++) {
    		if(!visited[i]) {
    			arr[depth] = i+1;
    			visited[i] = true;
    			dfs(depth+1);
    			visited[i] = false;
    		}
    	}
    }
}
