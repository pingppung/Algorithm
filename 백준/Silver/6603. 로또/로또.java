import java.io.*;
import java.util.*;
public class Main {
	static StringBuilder sb;
	static int k;
	static int[] arr;
	static int[] result;
	static boolean[] check;
    public static void main(String[] args) throws IOException{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    	while(true) {

    		StringTokenizer st = new StringTokenizer(br.readLine());
    		k = Integer.parseInt(st.nextToken());
    		if(k == 0) break;
    		
    		arr = new int[k];
    		check = new boolean[k];
    		
    		for(int i = 0; i < k; i++) {
    			arr[i] = Integer.parseInt(st.nextToken());
    		}
    		
    		sb = new StringBuilder();
    		dfs(0,0);
    		System.out.println(sb);
    	}
    } 
    public static void dfs(int start, int depth) {
    	if(depth == 6) {
    		for(int i = 0; i < k; i++) {
    			if(check[i])
    				sb.append(arr[i]+" ");
    		}
    		sb.append("\n");
    	}
    	for(int i = start; i < k; i++) {
    		check[i] = true;
    		dfs(i+1, depth+1);
    		check[i] = false;
    	}
    }
}
