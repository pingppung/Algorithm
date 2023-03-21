import java.io.*;
import java.util.*;
public class Main {
	static StringBuilder sb = new StringBuilder();
	static int n, m;
	static int[] arr;
	static boolean[] visited;
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
    		for(int i : arr) {
    			sb.append(i+" ");
    		}
    		sb.append("\n");
    		return;
    	}
    	for(int i = start; i < n; i++) {
    		arr[depth] = i+1;
    		dfs(i, depth+1);
    	}
    }
}
