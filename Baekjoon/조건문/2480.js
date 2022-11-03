const [d1, d2, d3] = require('fs').readFileSync('/dev/stdin').toString().split(' ').map(Number).sort((a,b) => b-a); 
if(d1 == d2 && d2 == d3)
    console.log(10000+d1*1000);
else if(d1 == d2 || d2 == d3)
    console.log(1000+d2*100);
else
    console.log(d1*100);
    
