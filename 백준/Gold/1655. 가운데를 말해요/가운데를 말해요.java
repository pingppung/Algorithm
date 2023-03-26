import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringBuilder sb = new StringBuilder();
    	
    	int n = Integer.parseInt(br.readLine());
    	PriorityQueue<Integer> min  = new PriorityQueue<>();
    	PriorityQueue<Integer> max  = new PriorityQueue<>(Comparator.reverseOrder());
    	
    	
    	for(int i = 0; i < n; i++) {
    		int num = Integer.parseInt(br.readLine());
    		if(i%2 == 0) max.offer(num);
    		else min.offer(num);
    		
    		if(!min.isEmpty() && !max.isEmpty()) {
    			if(min.peek() < max.peek()) {
    				int tmp = min.poll();
    				min.offer(max.poll());
    				max.offer(tmp);
    			}
    		}
        	sb.append(max.peek()+"\n");
    	}
    	System.out.println(sb);
    } 	
}
