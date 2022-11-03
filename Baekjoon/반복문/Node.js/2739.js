const input = require('fs').readFileSync('/dev/stdin').toString();
const n = Number(input[0]);
for(let i = 1; i < 10; i++){
    console.log(n, '*', i, '=', n*i);
}