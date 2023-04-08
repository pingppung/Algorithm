import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st;
    	int n = Integer.parseInt(br.readLine());
    	int[][] arr = new int[101][101];
    	int result = 0;
    	for(int i = 0; i < n; i++) {
    		st = new StringTokenizer(br.readLine());
    		int x = Integer.parseInt(st.nextToken());
    		int y = Integer.parseInt(st.nextToken());

    		for(int p = x; p < x+10; p++) {
    			for(int q = y; q < y+10; q++) {
    				if(arr[p][q] != 1) {
    					arr[p][q] = 1;
    					result++;
    				}
    			}
    		}
    	}
    	System.out.println(result);
    	
    	
    }
}
