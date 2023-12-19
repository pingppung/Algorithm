import java.io.*;
import java.util.Arrays;
public class Main {
    public static void main(String[] args) throws IOException{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	int t = Integer.parseInt(br.readLine());
    	int[][] apt = new int[15][15];
    	StringBuilder sb = new StringBuilder();
    	for(int i = 1; i < 15; i++) apt[0][i] = i;
    	for(int i = 1; i < 15; i++) {
    		for(int j = 1; j < 15; j++)
    			apt[i][j] = apt[i-1][j] + apt[i][j-1];
    	}
    	
    	for(int i = 0; i < t; i++) {
    		int k = Integer.parseInt(br.readLine());
    		int n = Integer.parseInt(br.readLine());
    		System.out.println(apt[k][n]);
    	}
 
    	
    }

}
