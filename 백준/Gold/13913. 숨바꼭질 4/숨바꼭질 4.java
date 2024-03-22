import java.io.*;
import java.util.*;
public class Main {
	static int[] map = new int[100001];
	static int[] time = new int[100001];
	
    public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	int n = Integer.parseInt(st.nextToken());
    	int k = Integer.parseInt(st.nextToken());
    	find(n, k);
    	Stack<Integer> stack = new Stack<>();
        stack.push(k);
        int index = k;
        while (index != n) {
            stack.push(map[index]);
            index = map[index];
        }
        StringBuilder sb = new StringBuilder();
        sb.append(time[k] - 1 + "\n");
        while (!stack.isEmpty()) {
            sb.append(stack.pop() + " ");
        }

        System.out.println(sb.toString());
    	
    }
    private static void find(int n, int k) {
    	Queue<Integer> q= new LinkedList<>();
    	q.offer(n);
    	time[n] = 1;
    	while(!q.isEmpty()) {
    		int num = q.poll();
    		if(num == k) return;
        	int[] moves = { num-1, num+1, 2*num};
        	for(int move : moves) {
        		if(move < 0 || move > 100000) continue;
        		if(time[move] == 0) {
        			q.offer(move);
        			time[move] = time[num] + 1;
        			map[move] = num;
        		}
        	}
    	}
    }
}  