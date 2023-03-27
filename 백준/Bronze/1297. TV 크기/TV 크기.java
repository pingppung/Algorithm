import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());

    	int d = Integer.parseInt(st.nextToken());
    	int h = Integer.parseInt(st.nextToken());
    	int w = Integer.parseInt(st.nextToken());
    	
    	double n = Math.pow(d, 2) / (Math.pow(h, 2) + Math.pow(w, 2));
    	System.out.println((int)Math.sqrt(n*Math.pow(h, 2))+" "+ (int)Math.sqrt(n*Math.pow(w, 2)));
    } 	
   
}
