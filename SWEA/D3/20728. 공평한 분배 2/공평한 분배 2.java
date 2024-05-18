import java.io.*;
import java.util.*;
public class Solution {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		int idx = 1;
		while(T-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			long result = Integer.MAX_VALUE;
			if(N < K) result = 0;
			else {
				long[] pocket = Arrays.stream(br.readLine().split(" ")).mapToLong(Long::valueOf).toArray();
				Arrays.sort(pocket);
				for(int i = 0; i < N-K+1; i++) {
					long diff = pocket[i+K-1] - pocket[i];
					result = Math.min(result, diff);
				}
			}
			System.out.printf("#%d %d\n", idx++, result);
		}
	}
	

}