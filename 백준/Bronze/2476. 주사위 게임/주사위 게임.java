import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st;
    	int n = Integer.parseInt(br.readLine());
    	int result = 0;
    	for(int i = 0; i < n; i++) {
    		st = new StringTokenizer(br.readLine());
    		
    		int money = 0;
    		int a = Integer.parseInt(st.nextToken());
    		int b = Integer.parseInt(st.nextToken());
    		int c = Integer.parseInt(st.nextToken());
    		
    		if(a==b && b==c) money = 10000 + (a * 1000);
    		else if(a!=b && b!=c && a!=c) {
    			int max = Math.max(a, Math.max(b, c));
    			money = max * 100;
    		} else {
    			if(a==b || b==c) money = 1000 + (b*100);
    			else if(a==c || c==b) money = 1000 + (c*100);
    			else money = 1000 + (b*100);
    		}
    		
    		result = Math.max(result, money);
    	}
    	System.out.println(result);
    }
    
}
