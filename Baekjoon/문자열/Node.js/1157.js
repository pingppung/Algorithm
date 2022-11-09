let input = require("fs").readFileSync("/dev/stdin").toString().trim();
let s = input.toUpperCase().split('');

function solution(s){
    let word = [];
    s.map((i) => {
        const idx = word.findIndex(obj => obj.w == i);
        idx == -1 ? word.push({ w: i, count: 1}) : ++word[idx].count; 
    });
    let result = '';
    let max = 0;
    word.map((item) => {
        if(item.count > max){
            max = item.count;
            result = item.w;
        }
        else if(item.count === max)
            result = "?";
    });
    return result;
}
console.log(solution(s));



