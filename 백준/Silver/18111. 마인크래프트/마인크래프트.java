import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	
    	int n = Integer.parseInt(st.nextToken());
    	int m = Integer.parseInt(st.nextToken());
    	int b = Integer.parseInt(st.nextToken());
    	
    	int[][] ground = new int[n][m];
    	int max = Integer.MIN_VALUE;
    	int min = Integer.MAX_VALUE;
    	for(int i = 0; i < n; i++) {
    		st = new StringTokenizer(br.readLine());
    		for(int j = 0; j < m; j++) {
    			int h = Integer.parseInt(st.nextToken());
    			ground[i][j] = h;
    			max = Math.max(max, h);
    			min = Math.min(min, h);
    		}
    	}

    	int time = Integer.MAX_VALUE;
    	int height = -1;
    	for(int i = min; i <= max; i++) {
    		int inventory = b;
    		int second = 0;
    		for(int j = 0;  j < n; j++) {
    			for(int k = 0; k < m; k++) {
    				int diff = ground[j][k] - i;
    				if(diff > 0) {
    					second += Math.abs(diff)*2;
    					inventory += Math.abs(diff);
    				} else if(diff < 0) {
    					second += Math.abs(diff);
    					inventory -= Math.abs(diff);
    				}
    			}
    		}
    		if(inventory >= 0) {
    			if(second <= time)
    			{
    				time = second;
    				height = i;
    			}
    		}
    	}

		System.out.println(time + " " + height);
    }
}
