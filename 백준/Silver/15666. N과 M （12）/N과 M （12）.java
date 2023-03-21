import java.io.*;
import java.util.*;
public class Main {
	static StringBuilder sb = new StringBuilder();
	static int n, m;
	static int[] arr;
	static int[] result;
	static boolean[] visited;
    public static void main(String[] args) throws IOException{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	n = Integer.parseInt(st.nextToken());
    	m = Integer.parseInt(st.nextToken());
    	
    	arr = new int[n];
    	result = new int[m];
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
    		for(int i : result) {
    			sb.append(i+" ");
    		}
    		sb.append("\n");
    		return;
    	}
    	int num = 0;
    	for(int i = start; i < n; i++) {
    		if(num == arr[i]) continue;
    		result[depth] = arr[i];
    		num = arr[i];
    		dfs(i, depth+1);
    	}
    }
}
