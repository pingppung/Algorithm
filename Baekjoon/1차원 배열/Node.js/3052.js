let input = require("fs").readFileSync('/dev/stdin').toString().trim().split("\n").map(Number);
for (let i = 0; i < input.length; i++) {
    input[i] = input[i] % 42;
}
input = [...new Set(input)];
console.log(input.length);