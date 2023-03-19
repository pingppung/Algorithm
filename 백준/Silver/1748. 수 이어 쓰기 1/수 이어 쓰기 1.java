import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	int n = Integer.parseInt(br.readLine());
    	int digit = 10;
    	int count = 0;
    	int numCnt = 1;
    	for(int i = 1; i <=n; i++) {
    		if(i%digit == 0) {
    			digit *= 10;
    			numCnt++;
    		}
    		count += numCnt;
    	}
    	System.out.println(count);
    } 
}
