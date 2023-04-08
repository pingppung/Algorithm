import java.io.*;
import java.util.*;
public class Main {
	static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st;
    	int[][] score = new int[8][2];
    	for(int i = 0; i < 8; i++) {
    		int n = Integer.parseInt(br.readLine());
    		score[i][0] = n;
    		score[i][1] = i+1;
    	}
    	Arrays.sort(score, new Comparator<int[]>(){

			@Override
			public int compare(int[] o1, int[] o2) {
				if(o1[0] < o2[0]) return 1;
				else if(o1[0] == o2[0]) return 0;
				else return -1;
			}
    		
    	});
    	int total = 0;
    	int[] idx = new int[5];
    	for(int i = 0; i < 5; i++) {
    		total += score[i][0];
    		idx[i] = score[i][1];
    	}
    	sb.append(total+"\n");
    	Arrays.sort(idx);
    	for(int i : idx) {
    		sb.append(i +" ");
    	}
    	System.out.println(sb);
    	
    }
}
