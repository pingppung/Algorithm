import java.util.*;
class Solution {
    public int[] solution(long[] numbers) {
        ArrayList<Integer> answer = new ArrayList<>();
        for(long num : numbers){
            String binaryString = Long.toBinaryString(num);
            if(binaryString.equals("0")) {
                answer.add(0);
                continue;
            }
            String dummy = addDummy(binaryString);
            boolean result = chkTree(dummy);
            if(result) answer.add(1);
            else answer.add(0);
        }
        return answer.stream().mapToInt(Integer::valueOf).toArray();
    }
    private String addDummy(String num){
        int len = num.length();
        int fullLen = 1;
        while (fullLen < len) {
            fullLen = fullLen * 2 + 1;
        }
        int count = fullLen - len;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < count; i++) {
            sb.append('0');
        }
        sb.append(num);
        return sb.toString();
    }
    private boolean chkTree(String num) {
        return checkSubTree(num, 0, num.length() - 1);
    }

    private boolean checkSubTree(String num, int start, int end) {
        if (start >= end) return true;
        int mid = (start + end) / 2;
        char root = num.charAt(mid);
        if (root == '0') {
            for (int i = start; i <= end; i++) {
                if (num.charAt(i) == '1') return false;
            }
        }
        return checkSubTree(num, start, mid - 1) && checkSubTree(num, mid + 1, end);
    }
}