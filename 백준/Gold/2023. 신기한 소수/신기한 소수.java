import java.io.*;
import java.util.*;
public class Main {
	static int[] prime ={2, 3, 5, 7};// 첫번째 숫자
	static int[] next = {1, 3, 7, 9};
	static int n;
    public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	n = Integer.parseInt(br.readLine()); 
    	for(int i = 0; i < 4; i++) {
    		find(String.valueOf(prime[i]));
    	}
    	
    	
    }
    private static void find(String ns) {
    	if(n == ns.length()) {
    		System.out.println(ns);
    		return;
    	}
    	for(int i = 0; i < 4; i++) {
    		int num = Integer.parseInt(ns + next[i]);
    		if(isPrime(num)) {
    			find(String.valueOf(num));
    		}
    	}
    }
    private static boolean isPrime(int num) {
    	if(num < 2) return false;
    	for(int i = 2; i <= Math.sqrt(num); i++) {
    		if(num % i == 0) return false;
    	}
    	return true;
    }
}


//1 - 1, 3, 7
//2 - 3, 9
//3 - 1, 3, 9
//7 - 3, 9
//9 - 3, 9

