import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());

    	int w = Integer.parseInt(st.nextToken());
    	int h = Integer.parseInt(st.nextToken());
    	
    	int n = Integer.parseInt(br.readLine());
    	ArrayList<Integer> warr = new ArrayList<>();
    	ArrayList<Integer> harr = new ArrayList<>();
    	warr.add(0);
		harr.add(0);
    	for(int i = 0; i < n; i++) {
    		st = new StringTokenizer(br.readLine());
    		int type = Integer.parseInt(st.nextToken());
    		int num = Integer.parseInt(st.nextToken());
    		if(type == 0) {
    			warr.add(num);
    		} else if(type == 1) {
    			harr.add(num);
    		}
    	}

		Collections.sort(warr);
		Collections.sort(harr);
		warr.add(h);
		harr.add(w);
		int wmax = 0;
		int hmax = 0;
		for(int i = 1; i < warr.size(); i++) {
			wmax = Math.max(wmax, warr.get(i) - warr.get(i-1));
		}
		for(int i = 1; i < harr.size(); i++) {
			hmax = Math.max(hmax, harr.get(i) - harr.get(i-1));
		}
		
		System.out.println(wmax * hmax);
    }
}
