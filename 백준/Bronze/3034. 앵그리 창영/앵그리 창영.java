import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	StringBuilder sb = new StringBuilder();
    	
    	int n = Integer.parseInt(st.nextToken());
    	int w = Integer.parseInt(st.nextToken());
    	int h = Integer.parseInt(st.nextToken());
    	
    	double d = Math.sqrt(Math.pow(w, 2) + Math.pow(h, 2));
    	for(int i = 0; i < n; i++) {
    		int num = Integer.parseInt(br.readLine());
    		if(num <= d || num <= w || num <= h) {
    			sb.append("DA\n");
    		}
    		else sb.append("NE\n");
    	}
    	System.out.println(sb);
    } 	
   
}
