import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());

    	int n = Integer.parseInt(st.nextToken());
    	int jimin = Integer.parseInt(st.nextToken());
    	int hansu = Integer.parseInt(st.nextToken());
    	
    	int[] arr = new int[n+1];
    	int count = 0;
    	while(true) {
    		if(jimin == hansu) break;
    		jimin = jimin/2 + jimin%2;
    		hansu = hansu/2 + hansu%2;
    		count++;
    	}
    	System.out.println(count);
    }	
}
