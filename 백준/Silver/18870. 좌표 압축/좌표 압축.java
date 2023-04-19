import java.io.*;
import java.util.*;
public class Main {
	static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
    	
    	int[] arr = new int[n];
    	int[] sort = new int[n];
    	HashMap<Integer, Integer> rankMap = new HashMap<>();
    	
    	st = new StringTokenizer(br.readLine());
    	for(int i = 0; i < n; i++) {
    		arr[i] = sort[i] = Integer.parseInt(st.nextToken());
    	}
    	Arrays.sort(sort);
    	
    	int rank = 0;
    	for(int val : sort) {
    		if(!rankMap.containsKey(val)) {
    			rankMap.put(val, rank);
    			rank++;
    		}
    	}
    	for(int key : arr) {
    		int r = rankMap.get(key);
    		sb.append(r+" ");
    	}
    	System.out.println(sb);
    	
    }
}
