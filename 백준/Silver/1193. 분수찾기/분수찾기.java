import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    	int x = Integer.parseInt(br.readLine());

        int n = 0;
        int count = 0;
	    while(count < x) {
	   		n++;
	   		count  = n * (n+1)/2;
	   	}	
	   	int num = x-(n-1)*n/2;
	   	int t = 1;
	   	int b = 1;
	   	if(n%2 == 0) {
	   		t = num;
	   		b = n-num+1;
	   	} else {
	   		t = n- num+1;
	   		b = num;
	   	}
	   	System.out.println(t + "/"+b);
    }
} 

