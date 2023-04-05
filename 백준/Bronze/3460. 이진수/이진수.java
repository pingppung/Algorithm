import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    	
    	int t = Integer.parseInt(br.readLine());
    	
    	while(t-- > 0) {
            StringBuilder sb = new StringBuilder();
    		int n = Integer.parseInt(br.readLine());
    		String s = Integer.toBinaryString(n);
    		for(int i = s.length() -1; i >= 0; i--) {
    			if(s.charAt(i) == '1') sb.append(s.length() -1 - i +" ");
    		}
        	System.out.println(sb);
    	}
    }
    
}
