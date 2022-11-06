const input = require("fs").readFileSync('/dev/stdin').toString().split("\n").map(Number);
for(let i = 1; i <= 30; i++){
    if(!input.includes(i))
        console.log(i);
}