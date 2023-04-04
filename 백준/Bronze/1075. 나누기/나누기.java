import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 
    	int n = Integer.parseInt(br.readLine());
    	int f = Integer.parseInt(br.readLine());
    	
    	int newN = (n/100)*100;
    	while(true) {
    		if(newN % f == 0) {
    			int result = newN % 100;
    			if(result < 10) System.out.println("0"+ result);
    			else System.out.println(result);
    			break;
    		}
    		newN++;
    	}
    }
}
