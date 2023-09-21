import java.io.*;
import java.util.*;
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		StringTokenizer st = new StringTokenizer(br.readLine());
		int a1 = Integer.parseInt(st.nextToken());
    	int b1 = Integer.parseInt(st.nextToken());
    	st = new StringTokenizer(br.readLine());
    	int a2 = Integer.parseInt(st.nextToken());
    	int b2 = Integer.parseInt(st.nextToken());
    	
    	int result_mo = b1 * b2;
    	int result_ja = a1*b2 + a2*b1;
    	
    	int mod = gcd(result_ja, result_mo);
    	result_ja /= mod;
    	result_mo /= mod;
    	
    	System.out.println(result_ja + " "+ result_mo);
	}
	public static int gcd(int a, int b) {
		while(b != 0) {
			int tmp = a % b;
			a = b;
			b = tmp;
		}
		return a;
	}
}
