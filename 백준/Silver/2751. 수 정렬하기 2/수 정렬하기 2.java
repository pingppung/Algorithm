import java.io.*;
import java.util.*;
public class Main {
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	
    	int n = Integer.parseInt(br.readLine());
    	ArrayList<Integer> arr = new ArrayList<>();
    	for(int i = 0; i < n; i++) {
    		arr.add(Integer.parseInt(br.readLine()));
    	}
    	Collections.sort(arr);
    	for(int i : arr) {
    		sb.append(i).append('\n');
    	}
    	System.out.println(sb);

    }
}
