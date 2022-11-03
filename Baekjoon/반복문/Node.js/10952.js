const input = require("fs").readFileSync('/dev/stdin').toString().split("\n");
let result = '';
for(let i = 0; i < input.length; i++){
    let num = input[i].split(' ');
    if(num[0] == 0 && num[1] == 0)
        break;
    result += Number(num[0])+Number(num[1]) +"\n";
}
console.log(result);