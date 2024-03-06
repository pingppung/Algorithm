import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    	int n = Integer.parseInt(br.readLine());
    	PriorityQueue<Integer> vote = new PriorityQueue<>(Collections.reverseOrder());
    	int dasom = Integer.parseInt(br.readLine());
    	for(int i = 1; i < n; i++) {
    		vote.add(Integer.parseInt(br.readLine()));
    	}
    	int count = 0;
    	while (!vote.isEmpty() && vote.peek() >= dasom) {
    		count++;
    		dasom++;
    		vote.add(vote.poll()-1);
        }
    	System.out.println(count);
    }
} 