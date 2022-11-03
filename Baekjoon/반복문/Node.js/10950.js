const input = require('fs').readFileSync('/dev/stdin').toString().split('\n');
const n = Number(input[0]);

for(let i = 1; i <= n; i++){
    console.log(Number(input[i].split(' ')[0])+Number(input[i].split(' ')[1]));
}