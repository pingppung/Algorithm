import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringBuilder sb = new StringBuilder();
    	
    	int d1 = Integer.parseInt(br.readLine());
    	int d2 = Integer.parseInt(br.readLine());
    	double pi = 3.141592;
    	
    	double circle = 2 * pi * d2;
    	int box = 2*d1;
    	System.out.println(circle + box);
    } 	
   
}
