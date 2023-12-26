import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringBuilder sb = new StringBuilder();
    	
    	int n = Integer.parseInt(br.readLine());
    	PriorityQueue<Integer> p = new PriorityQueue<>();
    	for(int i = 0; i < n; i++) {
    		int num = Integer.parseInt(br.readLine());
    		if(num == 0) {
    			if(p.isEmpty()) sb.append(0).append("\n");
    			else sb.append(p.poll()).append("\n");
    		}
    		else p.add(num);
    	}
    	System.out.println(sb);
    	
    }
    	
} 