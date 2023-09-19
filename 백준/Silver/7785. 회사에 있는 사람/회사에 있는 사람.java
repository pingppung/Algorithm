import java.io.*;
import java.util.*;
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(br.readLine());
		HashSet<String> set = new HashSet<>();
		for(int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String name = st.nextToken();
			String log = st.nextToken();
			if (set.contains(name)) set.remove(name);
			else set.add(name);
			
		}
		ArrayList<String> list = new ArrayList<String>(set);
		Collections.sort(list, Collections.reverseOrder());
		for(String name : list) {
			System.out.println(name);
		}
	}
}
