const input = require("fs").readFileSync('/dev/stdin').toString().split("\n");
const x = Number(input[0].split(' ')[1]);
const array = input[1].split(' ');
let result = '';
array.map((i,idx) => x>i ? result += i +" " : 0);
console.log(result);