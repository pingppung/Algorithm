let [n, nums] = require("fs").readFileSync('/dev/stdin').toString().split('\n');
const num = nums.split('').map(Number);
let sum = num.reduce((acc, cur) => {return acc +=  cur; },0);
console.log(sum);