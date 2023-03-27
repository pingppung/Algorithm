import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st;
    	StringBuilder sb = new StringBuilder();
    	
    	while(true) {
    		int[] arr = new int[3];
    		st = new StringTokenizer(br.readLine());
    		for(int i = 0; i < 3; i++) {
    			arr[i] = Integer.parseInt(st.nextToken());
    		}
    		if(arr[0] == 0 && arr[1] == 0 && arr[2] == 0) {
    			break;
    		}
    		Arrays.sort(arr);
    		int a = arr[0];
    		int b = arr[1];
    		int c = arr[2];
    		
    		if(arr[2] < (arr[0] + arr[1])) {
    			if(a == b && b == c) sb.append("Equilateral\n");
    			else if(a != b && b != c && c != a) sb.append("Scalene\n");
    			else sb.append("Isosceles\n");
    			
    		} else {
    			sb.append("Invalid\n");
    		}
    		
    	}
    	System.out.println(sb);
    	
    }
   
}
