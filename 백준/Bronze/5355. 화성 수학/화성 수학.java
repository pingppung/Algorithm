import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st;
        StringBuilder sb = new StringBuilder();
    	
    	int t = Integer.parseInt(br.readLine());
    	
    	while(t-- > 0) {
    		st = new StringTokenizer(br.readLine());
    		double num = Double.parseDouble(st.nextToken());
    		while(st.hasMoreTokens()) {
    			String c = st.nextToken();
    			if(c.equals("@")) num *= 3;
    			else if(c.equals("%")) num += 5;
    			else num -= 7;
    		}
    		sb.append(String.format("%.2f", num)).append("\n");
    	}
    	System.out.println(sb);
    }
    
}
