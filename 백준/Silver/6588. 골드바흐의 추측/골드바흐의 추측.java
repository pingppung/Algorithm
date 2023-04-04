import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringBuilder sb = new StringBuilder();
    	
    	boolean prime[] = new boolean[1000001];
    	prime[0] = prime[1] = true;
    	for (int i = 2; i <= Math.sqrt(1000000); i++) {
            if(prime[i] == true){
                continue;
            }
            for (int j = i * i; j < prime.length; j += i) {
                prime[j] = true;
            }
        }
    	while(true) {
    		int n = Integer.parseInt(br.readLine());
    		if(n == 0) break;
    		boolean chk = false;
    		
    		for(int i = 2; i <= n/2; i++) {
    			if(!prime[i] && !prime[n - i]) {
    				sb.append(n + " = " + i + " + "+ (n-i) + "\n");
    				chk = true;
    				break;
    				
    			}
    		} 
    		if(!chk) sb.append("Goldbach's conjecture is wrong.\n");
    	}
    	System.out.println(sb);
    }
}
