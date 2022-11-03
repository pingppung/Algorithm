const [A,B] = require('fs').readFileSync('/dev/stdin').toString().split('\n').map(Number);
console.log(A*(B%10));
console.log(A*parseInt((B%100)/10));
console.log(A*parseInt((B/100)));
console.log(A*B);