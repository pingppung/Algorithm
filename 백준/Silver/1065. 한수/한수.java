import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
    	int n = Integer.parseInt(br.readLine());
    	int cnt = 0;
    	if(n < 100) cnt = n;
    	else {
    		cnt = 99;
    		for(int i = 100; i <= n; i++) {
    			int hundreds = i / 100;
    			int tens = (i / 10) % 10;
    			int units = i % 10;
    			if(hundreds - tens == tens - units) cnt++;
    		}
    	}
    	System.out.println(cnt);
	
    }
}
