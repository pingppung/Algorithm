let input = require("fs").readFileSync('/dev/stdin').toString().trim().split("\n");
const n = input[0];
const score = input[1].split(" ").map(Number);
let sum = 0;

const max = Math.max(...score);
for (let i = 0; i < n; i++) {
    sum += score[i] / max * 100;
}
console.log(sum / n);