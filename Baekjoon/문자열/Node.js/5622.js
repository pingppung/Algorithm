const input = require("fs").readFileSync('/dev/stdin').toString().trim().split('');
let num = {
	2: "ABC",
	3: "DEF",
	4: "GHI",
	5: "JKL",
	6: "MNO",
	7: "PQRS",
	8: "TUV",
	9: "WXYZ",
}
let result = 0;
input.map((i)=>{
    for(let j = 2; j <= 9; j++){
        num[j].includes(i) ? result+=j+1 : 0;
    }
})
console.log(result);