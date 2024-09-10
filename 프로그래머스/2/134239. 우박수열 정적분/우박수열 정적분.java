import java.util.*;

class Solution {
    double[] area;
    public double[] solution(int k, int[][] ranges) {
        List<Double> answer = new ArrayList<>();
        List<Integer> nums = Collatz(k);
        
//         // nums 길이가 1이면 바로 빈 배열 반환
//         if (nums.length == 1) {
//             return new double[ranges.length];  // 0으로 채워진 배열 반환
//         }
        
        calArea(nums);
        for(int[] range :  ranges){
            int start = range[0];
            int end = nums.size() - 1 + range[1];
            double size = calResult(start, end);
            answer.add(size);
        }
        return answer.stream().mapToDouble(d -> d).toArray();
        
    }
    //콜라츠 추측
    public List<Integer> Collatz(int n){
        List<Integer> nums = new ArrayList<>();
        nums.add(n);
        while(n > 1){
            if(n % 2 == 0){ //1-1.입력된 수가 짝수라면 2로 나눕니다.
                n /= 2;
            } else { //1-2. 입력된 수가 홀수라면 3을 곱하고 1을 더합니다.
                n = n * 3 + 1;
            }
            nums.add(n);
        }
        return nums;
    }
    //구간별 면적 구하는 메소드
    public void calArea(List<Integer> nums){
        area = new double[nums.size()-1];
        for(int i = 0; i < nums.size()-1; i++){
            double size = (nums.get(i) + nums.get(i+1)) / 2.0;
            area[i] = size;
            if(i > 0) area[i] += area[i-1];
        }
    }
    
    // 정적분 결과 구하는 메서드
    public double calResult(int start, int end) {
        // 배열 범위 초과 처리
        if (start > end) return -1;
        if(start == end) return 0;
        
        // end와 start가 범위를 벗어나지 않도록 처리
        // end = Math.min(end, area.length);
        // start = Math.min(start, area.length);
        
        if (start == 0) return area[end - 1];
        else return area[end -1] - area[start - 1];
        
    }
}
