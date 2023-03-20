import java.io.*;
import java.util.*;
import java.math.BigInteger;
public class Main {
    public static void main(String[] args) throws IOException{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());

    	int n = Integer.parseInt(st.nextToken());
    	int m = Integer.parseInt(st.nextToken());
    	
    
    	BigInteger ja = BigInteger.ONE;	
    	BigInteger mo = BigInteger.ONE;
    	for(int i = 0; i < m; i++) {
    		ja = ja.multiply(new BigInteger(String.valueOf(n-i)));
    		mo = mo.multiply(new BigInteger(String.valueOf(i+1)));
    	}
    	System.out.println(ja.divide(mo));
    } 
}
