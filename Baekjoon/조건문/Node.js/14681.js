const readline = require("readline");
const rl = readline.createInterface({
  input: process.stdin,
  output: process.stdout,
});

let input = [];

rl.on("line", function (line) {
  input.push(line);
}).on("close", function () {
  if(input[0] > 0){
    console.log(input[1] > 0 ? 1 : 4);
} else {
    console.log(input[1] > 0 ? 2 : 3);
} 
  process.exit();
});
 