const input = require("fs").readFileSync("/dev/stdin").toString().trim();
let alph = ["c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="];
let count = 0;
let s = input;
for(let i = 0; i< alph.length; i++){
    s = s.split(alph[i]).join(1);
}
count = s.length;
console.log(count);