import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	
    	int n = Integer.parseInt(br.readLine());
    	int[] game = new int[n];
    	for(int i = 0; i < n; i++) {
    		game[i] = Integer.parseInt(br.readLine());
    	}
    	int score = 0;
    	for(int i = n-2; i >=0; i--) {
    		if(game[i] >= game[i+1]) {
    			int dec = game[i] - game[i+1] + 1;
    			score += dec;
    			game[i] -= dec;
    		}
    		
    	}
    	System.out.println(score);
    }
}
