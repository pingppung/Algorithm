import java.io.*;
import java.util.*;
public class Main {
	static int[] parent;
	static int[] time;
    public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	int N = Integer.parseInt(st.nextToken());
    	int K = Integer.parseInt(st.nextToken());
    	parent = new int[100001];
    	time = new int[100001];
    	
    	bfs(N, K);
    	
    	Stack<Integer> stack = new Stack<>();
        stack.push(K);
        int index = K;
        while (index != N) {
            stack.push(parent[index]);
            index = parent[index];
        }
        StringBuilder sb = new StringBuilder();
        sb.append(time[K] - 1 + "\n");
        while (!stack.isEmpty()) {
            sb.append(stack.pop() + " ");
        }

        System.out.println(sb.toString());
    }
    private static void bfs(int N, int K) {
    	Queue<Integer> q = new LinkedList<>();
    	q.add(N);
    	time[N] = 1;
    	while(!q.isEmpty()) {
    		int p = q.poll();
    		if(p == K) return;
    		int[] moves = {p + 1, p - 1, p * 2};
    		for(int move : moves) {
        		if(move < 0 || move > 100000) continue;
        		if(time[move] == 0) {
        			q.add(move);
        			time[move] = time[p] + 1;
        			parent[move] = p;
        		}
         	}
    	}
    	
    	
    }
}  