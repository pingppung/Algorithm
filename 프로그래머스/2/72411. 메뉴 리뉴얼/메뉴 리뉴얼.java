import java.util.*;
class Solution {
    static HashMap<String, Integer> menu = new HashMap<>();
    static int max;
    
    public String[] solution(String[] orders, int[] course) {
        List<String> answer = new ArrayList<>();
        int[] max_Order = new int[course.length];
        
        for (int i = 0; i < orders.length; i++) {
			char[] arr = orders[i].toCharArray();
			Arrays.sort(arr);
			orders[i] = String.valueOf(arr);
		}
        for (int i = 0; i < course.length; i++) {
            for (int j = 0; j < orders.length; j++){
                combin(orders[j], "", course[i]);
            }
            if (!menu.isEmpty()) {
                List<Integer> countList = new ArrayList<>(menu.values());
                int max = Collections.max(countList);

                if (max > 1)
                    for (String key : menu.keySet())
                        if (menu.get(key) == max)
                            answer.add(key);
                menu.clear();
            }
        }
//         for (int i = 0; i < course.length; i++) {
//                 max = 0;
// 				combin(s, "", course[j]);
//                 max_Order[j] = max;
// 			}
//         for (String s : menu.keySet()){
//             for (int i = 0; i < course.length; i++){
//                 if (course[i] == s.length() && max_Order[i] > 1 && menu.get(s) == max_Order[i]){
//                     answer.add(s);
                    
//                 }
//             }
//         }
        
        return answer.stream().sorted().toArray(String[]::new);
    }
    private static void combin(String order, String s, int count){
        if(s.length() == count){
            menu.put(s, menu.getOrDefault(s, 0)+1);
            max = Math.max(max, menu.get(s));
            return;
        }
        for(int i = 0; i < order.length(); i++){
            combin(order.substring(i+1), s + order.charAt(i), count);
        }
    }
}