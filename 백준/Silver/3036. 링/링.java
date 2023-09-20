import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st;
       
    	int n = Integer.parseInt(br.readLine());

		st = new StringTokenizer(br.readLine());
		int[] arr = new int[n];
    	for(int i = 0; i < n; i++) {
    		arr[i] = Integer.parseInt(st.nextToken());
    	}
    	
    	for(int i = 1; i < n; i++) {
    		int g = gcd(arr[0], arr[i]);
    		System.out.println(arr[0] / g +"/"+arr[i]/g);
    	}
    	
    }
    static int gcd(int a, int b) {
    	
    	while(b != 0) {
    		int tmp = a%b;
    		a = b;
    		b = tmp;
    	}
    	return a;
    }
}  