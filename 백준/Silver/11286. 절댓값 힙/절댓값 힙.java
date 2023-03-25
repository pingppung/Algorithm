import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringBuilder sb = new StringBuilder();
    	
    	int n = Integer.parseInt(br.readLine());
    	PriorityQueue<Integer> pq  = new PriorityQueue<>(new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				// TODO Auto-generated method stub
				if(Math.abs(o1) > Math.abs(o2))
					return Math.abs(o1) - Math.abs(o2);
				else if(Math.abs(o1) == Math.abs(o2))
					return o1 - o2;
				return -1;
			}
    		
    	});
    	
    	for(int i = 0; i < n; i++) {
    		int num = Integer.parseInt(br.readLine());
    		if(num == 0) {
        		if(pq.isEmpty()) sb.append("0\n");
        		else sb.append(pq.poll()+"\n");
    		} else{
    			pq.add(num);
    		}
    		
    	}
    	System.out.println(sb);
    } 	
}
