const input = require('fs').readFileSync('/dev/stdin').toString().split('\n');
const total = Number(input[0]);
const n = Number(input[1]);
let sum = 0;
for(let i = 2; i <= n+1; i++){
    sum += input[i].split(' ')[0] * input[i].split(' ')[1];
}
console.log(total === sum ? 'Yes' : 'No');