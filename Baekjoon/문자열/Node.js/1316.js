const input = require("fs").readFileSync("/dev/stdin").toString().trim().split('\n');
const n = Number(input[0]);
let count = 0;
for(let i = 1; i <= n; i++){
    const w = input[i].trim();
    let result = true;
    let word = [];
    for(let j = 0; j < w.length; j++){
        if(!word.includes(w[j])){
            word.push(w[j]);
        }
        else{
            if(word.indexOf(w[j]) != word.length -1){
                result = false;
                break;
            }
        }  
    }
    if(result)
        count += 1;
}
console.log(count);
