import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st;
    	int n = Integer.parseInt(br.readLine());
    	int cy_score = 100;
    	int sd_score = 100;
    	for(int i = 0; i < n; i++) {
    		st =  new StringTokenizer(br.readLine());
    		int cy = Integer.parseInt(st.nextToken());
    		int sd = Integer.parseInt(st.nextToken());
    		
    		if(cy > sd) sd_score -= cy;
    		else if(cy == sd) continue;
    		else cy_score -= sd;
    		
    	}
    	System.out.println(cy_score);
    	System.out.println(sd_score);
    }
    
}
