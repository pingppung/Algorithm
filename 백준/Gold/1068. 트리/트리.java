import java.io.*;
import java.util.*;
public class Main {
	static int n, result = 0;
	static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	n = Integer.parseInt(br.readLine());
    	for(int i = 0; i < n; i++) {
    		graph.add(new ArrayList<>());
    	}

    	StringTokenizer st = new StringTokenizer(br.readLine());
    	int root = -1;
    	for(int i = 0; i < n; i++) {
    		int parent = Integer.parseInt(st.nextToken());
    		if(parent == -1) root = i;
    		else graph.get(parent).add(i);
    	}
    	int remove = Integer.parseInt(br.readLine());
    	if(remove == root) {
    		System.out.println(0);
    		return;
    	}
    	removeNode(remove);
    	chkLeaf(root);
    	System.out.println(result);
    }
    private static void removeNode(int num) {
    	for (int i = 0; i < graph.size(); i++) {
            if (graph.get(i).contains(num)) {
                graph.get(i).remove(Integer.valueOf(num));
            }
        }
    }
    private static void chkLeaf(int num) {
    	ArrayList<Integer> childs = new ArrayList<>(graph.get(num));
    	if(childs.size() == 0) {
    		result++;
    		return;
    	}
    	else {
    		for(int child : childs) {
    			chkLeaf(child);
    		}
    	}
    }
}