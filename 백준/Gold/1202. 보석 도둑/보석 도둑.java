import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		List<int[]> jewelry = new ArrayList<>();
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int weight = Integer.parseInt(st.nextToken());
			int price = Integer.parseInt(st.nextToken());
			
			jewelry.add(new int[] {weight, price});
		}
		jewelry.sort((a, b) -> a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]);
		
		int[] bags = new int[K];
		for (int i = 0; i < K; i++) {
			bags[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(bags);
		
		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
		int idx = 0;
		long max_Price = 0;

		for (int i = 0; i < K; i++) {
			int bagWeight = bags[i];

			while (idx < N && jewelry.get(idx)[0] <= bagWeight) {
				pq.offer(jewelry.get(idx)[1]);
				idx++;
			}

			if (!pq.isEmpty()) {
				max_Price += pq.poll();
			}
		}

		System.out.println(max_Price);
	}
	
}
