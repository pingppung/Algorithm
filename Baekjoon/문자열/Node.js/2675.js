let input = require("fs").readFileSync('/dev/stdin').toString().trim().split("\n");
const n = input[0];
let result = "";
for(let i = 1; i <= n; i++){
    let [r, s] = input[i].trim().split(' ');
    s = s.split('');
    for(let j = 0; j < s.length; j++){
        result += s[j].repeat(r);
    }
    result += "\n";
}

console.log(result);