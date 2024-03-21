import java.io.*;
import java.util.*;
public class Main {
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
    	int t = Integer.parseInt(br.readLine());
    	while(t--> 0) {
    		StringTokenizer st = new StringTokenizer(br.readLine());
    		int a = Integer.parseInt(st.nextToken());
    		int b = Integer.parseInt(st.nextToken());

    		visited = new boolean[10000];
    		System.out.println(change(a,b));
    	}
    }
    private static String change(int a, int b) {
    	char[] commands = {'D', 'S', 'L', 'R'};
    	
    	Queue<Node> q = new LinkedList<>();
    	q.offer(new Node(a, ""));
    	visited[a] = true;
    	while(!q.isEmpty()) {
    		Node n = q.poll();

			if(n.register == b) return n.result;
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