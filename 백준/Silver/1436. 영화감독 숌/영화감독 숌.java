import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    	int n = Integer.parseInt(br.readLine());
    	int num = 666;
    	int i = 1;
    	while(true) {
    		if(i == n) break;
    		num++;
    		if(String.valueOf(num).contains("666")) i++;
    	}
    	System.out.println(num);
    	
    	
    	
    }
}
