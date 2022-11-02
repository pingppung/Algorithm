const chess = [1,1,2,2,2,8];
const input = require('fs').readFileSync('/dev/stdin').toString().split(' ');
const result = input.map((i,idx)=>{
    return chess[idx]-i;
})
console.log(result.join(' '));