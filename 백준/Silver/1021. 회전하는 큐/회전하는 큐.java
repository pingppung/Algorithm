import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    
    	int n = Integer.parseInt(st.nextToken());
    	int m = Integer.parseInt(st.nextToken());
    	
    	int[] arr = new int[m];
    	LinkedList<Integer> deque = new LinkedList<>();

    	st = new StringTokenizer(br.readLine());
    	for(int i = 0; i < m; i++) {
   			arr[i] = Integer.parseInt(st.nextToken());
    	}
    	for(int i = 1; i <= n; i++) {
    		 deque.offer(i);
    	}
    	int cnt = 0;
    	for(int i = 0; i < m; i++) {
    		while(deque.peek() != arr[i]) {
    			int idx = deque.size() / 2;
    			if(deque.indexOf(arr[i]) <= idx) {
    				cnt++;
    				int num = deque.pollFirst();
    				deque.add(num);
    			} else {
    				cnt++;
    				int num = deque.pollLast();
    				deque.addFirst(num);
    			}
    		}
    		deque.poll();
    	}
    	System.out.println(cnt);
    }
}
