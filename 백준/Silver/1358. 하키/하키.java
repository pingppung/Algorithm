import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
   
    	int W = Integer.parseInt(st.nextToken());
    	int H = Integer.parseInt(st.nextToken());
    	int X = Integer.parseInt(st.nextToken());
    	int Y = Integer.parseInt(st.nextToken());
    	int P = Integer.parseInt(st.nextToken());
    	int count = 0;
    	for(int i = 0; i < P; i++) {
    		st = new StringTokenizer(br.readLine());
    		int x = Integer.parseInt(st.nextToken());
    		int y = Integer.parseInt(st.nextToken());
    		if(x >= X && x <= X+W && y >= Y && y <= Y+H) {
    			count++;
    			continue;
    		}
    		if(Math.pow(H/2, 2) >= ((Math.pow(X-x, 2)+ Math.pow(Y+H/2 -y, 2)))) {
    			count++;
    			continue;
    		}
    		else if(Math.pow(H/2, 2) >= ((Math.pow(X+W-x, 2)+ Math.pow(Y+H/2 -y, 2)))) {
    			count++;
    			continue;
    		}
    		
    	}
    	System.out.println(count);
    	
    }
   
}
