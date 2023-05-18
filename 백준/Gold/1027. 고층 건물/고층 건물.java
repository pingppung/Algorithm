import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st;
    	int n = Integer.parseInt(br.readLine());
    	int[] buildings = new int[n];
    	int[] count = new int[n];
    	st = new StringTokenizer(br.readLine());
    	for(int i = 0; i < n; i++) {
    		buildings[i] = Integer.parseInt(st.nextToken());
    	}
    	for(int i = 0; i < n-1; i++) {
    		count[i]++;
    		count[i+1]++;
    		double  dis = buildings[i+1]-buildings[i];
    		for(int j = i+2; j < n; j++) {
    			double nextdis = (double)(buildings[j]-buildings[i])/(j-i);
    			if(nextdis > dis) {
    				dis = nextdis;
    				count[i]++;
    				count[j]++;
    			}
    		}
    	}
    	int max = Integer.MIN_VALUE;
    	for(int c : count) {
    		max = Math.max(max, c);
    	}
    	System.out.println(max);
    }
}
