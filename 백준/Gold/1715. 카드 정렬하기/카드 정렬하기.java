import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    	int n = Integer.parseInt(br.readLine());
    	PriorityQueue<Long> pq = new PriorityQueue<Long>();
    	for(int i = 0 ; i < n; i++) {
    		pq.add(Long.parseLong(br.readLine()));
    	}
    	
    	int result = 0;
		while (pq.size() > 1) {
			long num1 = pq.poll();
			long num2 = pq.poll();
			result += num1 + num2;
			pq.add(num1 + num2); 
		}
    	System.out.println(result);
    	
    	
    }
	
}
