import java.util.*;
import java.text.*;
class Solution {
    
    static Map<String, String> cars = new HashMap<>(); //차번호, 시간
    static Map<String, Integer> times = new HashMap<>();
    
    static ArrayList<String> seq = new ArrayList<>();
    public int[] solution(int[] fees, String[] records) throws Exception {
        for(int i = 0; i < records.length; i++){
            String[] car = records[i].split(" ");
            if(car[2].equals("IN")){
                cars.put(car[1], car[0]);
                if(!seq.contains(car[1])) seq.add(car[1]);  //차량 번호 작은 자동차부터 정렬하기 위해서
            } else {
                calDiff(car[1], cars.get(car[1]), car[0]);
                cars.remove(car[1]);
            }
        } 
        if(!cars.isEmpty()){ //출차 내역 없는 차들 시간 계산
            for(String num : cars.keySet()) {
                calDiff(num, cars.get(num), "23:59");
            }
        }
        Collections.sort(seq);
        ArrayList<Integer> answer = new ArrayList<>();
        for(String car_number : seq) {  
            if(times.get(car_number) <= fees[0])
                answer.add(fees[1]);
            else{
                double addTime = times.get(car_number) - fees[0];
                addTime = Math.ceil(addTime/fees[2]);
                int fee = (int)(addTime*fees[3] + fees[1]);
                answer.add(fee);
            }
        }
//         for(String key : times.keySet()) {  //누적 시간으로 요금 계산하기
//             if(times.get(key) <= fees[0])
//                 answer.add(fees[1]);
//             else{
//                 double addTime = times.get(key) - fees[0];
//                 addTime = Math.ceil(addTime/fees[2]);
                
//             //System.out.println(diff);
//                 int fee = (int)(addTime*fees[3] + fees[1]);
//                 answer.add(fee);
//             }
//         }
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
    static void calDiff(String carNum, String in, String out) throws Exception{
        DateFormat format = new SimpleDateFormat("HH:mm");
        Date in_time = format.parse(in);
        Date out_time = format.parse(out);
                
        int diff = (int)((out_time.getTime() - in_time.getTime()) / 60000);
        times.put(carNum, times.getOrDefault(carNum, 0)+diff);
    }
}