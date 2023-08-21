import java.io.*;
import java.util.*;

public class Main {
	static int count = 0;
	static int[] word = new int[26];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int count = 0;
		int n = Integer.parseInt(br.readLine());
		String[] arr = new String[n];
		for(int i = 0; i < n; i++) {
			arr[i] = br.readLine();
 		}

		//같은 구성을 가질 때 비슷한단어
		//한문자를 더하거나, 뺴거나, 하나의 문자를 다른 문자로 바꾸어 같은 구성을 갖게 될 때 비슷한 단어
		for(int i = 1; i < n; i++) {
			if(CompareW(arr[0], arr[i])) {
				count++;
			}
			
		}
		System.out.println(count);
	}
	public static boolean CompareW(String s1, String s2) {
		int diff = 0;
		List<Character> list = new LinkedList<>();
		for(int i = 0; i < s1.length(); i++) {
			list.add(s1.charAt(i));
		}
		for(int i = 0; i < s2.length(); i++) { 
			if(list.contains(s2.charAt(i))) {
				list.remove(Character.valueOf(s2.charAt(i)));
				diff++;
			}
		}
		//문자열 길이가 같은 경우 같은 구성이거나 한글자만 다를 때
		if(s1.length() == s2.length() && (list.size() == 0 || s1.length()-1 == diff)) { 
			return true;
		} else if(s1.length() == s2.length()+1 && s2.length() == diff) { //첫번째 문자열이 더 긴 경우 - 추가
			return true;
		} else if(s1.length() == s2.length()-1 && s2.length() -1 == diff) {//첫번째 문자열이 더 짧은 경우 - 제거
			return true;
		}
		return false;
		
	}

}
