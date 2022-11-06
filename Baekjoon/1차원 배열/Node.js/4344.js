let input = require("fs").readFileSync('/dev/stdin').toString().trim().split("\n");
let n = Number(input[0]);


for(let i = 1; i <= n; i++){
    const a = input[i].split(' ').map(Number);
    const n = input[i].split(' ')[0];

    let sum = 0;
    let count = 0;

    for(let j = 1; j <= n; j++){
        sum += a[j];
    }
    let avg = sum / n;
    for(let x = 1; x <= n; x++){
        if(a[x] > avg)
            count++;
    }
    console.log(((count/n)*100).toFixed(3)+"%");
}