import java.io.*;
import java.util.*;
public class Main {
	static int[] arr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		PriorityQueue<Long> cards = new PriorityQueue<>();
		for(int i = 0; i < n; i++) {
			cards.add(Long.parseLong(br.readLine()));
		}
		
		int count = 0;
		while(cards.size() > 1) {
			long a = cards.poll();
			long b = cards.poll();
			count += a + b;
			cards.add(a + b);
		}
		System.out.println(count);
	}
}