import java.io.*;
import java.util.*;
public class Main {
	static char[] commands = {'D', 'S', 'L', 'R'};
	static boolean[] visited;
	static class Node {
        int register;
        String result;
        
        public Node(int register, String result) {
            this.register = register;
            this.result = result;
        }
    }   
    public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	int T = Integer.parseInt(br.readLine());
    	while(T-- > 0) {
        	StringTokenizer st = new StringTokenizer(br.readLine());
        	int A = Integer.parseInt(st.nextToken());
        	int B = Integer.parseInt(st.nextToken());
        	visited = new boolean[10000];
        	System.out.println(bfs(A,B));
    	}
    }
    private static String bfs(int A, int B) {
    	Queue<Node> q = new LinkedList<>();
    	q.offer(new Node(A, ""));
    	visited[A] = true;
    	while(!q.isEmpty()) {
    		Node n = q.poll();
    		if(n.register == B) return n.result;
    		
    		for(int i = 0; i < 4; i++) {
    			char command = commands[i];
    			int change = -1;
    			if(command == 'D') {
    				change = D(n.register);
    			}
    			if(command == 'S') {
    				change = S(n.register);
    			}
    			if(command == 'L') {
    				change = L(n.register);
    			}
    			if(command == 'R') {
    				change = R(n.register);
    			}
    			
    			if(!visited[change]) {
    				visited[change] = true;
    				q.offer(new Node(change, n.result + commands[i]));
    			}
    		}
    	}
    	return "";
    }
    private static int D(int n) {
    	return (n*2) % 10000;
    }
    private static int S(int n) {
    	return n == 0 ? 9999 : n-1;
    }
    private static int L(int n) {
    	return (n % 1000) * 10 + n / 1000;
    }
    private static int R(int n) {
    	return (n % 10) * 1000 + n / 10;
    }
}  