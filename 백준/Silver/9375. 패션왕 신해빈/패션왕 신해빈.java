import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st;
    	int t = Integer.parseInt(br.readLine());
    	for(int i = 0; i < t; i++) {
    		Map<String, Integer> map = new HashMap<>();
    		int n = Integer.parseInt(br.readLine());
        	
        	for(int j = 0; j < n; j++) {
            	st = new StringTokenizer(br.readLine());
        		String name = st.nextToken();
        		String type = st.nextToken();
        		map.put(type, map.getOrDefault(type, 0)+1);
        	}
        	int count = 1;
        	int mul = 1;
        	for(int v : map.values()) {
        		
        		count *= (v+1);
        	}
        	System.out.println(count-1);
    	}
    	
    }
}  