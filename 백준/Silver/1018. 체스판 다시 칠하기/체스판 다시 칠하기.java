import java.io.*;
import java.util.*;
public class Main {
	static String[] board = {"WBWBWBWB", "BWBWBWBW"};
	static String[] arr;
	static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	
    	int n = Integer.parseInt(st.nextToken());
    	int m = Integer.parseInt(st.nextToken());
    	
    	arr = new String[n];
    	
    	for(int i = 0; i < n; i++) {
    		 arr[i] = br.readLine();
    	}
    	
    	int result = Integer.MAX_VALUE;
    	for(int i = 0; i <= n-8; i++) {
    		for(int j = 0; j <= m-8; j++) {
    			int count = check(i, j);
    			if(result > count) result = count;
    		}
    	}
    	System.out.println(result);
    }
    static int check(int row, int col) {
    	int count = 0;
    	for(int i = 0; i < 8; i++) {
    		int sr = row + i;
    		for(int j = 0; j < 8; j++) {
    			int sc = col + j;
    			if(arr[sr].charAt(sc) != board[sr%2].charAt(j)) count++;
    		}
    	}
    	return Math.min(count, 64- count);
    }
}
