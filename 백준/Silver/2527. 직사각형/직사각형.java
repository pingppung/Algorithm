import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st;
    	for(int i = 0; i < 4; i++) {
    		st = new StringTokenizer(br.readLine());
    		int x1 = Integer.parseInt(st.nextToken());
    		int y1 = Integer.parseInt(st.nextToken());
    		int p1 = Integer.parseInt(st.nextToken());
    		int q1 = Integer.parseInt(st.nextToken());
    		
    		int x2 = Integer.parseInt(st.nextToken());
    		int y2 = Integer.parseInt(st.nextToken());
    		int p2 = Integer.parseInt(st.nextToken());
    		int q2 = Integer.parseInt(st.nextToken());
    		if(p1 < x2 || q1 < y2 || p2 < x1 || q2 < y1) System.out.println("d");
    		else if((p1 == x2 && q1 == y2) || (x1 == p2 && q1 == y2) || 
    				(x1 == p2 && y1 == q2) || (p1 == x2 && y1 == q2))
    			System.out.println("c");
    		else if(p1 == x2 || q1 == y2 || p2 == x1 || y1 == q2)
    			System.out.println("b");
    		else System.out.println("a");
    		
    	}
    	
    }
}
