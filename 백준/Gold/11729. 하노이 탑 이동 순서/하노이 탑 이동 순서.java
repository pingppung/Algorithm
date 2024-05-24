import java.io.*;
import java.util.*;
public class Main {
	static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	int n = Integer.parseInt(br.readLine());
    	sb.append((int) (Math.pow(2, n) - 1)).append('\n');
    	hanoi(n, 1, 3, 2);
    	System.out.println(sb.toString());
    }
    private static void hanoi(int n, int start, int target, int temp) {
    	if(n == 1) {
    		sb.append(start+ " "+ target+"\n");
    		return;
    	}
    	hanoi(n-1, start, temp, target);
    	sb.append(start+ " "+ target+"\n");
    	hanoi(n-1, temp, target, start);
    }
}