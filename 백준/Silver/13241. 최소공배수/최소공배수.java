import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());

    	long a = Long.parseLong(st.nextToken());
    	long b = Integer.parseInt(st.nextToken());
    	System.out.println(lcm(a, b));
    	
    }
    public static Long lcm(long a, long b) {
    	return a*b / gcd(a,b);
    }
    public static Long gcd(long a, long b) {
    	if(a%b ==0) {
			return b;
		}
		return gcd(b, a%b);
    }
}
