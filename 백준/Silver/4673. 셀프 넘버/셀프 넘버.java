import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    	boolean[] chk = new boolean[10001];
    	for(int i = 1; i < 10001; i++) {
    		int self = d(i);
    		if(self <= 10000) chk[self] = true;
    	}
    	for(int i = 1; i < 10001; i++) {
    		if(!chk[i]) System.out.println(i);
    	}

    }
    public static int d(int num) {
    	int sum = num;
    	while(num != 0) {
    		sum += (num%10);
    		num /= 10;
    	}
    	return sum;
    }
   
    
}
