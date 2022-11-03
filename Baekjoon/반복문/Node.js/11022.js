let input = require("fs").readFileSync('/dev/stdin').toString().split("\n");
let n = Number(input[0]);
let answer = '';
for(let i = 1; i <= n; i++) {
    let num = input[i].split(' ');
    answer += "Case #"+ i +": " + num[0] + " + " +num[1] + " = " + (Number(num[0])+Number(num[1])) +"\n";
}
console.log(answer);