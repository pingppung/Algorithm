const input = require("fs").readFileSync('/dev/stdin').toString().split('\n');
const hour = parseInt(input[0].split(' ')[0]);
const minute = parseInt(input[0].split(' ')[1]);
const time = parseInt(input[1]);

let e_hour = parseInt((hour * 60 + minute + time)/60);
const e_minute = parseInt((hour * 60 + minute + time)%60);
if(e_hour >= 24)
    e_hour = e_hour-24;
console.log(e_hour +" "+ e_minute);

