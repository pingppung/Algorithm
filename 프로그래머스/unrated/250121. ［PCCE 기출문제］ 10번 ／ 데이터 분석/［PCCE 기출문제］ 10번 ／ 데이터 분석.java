import java.util.*;
class Solution {
    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        List<int[]> answer = new ArrayList<>();
        HashMap<String, Integer> condition = new HashMap<>();
        condition.put("code", 0);
        condition.put("date", 1);
        condition.put("maximum", 2);
        condition.put("remain", 3);

        for(int i = 0; i < data.length; i++){
            int ext_idx = condition.get(ext);
            int comparison_target = data[i][ext_idx];
            if(comparison_target < val_ext){
                System.out.println(Arrays.toString(data[i]));
                answer.add(data[i]);
            }
        }
        
       int sort_idx = condition.get(sort_by);
        return answer.stream()
            .sorted(Comparator.comparingInt(arr -> arr[sort_idx]))
            .toArray(int[][]::new);
    }
}