import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st;
    	int n = Integer.parseInt(br.readLine());
    	int accum = 0;
    	int total = 0;

		st = new StringTokenizer(br.readLine());
    	for(int i = 0; i < n; i++) {
    		int num = Integer.parseInt(st.nextToken());
    		if(num == 1) {
    			accum++;
    			total += accum;
    		} else {
    			accum = 0;
    		}
    	}
    	System.out.println(total);
    }
}
