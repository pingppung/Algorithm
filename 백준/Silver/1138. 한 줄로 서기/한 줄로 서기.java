import java.io.*;
import java.util.*;
public class Main {
	static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st;
    	int n = Integer.parseInt(br.readLine());
    	int[] height = new int[n+1];
    	st = new StringTokenizer(br.readLine());
    	for(int i = 1; i <= n; i++) {
    		height[i] = Integer.parseInt(st.nextToken());
    	}
    	
    	ArrayList<Integer> list = new ArrayList<>();
    	for(int i = n; i > 0; i--) {
    		list.add(height[i], i);
    	}
    	for(int i : list) {
    		System.out.print(i+" ");
    	}
    			
    }
}
