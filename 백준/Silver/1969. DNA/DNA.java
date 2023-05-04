import java.io.*;
import java.util.*;
import java.util.Map.Entry;
public class Main {
    public static void main(String[] args) throws IOException{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	
    	int n = Integer.parseInt(st.nextToken());
    	int m = Integer.parseInt(st.nextToken());
    	String[] s = new String[n];
    	for(int i = 0; i < n; i++) {
    		s[i] = br.readLine();
    	}
    	int sum = 0;
    	String t = "";
    	for(int i = 0; i < m; i++) {
    		HashMap<Character, Integer> map = new HashMap<>();
    		for(int j = 0; j < n; j++) {
    			char c = s[j].charAt(i);
    			map.put(c, map.getOrDefault(c, 0) + 1);
    		}
    		Iterator<Entry<Character, Integer>> it = map.entrySet().iterator();
    		
    		int max = 0 ;
    		char ch = ' ';
    		while(it.hasNext()) {
    			Entry<Character, Integer> entrySet = (Entry<Character, Integer>)it.next();

				char key =  entrySet.getKey();
				int value = entrySet.getValue();
				if(max < value) {
					max = value;
					ch = key;
				} else if(max == value) {
					char tmp = key;

					int num1 = Character.getNumericValue(ch);
					int num2 = Character.getNumericValue(tmp);

					if(num1 > num2) {
						ch = tmp;
					}
				}
    		}
    		t += ch;
    		sum += n- max;
    	}
    	System.out.println(t);
    	System.out.println(sum);
    }
}
