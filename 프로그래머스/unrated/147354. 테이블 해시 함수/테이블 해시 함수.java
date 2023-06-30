import java.util.*;
class Solution {
    public int solution(int[][] data, int col, int row_begin, int row_end) {
        int answer = 0;
        Arrays.sort(data, new Comparator<int[]>(){
            public int compare(int[] o1, int[] o2){
                if(o1[col-1] == o2[col-1])
                    return o2[0] - o1[0]; //같을 시 첫번째 컬럼의 값으로 기준으로 내림차순
                else return o1[col-1] - o2[col-1]; //col번째 컬럼의 값을 기준으로 오름차순
            }
        });
        int xor = 0;
        for(int i = row_begin; i <= row_end; i++){
            int sum = 0;
            for(int j = 0; j < data[0].length; j++){
                sum += (data[i-1][j]%i);
            }
            xor ^= sum;
        }
        
        return xor;
    }
}
