import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());

    	int n = Integer.parseInt(st.nextToken());
    	int k = Integer.parseInt(st.nextToken());
    	
    	int count = 0;
    	int[][] students = new int[7][2];
    	for(int i = 0; i < n; i++) {
    		st = new StringTokenizer(br.readLine());
    		int s = Integer.parseInt(st.nextToken());
    		int y = Integer.parseInt(st.nextToken());
    		
    		if(s == 0) students[y][0]++;
    		else students[y][1]++;
    	}
    	for(int i = 1; i < 7; i++) {
    		for(int j = 0; j < 2; j++) {
    			if(students[i][j] == 0) continue;
    			if(students[i][j] <= k) count++;
    			else if(students[i][j] % k == 0) count += students[i][j] / k;
    			else count += students[i][j] / k + 1;
    			
    		}
    	}
    	System.out.println(count);
    }
    
}
