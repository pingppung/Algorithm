import java.io.*;
import java.util.*;
public class Main {
	static int[] arr;
	static boolean[] visited;
    public static void main(String[] args) throws IOException{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st;
    	int t = Integer.parseInt(br.readLine());
    	while(t-- > 0) {
    		int n = Integer.parseInt(br.readLine());
        	arr = new int[n+1];
        	
        	int cnt = 0;
        	st = new StringTokenizer(br.readLine());
    		for(int i = 1; i <= n; i++) {
    			arr[i] = Integer.parseInt(st.nextToken());
    		}
    		visited = new boolean[n+1];
    		for(int i = 1; i <= n; i++) {
    			if(!visited[i]) {
    				dfs(i);
    				cnt++;
    			}
    		}
    		System.out.println(cnt);
    	}
    }
    public static void dfs(int start) {
    	visited[start] = true;
    	int next = arr[start];
    	if(!visited[next]) dfs(next);
    }

}
