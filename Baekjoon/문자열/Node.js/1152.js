const input = require("fs").readFileSync('/dev/stdin').toString().trim().split(' ');
const a = input[0].split('').reverse().join('');
const b = input[1].split('').reverse().join('');
console.log(a>b ? a : b);