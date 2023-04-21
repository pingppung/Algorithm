import java.io.*;
import java.util.*;
public class Main {
	static int n, m;
	static int[] arr, result;
	static boolean[] visited;
	static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	
    	n = Integer.parseInt(st.nextToken());
    	m = Integer.parseInt(st.nextToken());
    	
    	arr = new int[n];
    	result = new int[n];
    	visited = new boolean[n];
    	
    	st = new StringTokenizer(br.readLine());
    	for(int i = 0; i < n; i++) {
    		arr[i] = Integer.parseInt(st.nextToken());
    	}
    	Arrays.sort(arr);
    	dfs(0, 0);
    	
    	System.out.println(sb);
    			
    }
    public static void dfs(int start, int depth) {
    	if(depth == m) {
    		for(int i = 0; i < m; i++) {
    			sb.append(result[i] +" ");
    		}
    		sb.append("\n");
    		return;
    	}
    	int num = -1;
    	for(int i = start; i < n; i++) {
    		if(num == arr[i] || visited[i]) continue;
    		else {
    			num = arr[i];
    			visited[i] = true;
    			result[depth] = arr[i];
    			dfs(i+1, depth+1);
    			visited[i] = false;
    		}
    	}
    }
}
