import java.io.*;
import java.util.*;
public class Main {
	static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    
    	long x = Long.parseLong(st.nextToken());
    	long y = Long.parseLong(st.nextToken());
    	
    	long z = 100 * y/ x;
    	
    	if(z >= 99) System.out.println(-1);
    	else {
    		long left = 1;
    		long right = x;
    		while(left <= right) {
    			long mid = (left + right) / 2;
    			long addGame = (100 * (y + mid)) / (x+mid);
    			if(z < addGame) right = mid - 1;
    			else left = mid + 1;
    		}

        	System.out.println(left);
    	}
    	
    	
    	
    }
}
