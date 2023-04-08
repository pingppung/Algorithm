import java.io.*;
import java.util.*;
public class Main {
	static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st;
    	int n = Integer.parseInt(br.readLine());
    	ArrayList<Integer> arr = new ArrayList<>();
    	st = new StringTokenizer(br.readLine());
    	for(int i = 0; i < n; i++) {
    		int num = Integer.parseInt(st.nextToken());
    		if(!arr.contains(num)) arr.add(num);
    	}
    	Collections.sort(arr);
    	
    	for(int i : arr) {
    		sb.append(i+" ");
    	}
    	System.out.println(sb);
    }
}
