import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	int x = Integer.parseInt(br.readLine());
    	int bar = 64;
    	int count = 0;
    	
    	while(x > 0) {
    		if(bar > x) bar /= 2;
    		else {
    			count++;
    			x -= bar;
    		}
    	}
    	System.out.println(count);
    }

}  
