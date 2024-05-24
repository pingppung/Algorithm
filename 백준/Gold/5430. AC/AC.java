import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	int T = Integer.parseInt(br.readLine());
    	while(T-- > 0) {
    		char[] command = br.readLine().toCharArray();
    		int n = Integer.parseInt(br.readLine());
    		StringTokenizer st = new StringTokenizer(br.readLine(),"[],");
    		ArrayDeque<Integer> q = new ArrayDeque<Integer>();
    		for(int i = 0; i < n; i++) {
    			q.add(Integer.parseInt(st.nextToken()));
    		}
    		
    		boolean[] result = AC(command, q, false);
        	if(result[0]) {
        		System.out.println("error");
        	} else {
        		StringBuilder sb = new StringBuilder();
        		if(!q.isEmpty()) {
    				sb.append("[");
        			if(result[1]) {
        				while(q.size() > 1)
        					sb.append(q.pollFirst() + ",");
        			}
        			else {
        				while(q.size() > 1)
        					sb.append(q.pollLast() + ",");
        			}
        			if(q.size() != 0)
        				sb.append(q.getFirst());
        			sb.append("]\n");
        		}
        		else {
        			sb.append("[]\n");
        		}
        		System.out.print(sb.toString());
        	}
    	}
    	
    }
    private static boolean[] AC(char[] command, ArrayDeque<Integer> q, boolean err) {
    	boolean dir = true;
    	for(char c : command) {
    		if(c == 'R') {
    			dir = !dir;
    		} else {
    			if(q.isEmpty()) {
    				err = true;
    				break;
    			} else {
    				if(dir) q.pollFirst();
    				else q.pollLast();
    			}
    		}
    	}
    	return new boolean[] {err,dir};
    }
  
}