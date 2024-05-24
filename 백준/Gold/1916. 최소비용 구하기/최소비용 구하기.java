import java.io.*;
import java.util.*;
public class Main {
	static boolean[] visited;
	static ArrayList<ArrayList<int[]>> buses = new ArrayList<>();
    public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	int n = Integer.parseInt(br.readLine());
    	int m = Integer.parseInt(br.readLine());
    	visited = new boolean[n+1];
    	for(int i = 0; i <= n; i++) {
    		buses.add(new ArrayList<>());
    	}
    	StringTokenizer st;
    	for(int i = 0; i < m; i++) {
    		st = new StringTokenizer(br.readLine());
    		int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
    		buses.get(start).add(new int[] {end, cost});
    	}
    	int[] pos = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::valueOf).toArray();
    	int result = findRoad(pos);
    	System.out.println(result);
    }
    private static int findRoad(int[] pos) {
    	PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
    	pq.add(new int[] {pos[0], 0});
    	while(!pq.isEmpty()) {
    		int[] now = pq.poll();
    		if(now[0] == pos[1]) return now[1];
    		if(!visited[now[0]]) {
    			visited[now[0]] = true;
    			for(int[] target : buses.get(now[0])) {
    				pq.add(new int[] {target[0], target[1] + now[1]});
    			}
    		}
    	}
    	return -1;
    }
}