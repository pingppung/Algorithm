import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());

    	int n = Integer.parseInt(st.nextToken());
    	int k = Integer.parseInt(st.nextToken());
    	int[][] score = new int[n+1][3];
    	for(int i = 0; i < n; i++) {
    		st = new StringTokenizer(br.readLine());
    		int country = Integer.parseInt(st.nextToken());
    		int gold = Integer.parseInt(st.nextToken());
    		int silver = Integer.parseInt(st.nextToken());
    		int bronze = Integer.parseInt(st.nextToken());
    		score[country][0] = gold;
    		score[country][1] = silver;
    		score[country][2] = bronze;
    	}
    	int rank = 1;
    	for(int i = 1; i <= n; i++) {
    		if(score[i][0] > score[k][0]) rank++;
    		else if(score[i][0] == score[k][0] && score[i][1] > score[k][1]) rank++;
    		else if(score[i][0] == score[k][0] && score[i][1] == score[k][1] && score[i][2] > score[k][2])
    			rank++;
    	}
    	System.out.println(rank);
    	
    }
}
