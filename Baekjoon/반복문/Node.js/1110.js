const input = Number(require("fs").readFileSync('/dev/stdin').toString());
let sum = 0;
let num = input;
let i = 0;
while(true){
    i++;
    sum = Math.floor(num / 10) + num %10;
    num = (num % 10) *10 + sum % 10;
    if(num === input)
        break;
}
console.log(i);
