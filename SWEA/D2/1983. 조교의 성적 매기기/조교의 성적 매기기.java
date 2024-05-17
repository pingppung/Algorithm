import java.io.*;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
public class Solution {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		String[] grade = {"A+", "A0","A-","B+","B0","B-","C+", "C0", "C-", "D0"};
		int idx = 1;
		while(T-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			double target_score = 0;
			ArrayList<Double> ranks = new ArrayList<>();
			for(int i = 1; i <= N; i++) {
				int[] scores = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::valueOf).toArray();
				double total = 0.35 * scores[0] + 0.45 * scores[1] + 0.20 * scores[2];
				ranks.add(total);
				if(i == K) target_score = total;
			}
			Collections.sort(ranks, Collections.reverseOrder());
			int rank = ranks.indexOf(target_score) + 1;
			int gradeIndex = (int)Math.ceil((double)rank / (N / 10));
			System.out.printf("#%d %s\n", idx++, grade[gradeIndex-1]);
		}
	}

}