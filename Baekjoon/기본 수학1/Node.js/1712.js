const [A, B, C] = require("fs").readFileSync("/dev/stdin").toString().trim().split(' ').map(Number);
let result = Math.floor(A/(C-B))+1;
console.log(C-B <= 0 ? -1 : result);