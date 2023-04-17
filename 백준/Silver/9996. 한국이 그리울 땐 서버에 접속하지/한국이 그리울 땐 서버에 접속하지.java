import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st;
    	int n = Integer.parseInt(br.readLine());
    	String[] pattern = br.readLine().split("\\*");
    	for(int i = 0; i < n; i++) {
    		String s = br.readLine();
    		if(pattern[0].length() + pattern[1].length() > s.length()) {
    			System.out.println("NE");
    			continue;
    		}
    		String a = s.substring(0, pattern[0].length());
    		String b = s.substring(s.length()-pattern[1].length(), s.length());
    		if(a.equals(pattern[0]) && b.equals(pattern[1])) 
    			System.out.println("DA");
    		else System.out.println("NE");
    		
    	}
    }
}
