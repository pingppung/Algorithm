import java.io.*;
import java.util.*;
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String word = br.readLine();
		String[] arr = new String[3];
		List<String> list = new ArrayList<>();
		for(int i = 1; i < word.length()-1; i++) {
			for(int j = i+1; j < word.length(); j++) {
				arr[0] = word.substring(0,i);
				arr[1] = word.substring(i,j);
				arr[2] = word.substring(j, word.length());
				StringBuilder sb = new StringBuilder();
				for(int k = 0; k < 3; k++) {
					StringBuilder reverse = new StringBuilder();
					reverse.append(arr[k]).reverse();
					sb.append(reverse);
    			}
				list.add(sb.toString());
			}
		}
		Collections.sort(list);
    	System.out.println(list.get(0));
		
	}
	
}
