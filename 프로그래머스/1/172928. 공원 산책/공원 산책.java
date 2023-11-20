class Solution {
    private int h, w;
    public int[] solution(String[] park, String[] routes) {
        h = park.length;
        w = park[0].length();
        
        char[][] map = new char[h][w];
        int s_x =0, s_y =0;
        for(int i = 0; i < h; i++){
            map[i] = park[i].toCharArray();
            if(park[i].contains("S")){
                s_y = park[i].indexOf("S");
                s_x = i;
            }
        }
        int[] newPos = moveWalk(map, routes, s_x, s_y);
        return newPos;
    }
    public int[] moveWalk(char[][] map, String[] routes, int s_x, int s_y){
        
        for(String route : routes){
            String op = route.split(" ")[0];
            int n = Integer.parseInt(route.split(" ")[1]);
            
            int xx = s_x;
            int yy = s_y;
            
            for(int i = 0; i < n; i++){
                if(op.equals("E")){
                    yy++;
                }
                if(op.equals("W")){
                    yy--;
                }
                if(op.equals("S")){
                    xx++;
                }
                if(op.equals("N")){
                    xx--;
                }
                if(xx >=0 && yy >=0 && xx < h && yy < w){
                    if(map[xx][yy] == 'X'){
                        break;
                    }
                    if(i == n-1){
                        s_x = xx;
                        s_y = yy;
                    }
                }
            }
        }       
        return new int[]{s_x, s_y};
    }
}