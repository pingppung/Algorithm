import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 
    	String s = br.readLine();
    	String A = "AAAA";
    	String B = "BB";
    	s = s.replaceAll("XXXX", A);
    	s = s.replaceAll("XX", B);
    	if(s.contains("X")) s = "-1";
    	System.out.println(s);
    	
    }
}
