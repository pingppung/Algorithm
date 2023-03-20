import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    	long n = Long.parseLong(br.readLine());
    	int pisano = 1500000;
    	long[] num = new long[pisano+1];
    	num[0] = 0;
    	num[1] = 1;
    	for(int i = 2; i <= pisano; i++) {
    		num[i] = (num[i-1] + num[i-2])%1000000;
    	}
    	System.out.println(num[(int) (n %pisano)]);
    } 
}
