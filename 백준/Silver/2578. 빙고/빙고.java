import java.io.*;
import java.util.*;
public class Main {
	static int[][] bingo;
	static int count = 0;
    public static void main(String[] args) throws IOException{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st;
    	bingo = new int[5][5];
    	for(int i = 0; i < 5; i++) {
    		st = new StringTokenizer(br.readLine());
    		for(int j = 0; j < 5; j++) {
    			bingo[i][j] = Integer.parseInt(st.nextToken());
    		}
    	}
    	int turn = 1;
    	for(int i = 0; i < 5; i++) {
    		st = new StringTokenizer(br.readLine());
    		for(int j = 0; j < 5; j++) {
    			int num = Integer.parseInt(st.nextToken());
    			for(int k = 0; k < 5; k++) {
    	    		for(int l = 0; l < 5; l++) {
    	    			if(bingo[k][l] == num) {
    	    				bingo[k][l] = -1;
    	    			}
    	    		}
    	    	}
    			row_chk();
    			col_chk();
    			dia1_chk();
    			dia2_chk();
    			if(count >= 3) {
    				System.out.println(turn);
    				return;
    			}
    			count = 0;
    			turn++;
    		}
    	}
    	
    }
    public static void row_chk() {
    	for(int i = 0; i < 5; i++) {
        	int line = 0;
    		for(int j = 0; j < 5; j++) {
    			if(bingo[i][j] == -1) line++;
    		}
    		if(line == 5) count++;
    	}
    }
    public static void col_chk() {
    	for(int i = 0; i < 5; i++) {
        	int line = 0;
    		for(int j = 0; j < 5; j++) {
    			if(bingo[j][i] == -1) line++;
    		}
    		if(line == 5) count++;
    	}
    }

    public static void dia1_chk() {
    	int line = 0;
    	for(int i = 0; i < 5; i++) {
    		if(bingo[i][4-i] == -1) line++;
    		if(line == 5) count++;
    	}
    }
    public static void dia2_chk() {
    	int line = 0;
    	for(int i = 0; i < 5; i++) {
    		if(bingo[i][i] == -1) line++;
    		if(line == 5) count++;
    	}
    }
}
