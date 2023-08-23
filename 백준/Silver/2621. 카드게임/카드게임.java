import java.io.*;
import java.util.*;
import java.util.Map.Entry;

//2621
public class Main {

	static int max = 0, result = 0;
	static boolean dup = false;
	static Map<Character, Integer> colors = new HashMap<>();
	static Map<Integer, Integer> numbers = new HashMap<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < 5; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			char color = st.nextToken().toCharArray()[0];
			int num = Integer.valueOf(st.nextToken());
			max = Math.max(max, num); // 가장 높은 점수 저장
			colors.put(color, colors.getOrDefault(color, 0) + 1);
			numbers.put(num, numbers.getOrDefault(num, 0) + 1);
		}
//		});
		boolean chkContin = chkContinuous();

		List<Integer> num_freq = new ArrayList<>(numbers.keySet()); 

		Collections.sort(num_freq, (o1, o2) -> (numbers.get(o2).compareTo(numbers.get(o1)))); 
		result = calScore(num_freq, chkContin);
		System.out.println(result);
	}

	public static int calScore(List nums, boolean chkContin) {
		int Max_score = 0;
		int score = 0;
		List<Integer> freq_list = new ArrayList<>();
		for(Object key : nums) {
			freq_list.add((Integer) numbers.get(key));
		}
		// 1(카드 5장 다 같은색, 연속적 숫자)
		if (colors.size() == 1 && chkContin) {
			// 가장 높은 숫자+900
			score = max + 900;
			Max_score = Math.max(Max_score, score);
		}
		// 2(카드 5장 중 4장이 숫자 같을때)
		else if (freq_list.get(0) == 4) {
			// 같은 숫자+800
			score = findNum(freq_list.get(0))+800;
			Max_score = Math.max(Max_score, score);
		}
		// 3(5장 중 3장의 숫자가 같고, 나머지 2장이 서로 같을 때)
		else if (numbers.get((int) nums.get(0)) == 3 && numbers.get((int) nums.get(1)) == 2) {
			// 3장 짜리 숫자*10+2장짜리 숫자+700
			score = findNum(freq_list.get(0))*10+findNum(freq_list.get(1))+700;
			Max_score = Math.max(Max_score, score);
		}
		// 4(카드 5장 다 같은색)
		else if (colors.size() == 1) {
			// 가장 높은 숫자+500
			score = max+600;
			Max_score = Math.max(Max_score, score);
		}
		// 5(카드 5장 다 연속적)
		else if (chkContin) {
			// 가장 높은 숫자+500
			score = max+500;
			Max_score = Math.max(Max_score, score);
		}
		// 6(3장의 숫자가 같을때)
		else if (freq_list.get(0) == 3) {
			// 같은+400
			score = findNum(freq_list.get(0))+400;
			Max_score = Math.max(Max_score, score);
		}
		// 7(카드 5장 중 2장의 숫자가 같고, 나머지 3장 중 2장의 숫자도 같을때)
		else if (freq_list.get(0) == 2 && freq_list.get(1) == 2) {
			// 같은 숫자 중 높은 수 *10+ 더 작은 수 +300
			int n1 = findNum(freq_list.get(0));
			dup = true;
			int n2 = findNum(freq_list.get(1));
			
			score = Math.max(n1, n2)*10+ Math.min(n1, n2)+300;
			Max_score = Math.max(Max_score, score);
		}
		// 8(2장의 숫자가 같을때)
		else if (freq_list.get(0) == 2) {
			// 같은 숫자 + 200
			score = findNum(freq_list.get(0))+200;
			Max_score = Math.max(Max_score, score);
		}
		
		// 9(위의 조건들 해당안될때)
		else {
			// 가장 큰 숫자 + 100
			Max_score = max + 100;
		}
		
		
		return Max_score;

	}

	public static boolean chkContinuous() {
		List<Integer> nums = new ArrayList<>(numbers.keySet());
		Collections.sort(nums, Collections.reverseOrder()); //숫자 연속적인지 확인용
		
		if (numbers.size() < 5) { // 숫자가 연속적일 조건에서 5장 모두 다 이기 때문에
			return false;
		}
		int num = (int) nums.get(0);
		for (int i = 1; i < 5; i++) {
			if ((int) nums.get(i) != num - 1)
				return false; // 내림차순이여서 다음 인덱스는 -1씩
			num = (int) nums.get(i);
		}
		return true;
	}
	public static int findNum(int freq) {
		for(Integer key : numbers.keySet()) {
			if(dup) {
				dup = false;
				continue;
			}
		    if(numbers.get(key).equals(freq)) { 
		      return key;
		    }
		  }
		return -1;
		
	}
}
