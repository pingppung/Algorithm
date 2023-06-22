import java.io.*;
import java.util.*;
public class Main {
	static StringBuilder sb = new StringBuilder();
	static int[] lines;
	static int n, k, count = 0;
	public static void main(String[] args) throws IOException{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	
    	k = Integer.parseInt(st.nextToken());
    	n = Integer.parseInt(st.nextToken());
    	lines = new int[k];
    	long max = 0;
    	for(int i = 0; i < k; i++) {
    		lines[i] = Integer.parseInt(br.readLine());
    		max = Math.max(lines[i], max);
    	}
    	long len = cut_line(max);
    	System.out.println(len);
    }
	static long cut_line(long max) {
		long start = 1;
		long end = max;
		while(start <= end) {
			long count = 0;
			long mid = (start+end)/2;
			for(int i = 0; i < k; i++) {
				count += lines[i]/mid;
			}
			if(count >= n) start = mid+1;
			else end = mid-1;
		}
		return end;
	}
}
