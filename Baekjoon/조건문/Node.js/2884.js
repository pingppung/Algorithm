const input = require('fs').readFileSync('/dev/stdin').toString().split(' ').map(Number);
let hour = input[0];
let minute = input[1];

if(minute < 45){
    hour-= 1;
    minute = minute + 60 - 45;
} else {
    minute = minute - 45;
}
if(hour == -1)
    hour = 23;
console.log(hour + " " + minute);