import java.util.*;
class Solution {
    static class Homework{
        String name;
        int start, playtime;
        public Homework(String name, int start, int playtime){
            this.name = name;
            this.start = start;
            this.playtime = playtime;
        }
        public Homework(String name, int playtime){
            this.name = name;
            this.playtime = playtime;
        }
    }
    public String[] solution(String[][] plans) {
        List<String> answer = new ArrayList<>();
        
        PriorityQueue<Homework> pq = new PriorityQueue<>(
            (o1, o2)-> (o1.start - o2.start));
        Stack<Homework> stop = new Stack<>();
        
        for(int i = 0; i < plans.length; i++){
            String name = plans[i][0];
            //int start = Integer.parseInt(plans[i][1].replace(":",""));
            String[] str = plans[i][1].split(":");
            int h = Integer.parseInt(str[0]);
            int m = Integer.parseInt(str[1]);
            int start = (h * 60) + m;
            int playtime  = Integer.parseInt(plans[i][2]);
            pq.add(new Homework(name, start, playtime));
        }
        
        while(!pq.isEmpty()){
            Homework hw = pq.poll();
            String name = hw.name;
            int start = hw.start;
            int playtime = hw.playtime;
            
            int current = start;
            if(!pq.isEmpty()){
                Homework next = pq.peek();
                //현재 과제 끝내고 다음 과제 시작 전 시간 남을 때
                if(current+playtime < next.start){   
                    answer.add(name);
                    current += playtime;
                    while(!stop.isEmpty()){
                        Homework st = stop.pop();
                        //다음 과제 시작 전 끝낼 수 있는 경우
                        if(current + st.playtime <= next.start){
                            current += st.playtime;
                            answer.add(st.name);
                            continue;
                        } else{ //다음 과제 시작 전까지 끝낼 수 없는 경우
                            int remain = st.playtime - (next.start - current);
                            stop.push(new Homework(st.name, remain));
                            break;
                        }
                    }
                } else if(current+playtime == next.start) { //다음 과제 시작시간에 딱 끝났을 때
                    answer.add(name);
                    continue;
                    
                } else{ //못끝냈을 경우
                    int remain = playtime - (next.start - current);
                    stop.push(new Homework(name, remain));
                }
            } else{
                if(!stop.isEmpty()){
                    answer.add(name);
                    
                    while(!stop.isEmpty()){
                        Homework st = stop.pop();
                        answer.add(st.name);
                    }
                }else{
                    current += playtime;
                    answer.add(name);
                }
            }
            
        
        }
        //String[] result = 
        return answer.toArray(new String[answer.size()]);
    }
}