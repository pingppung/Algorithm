const input = require("fs").readFileSync('/dev/stdin').toString().trim().split("\n");
let result = '';
for(let i = 0; i < input.length; i++){
    let num = input[i].split(' ');
    result += Number(num[0])+Number(num[1]) +"\n";
}
console.log(result);