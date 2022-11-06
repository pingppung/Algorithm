const input = require("fs").readFileSync('/dev/stdin').toString().split("\n").map(Number);
const max = Math.max(...input);
console.log(max);
input.map((i, idx) => {
    i == max ? console.log(idx+1) : 0;
});