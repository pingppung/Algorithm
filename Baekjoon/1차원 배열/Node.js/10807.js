const input = require("fs").readFileSync('/dev/stdin').toString().split("\n");
let count = 0;
let array = input[1].split(' ');
array.map((i, idx) => i === input[2] ? count++ : count);
console.log(count);
