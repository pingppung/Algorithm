import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	int n = Integer.parseInt(br.readLine());
    	int[][] map = new int[n+1][3];
    	
    	
    	for(int i = 1; i <= n; i++) {
    		String[] arr = br.readLine().split(" ");
    		for(int j = 0; j < 3; j++) {
    			map[i][j] = Integer.parseInt(arr[j]);
    		}
    	}
    	
    	int[][] maxDp = new int[n+1][3];
    	int[][] minDp = new int[n+1][3];
    	for(int i = 1; i <= n; i++) {
    		maxDp[i][0] = Math.max(maxDp[i-1][0], maxDp[i-1][1]) + map[i][0];
    		maxDp[i][1] = Math.max(Math.max(maxDp[i - 1][0], maxDp[i - 1][1]), maxDp[i-1][2]) + map[i][1];
    		maxDp[i][2] = Math.max(maxDp[i-1][1], maxDp[i-1][2]) + map[i][2];
    		
    		minDp[i][0] = Math.min(minDp[i-1][0], minDp[i-1][1]) + map[i][0];
    		minDp[i][1] = Math.min(Math.min(minDp[i - 1][0], minDp[i - 1][1]), minDp[i-1][2]) + map[i][1];
    		minDp[i][2] = Math.min(minDp[i-1][1], minDp[i-1][2]) + map[i][2];
    		
    	}
    	int max = Math.max(maxDp[n][0], Math.max(maxDp[n][1], maxDp[n][2]));
		int min = Math.min(minDp[n][0], Math.min(minDp[n][1], minDp[n][2]));
        System.out.println(max + " " + min);
    	
    }
    
}  