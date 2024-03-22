import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	int n = Integer.parseInt(br.readLine());
    	int[][] tri = new int[n][n];
    	int[][] dp = new int[n][n];
    	for(int i = 0; i < n; i++) {
    		String[] arr = br.readLine().split(" ");
			for(int j = 0; j < arr.length; j++) {
				tri[i][j] = Integer.parseInt(arr[j]);
			}
    	}
    	for(int i = n-1; i > 0; i--) {
    		for(int j = 0; j < i; j++) {
    			tri[i-1][j] += Math.max(tri[i][j], tri[i][j+1]);
    		}
    	}
    	System.out.println(tri[0][0]);
    }
}  