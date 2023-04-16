import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 
    	String s;
        while ((s = br.readLine()) != null){
            int n = Integer.parseInt(s);
            int num = 1;
            int count = 1;
            while ((num = num% n) != 0){
            	num = (num * 10 + 1) % n;
                count++;
            }
            System.out.println(count);
        }
    }
}
