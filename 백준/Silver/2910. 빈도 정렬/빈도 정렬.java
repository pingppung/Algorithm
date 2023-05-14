import java.io.*;
import java.util.*;
public class Main {
	static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    
    	int n = Integer.parseInt(st.nextToken());
    	int c = Integer.parseInt(st.nextToken());
    	
    	HashMap<Integer,Integer> map = new LinkedHashMap<>();
    	st = new StringTokenizer(br.readLine());
    	for(int i = 0; i < n; i++) {
    		int num = Integer.parseInt(st.nextToken());
    		map.put(num, map.getOrDefault(num, 0)+1);
    	}
    	ArrayList<Integer> list = new ArrayList<Integer>(map.keySet());
    	Collections.sort(list, new Comparator<Integer>() {
			@Override
			public int compare(Integer a, Integer b) {
				return Integer.compare(map.get(b), map.get(a));
			}
		});
    	Iterator<Integer> it = list.iterator();
        while (it.hasNext()) {
            Integer element = it.next();
            for(int i=0; i<map.get(element); i++){
                sb.append(element+" ");    
            }

        }
        System.out.println(sb);
    }
}
