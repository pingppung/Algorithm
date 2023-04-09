import java.io.*;
import java.util.*;
public class Main {
	static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st;
    	int k = Integer.parseInt(br.readLine());
    	for(int i = 1; i <= k; i++) {
    		st = new StringTokenizer(br.readLine());
    		sb.append("Class "+ i + "\n");
    		int n = Integer.parseInt(st.nextToken());
    		
    		int[] arr = new int[n];
    		for(int j = 0; j < n; j++) {
    			arr[j] = Integer.parseInt(st.nextToken());
    		}
    		Arrays.sort(arr);
    		int gap = 0;
    		for(int j = 1; j < n; j++) {
    			gap = Math.max(gap, arr[j]- arr[j-1]);
    		}
    		sb.append("Max " + arr[arr.length -1] + ", Min " + arr[0] +", Largest gap "+ gap +"\n");
    		
    	}
    	System.out.println(sb);
    }
}
