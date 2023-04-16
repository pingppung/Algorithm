import java.io.*;
import java.util.*;
public class Main {
	static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st;
    	int n = Integer.parseInt(br.readLine());
    	st = new StringTokenizer(br.readLine());
    	
    	int[] arr = new int[n+1];
    	for(int i = 1; i <= n; i++) {
    		arr[i] = arr[i-1] + Integer.parseInt(st.nextToken());
    	}
    	int m = Integer.parseInt(br.readLine());
    	while(m-- > 0) {
    		st = new StringTokenizer(br.readLine());
    		int i = Integer.parseInt(st.nextToken());
    		int j = Integer.parseInt(st.nextToken());
    		int sum = arr[j] - arr[i-1];
    		sb.append(sum+"\n");
    	}
    	System.out.println(sb);
    }
}
