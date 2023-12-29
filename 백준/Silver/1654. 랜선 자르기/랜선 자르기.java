import java.io.*;
import java.util.*;
public class Main {
	static int[] lanterns;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int k = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());
		lanterns = new int[k];
		long max = 0;
    	for(int i = 0; i < k; i++) {
    		lanterns[i] = Integer.parseInt(br.readLine());
    		max = Math.max(lanterns[i], max);
    	}
		System.out.println(cutter(n, max));
	}
		
	private static long cutter(int n, long max) {
		long start = 1;
		long end = max;
		while(start <= end) {
			long count = 0;
			long mid = (start + end) / 2;
			for(int lantern : lanterns) {
				count += (lantern / mid);
			}
			if(count >= n) start = mid + 1;
			else end = mid - 1;
		}
		return end;
	}
}