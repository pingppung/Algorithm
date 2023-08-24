import java.io.*;
import java.util.*;
public class Main {
	static int n, w, L;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		 
		n = Integer.parseInt(st.nextToken());
		w = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		
		Queue<Integer> truck = new LinkedList<Integer>();
		st = new StringTokenizer(br.readLine());
		for(int i= 0; i< n; i++) {
			truck.offer(Integer.parseInt(st.nextToken()));
		}
		
		int sum = 0;
		int time = 0;
		Queue<Integer> bridge = new LinkedList<>();
		
		for(int i = 0; i < w ; i++) {
			bridge.add(0);
		}
		while(!bridge.isEmpty()) {
			sum -= bridge.poll();
			time++;
			if(!truck.isEmpty()) {
				if(truck.peek() + sum <= L) {
					sum += truck.peek();
					bridge.offer(truck.poll());
				}else {
					bridge.offer(0);
				}
			}
		}
		System.out.println(time);
		
	}
	

}
