const input = require("fs").readFileSync("/dev/stdin").toString().trim();

let i = 1;
let range = 1;

while(i <input) {
    i += 6 * range;
    range++;
}
console.log(range);

