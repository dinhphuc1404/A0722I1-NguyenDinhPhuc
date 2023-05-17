function fibonacci(n) {
    if (n <= 0) {
        return 0;
    }
    else if (n === 1) {
        return 1;
    }
    else {
        return fibonacci(n - 1) + fibonacci(n - 2);
    }
}
function calculateFibonacciSum(count) {
    var totalSum = 0;
    for (var i = 0; i < count; i++) {
        totalSum += fibonacci(i);
    }
    return totalSum;
}
var count = 10;
var fibonacciSum = calculateFibonacciSum(count);
console.log("Tổng các số Fibonacci:");
console.log(fibonacciSum);
