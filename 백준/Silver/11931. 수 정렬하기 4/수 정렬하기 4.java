import java.io.*;
import java.util.*;
public class Main {
	static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    	int n = Integer.parseInt(br.readLine());
    	ArrayList<Integer> arr = new ArrayList<>();
    	for(int i = 0; i < n; i++) {
    		int num = Integer.parseInt(br.readLine());
    		arr.add(num);
    	}
    	Collections.sort(arr, Collections.reverseOrder());
    	for(int i : arr) {
    		sb.append(i+"\n");
    	}
    	System.out.println(sb);
    	
    }
}
