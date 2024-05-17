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
			int M = Integer.parseInt(st.nextToken());
			int[] A = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::valueOf).toArray();
			int[] B = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::valueOf).toArray();
			
			int min = Math.min(N, M);
			int max = Math.max(N, M);

			int result = 0;
			for(int i = 0; i <= max - min; i++) {
				int[] maxArr = (max == B.length) ? B : A;
				int[] minArr = (min == B.length) ? B : A;
				int[] temp = Arrays.copyOfRange(maxArr, i, i+min);
				int sum = 0;
				for(int j = 0; j < min; j++) {
					sum += (minArr[j] * temp[j]);
				}
				result = Math.max(result, sum);
			}

			System.out.printf("#%d %d\n", idx++, result);
		}
	}

}