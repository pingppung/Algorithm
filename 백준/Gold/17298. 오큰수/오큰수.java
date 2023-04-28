import java.io.*;
import java.util.*;
public class Main {
	static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st;
    	
    	int n = Integer.parseInt(br.readLine());
    	int[] arr = new int[n];
    	Stack<Integer> stack = new Stack<>();
    	
    	st = new StringTokenizer(br.readLine());
    	for(int i = 0; i < n; i++) {
    		arr[i] = Integer.parseInt(st.nextToken());
    	}
    	
    	for(int i = 0; i < n; i++) {
    		
    		while(!stack.isEmpty() && arr[stack.peek()] < arr[i]) {
    			arr[stack.pop()] = arr[i];
    		}
    		stack.push(i);
    	}
    	while(!stack.isEmpty()) {
    		arr[stack.pop()] = -1;
    	}
    	for(int i = 0; i < n; i++) {
    		sb.append(arr[i]).append(" ");
    	}
    	System.out.println(sb);
    }
    
}
