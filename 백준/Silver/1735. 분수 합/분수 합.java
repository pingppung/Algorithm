import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    
    	int ja1 = Integer.parseInt(st.nextToken());
    	int mo1 = Integer.parseInt(st.nextToken());
    	st = new StringTokenizer(br.readLine());
    	int ja2 = Integer.parseInt(st.nextToken());
    	int mo2 = Integer.parseInt(st.nextToken());
    	
    	int result_mo = mo1 * mo2;
    	int result_ja = mo1*ja2 + mo2*ja1;
    	
    	int mod = gcd(result_ja, result_mo);
    	result_ja /= mod;
    	result_mo /= mod;
    	
    	System.out.println(result_ja + " "+ result_mo);
    }
    public static int gcd(int a, int b) {
    	if(a <= b) {
    		int tmp = a;
    		a = b;
    		b = tmp;
    	}
    	if(b == 0) return a;
    	return gcd(b, a % b);
    }
    
}
