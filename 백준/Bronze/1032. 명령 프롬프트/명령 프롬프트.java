import java.io.*;
import java.util.Arrays;
public class Main {
    public static void main(String[] args) throws IOException{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringBuilder sb = new StringBuilder();
    	int x = Integer.parseInt(br.readLine());
    	char[] pattern = br.readLine().toCharArray();
    	
    	for(int i = 0; i < x-1; i++) {
    		char[] comparefile = br.readLine().toCharArray();
    		for(int j = 0; j < pattern.length; j++)
    			if(pattern[j] != comparefile[j]) pattern[j] = '?';
    	}
    	System.out.println(pattern);
    }

}
