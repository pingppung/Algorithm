import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	
    	int n = Integer.parseInt(br.readLine());
    	int[] rank = new int[n+1];
    	for(int i = 1;  i <= n; i++) {
    		rank[i] = Integer.parseInt(br.readLine());
    	}
    	Arrays.sort(rank);
    	long dissa = 0;
    	for(int i = 1; i <= n; i++) {
    		dissa += Math.abs(rank[i] - i);
    	}
    	System.out.println(dissa);
    }
}
