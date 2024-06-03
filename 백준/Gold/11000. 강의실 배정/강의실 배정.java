import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	int n = Integer.parseInt(br.readLine());
    	PriorityQueue<long[]> classes = new PriorityQueue<>(Comparator.comparingLong(a -> a[0]));
    	for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            long startTime = Long.parseLong(st.nextToken());
            long endTime = Long.parseLong(st.nextToken());
            classes.offer(new long[]{startTime, endTime});
        }
    	
    	int room = 0;
        PriorityQueue<Long> endTimes = new PriorityQueue<>();

        while (!classes.isEmpty()) {
            long[] current = classes.poll();
            long startTime = current[0];
            long endTime = current[1];

            if (!endTimes.isEmpty() && endTimes.peek() <= startTime) {
                endTimes.poll();
            } else room++; 
            endTimes.offer(endTime);
    	}
    	System.out.println(room);
    }
}