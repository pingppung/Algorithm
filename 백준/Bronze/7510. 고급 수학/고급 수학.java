import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st;
        StringBuilder sb = new StringBuilder();
    	
    	int n = Integer.parseInt(br.readLine());
    	for(int i = 0; i < n; i++) {
    		int[] arr = new int[3];
    		st = new StringTokenizer(br.readLine());
    		for(int j = 0; j < 3; j++) {
        		arr[j] = Integer.parseInt(st.nextToken());
    		}
    		Arrays.sort(arr);

			sb.append("Scenario #"+(i+1)+":\n");
    		if((Math.pow(arr[0], 2) + Math.pow(arr[1], 2)) == (Math.pow(arr[2], 2))){
    			sb.append("yes\n");
    		}
    		else sb.append("no\n");
    		sb.append("\n");
    	}
    	System.out.println(sb);
    	
    }
   
}
