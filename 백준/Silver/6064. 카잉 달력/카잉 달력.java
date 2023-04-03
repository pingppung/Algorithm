import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st;
    	int t = Integer.parseInt(br.readLine());
    	while(t-- > 0) {
    		st = new StringTokenizer(br.readLine());
    		int m = Integer.parseInt(st.nextToken());
    		int n = Integer.parseInt(st.nextToken());
    		int x = Integer.parseInt(st.nextToken()) -1;
    		int y = Integer.parseInt(st.nextToken()) -1;
    		
    		boolean chk = false;
    		for(int i = x; i <n*m; i+=m) {
    			if(i%n == y) {
    				System.out.println(i+1);
    				chk = true;
    				break;
    			}
    		}
    		if(!chk) System.out.println(-1);
    	}
    }
}
