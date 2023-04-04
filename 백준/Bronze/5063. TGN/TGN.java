import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st;

    	int n = Integer.parseInt(br.readLine());
    	for(int i = 0; i < n; i++) {
    		st = new StringTokenizer(br.readLine());
    		int r = Integer.parseInt(st.nextToken());
    		int e = Integer.parseInt(st.nextToken());
    		int c = Integer.parseInt(st.nextToken());
    		
    		if(r > (e-c)) System.out.println("do not advertise");
    		else if(r == (e-c)) System.out.println("does not matter");
    		else System.out.println("advertise");
    	}
    	
    }
}
