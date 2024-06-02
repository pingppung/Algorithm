import java.io.*;
import java.util.*;
public class Main {
	static int[][] gear;
	static int[] dir;
    public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	gear = new int[5][8];
    	for(int i = 1; i < 5; i++) {
    		int[] mag = Arrays.stream(br.readLine().split("")).mapToInt(Integer::valueOf).toArray();
    		gear[i] = mag;
    	}
    	int k = Integer.parseInt(br.readLine());
    	while(k-- > 0) {             
    		int[] rotate = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::valueOf).toArray();
    		int n = rotate[0], d = rotate[1];
    		dir = new int[5];
    		dir[n] = d;
            
    		deterDir(n);
    		rotationGear();
    	}
    	
    	int sum = 0;
		if(gear[1][0] == 1) sum+=1;
		if(gear[2][0] == 1) sum+=2;
		if(gear[3][0] == 1) sum+=4;
		if(gear[4][0] == 1) sum+=8;
		System.out.println(sum);
    	
    }
    private static void deterDir(int n) {
    	for(int i = n-1; i > 0; i--) {
    		if(gear[i][2] != gear[i+1][6]) dir[i] = -dir[i+1];
    		else break;
    	}
    	for(int i = n+1; i < 5; i++) {
    		if(gear[i][6] != gear[i-1][2]) dir[i] = -dir[i-1];
    		else break;
    	}
    }
    private static void rotationGear() {
    	for(int i = 1; i < 5; i++) {
    		if(dir[i] == -1) { //반시계
    			int temp = gear[i][0];
    			for(int j = 0; j < 7; j++) gear[i][j] = gear[i][j+1];
    			gear[i][7] = temp;
    		} else if(dir[i] == 1) { //시계
    			int temp = gear[i][7];
    			for(int j = 7; j > 0; j--) gear[i][j] = gear[i][j-1];
    			gear[i][0] = temp;
    		}
    	}
    }
    
}