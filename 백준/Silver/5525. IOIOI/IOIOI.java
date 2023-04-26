import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    	int n = Integer.parseInt(br.readLine());
    	int m = Integer.parseInt(br.readLine());
    	String s = br.readLine();
    	
    	String p = "IO".repeat(n) + "I";
    	int cnt = 0;
    	for(int i = 0 ; i <= m-p.length(); i++) {
    		if(s.substring(i, i+p.length()).equals(p))
    			cnt++;
    	}
    	System.out.println(cnt);
    }

} 