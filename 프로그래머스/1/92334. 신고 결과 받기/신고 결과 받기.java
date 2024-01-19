import java.util.*;
class Solution {

    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        Map<String, List<String>> complaint = new HashMap(); //유저 id , {신고한 id들}
        Map<String, Integer>  warningCnt = new HashMap();//유저 id , 신고당한 횟수
        for(String names : report){
            String[] name = names.split(" ");
            List<String> details = complaint.getOrDefault(name[0], new ArrayList<>());
            if(details.contains(name[1])) continue;
            details.add(name[1]);
            complaint.put(name[0], details);
            warningCnt.put(name[1], warningCnt.getOrDefault(name[1], 0)+1);
        }
        for(int i = 0; i < id_list.length; i++){
            if(warningCnt.getOrDefault(id_list[i], 0) >= k){
                for(int j = 0; j < id_list.length; j++){
                    if(id_list[i].equals(id_list[j])) continue;
                    List<String> details = complaint.getOrDefault(id_list[j], new ArrayList<>());
                    if(details != null && details.contains(id_list[i])) {
                        answer[j]++; 
                    }
                }
            }
        }
        return answer;
    }
}