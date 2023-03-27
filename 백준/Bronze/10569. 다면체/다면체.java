import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st;
    	StringBuilder sb = new StringBuilder();
    	
    	int t = Integer.parseInt(br.readLine());
    	for(int i = 0; i < t; i++) {
    		st = new StringTokenizer(br.readLine());
    		int v = Integer.parseInt(st.nextToken());
    		int e = Integer.parseInt(st.nextToken());
    		int f = 2 - v + e;
    		sb.append(f+"\n");
    	}
    	System.out.println(sb);
    	
    }
   
}
