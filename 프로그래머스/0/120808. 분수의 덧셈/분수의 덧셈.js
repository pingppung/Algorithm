function solution(numer1, denom1, numer2, denom2) {
    var answer = [];
    var denom = denom1 * denom2;
    var number = numer1 * denom2 + numer2 * denom1;
    let g = gcd(number, denom);
    return [number / g, denom / g];
}
function gcd(x, y){
    while(y != 0){
        let tmp = y;
        y = x % y;
        x = tmp;
    }
    return x;
}