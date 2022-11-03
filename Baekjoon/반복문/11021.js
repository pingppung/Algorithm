let input = require("fs").readFileSync('/dev/stdin').toString().split("\n");
let n = Number(input[0]);
let answer = '';
for(let i = 1; i <= n; i++) {
    let result = 0;
    let num = input[i].split(' ');
    result += Number(num[0])+Number(num[1]);
    answer +="Case #"+ i +": " + result +"\n";
}
console.log(answer);