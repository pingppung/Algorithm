import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] money = new int[n];
        for(int i = 0; i < n; i++) {
        	money[i] = Integer.parseInt(br.readLine());
        }
        int count = 0;
        for(int i = n-1; i >= 0; i--) {
        	if(money[i] <= k) {
        		count += k/money[i];
        		k %= money[i];
        	}
        }
        System.out.println(count);
    }
}  