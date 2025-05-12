import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] sols = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::valueOf).toArray();
		Arrays.sort(sols);
		
		int left = 0;
		int right = sols.length-1;
		int closetZero = Integer.MAX_VALUE;
		int[] closetPair = new int[2];
		while(left < right) {
			int sum = sols[left] + sols[right];
			
			if(Math.abs(sum) < Math.abs(closetZero)) {
				closetZero = sum;
				closetPair[0] = sols[left];
				closetPair[1] = sols[right];
			}
			if(sum > 0) right --;
			else if(sum < 0) left ++;
			else break;
		}
		
		System.out.println(closetPair[0]+ " "+ closetPair[1]);
	}
	
}
