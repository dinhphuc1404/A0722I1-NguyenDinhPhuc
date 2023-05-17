function fibonacci(n: number): number {
    if (n <= 0) {
        return 0;
    } else if (n === 1) {
        return 1;
    } else {
        return fibonacci(n - 1) + fibonacci(n - 2);
    }
}

function calculateFibonacciSum(count: number): number {
    let totalSum: number = 0;
    for (let i = 0; i < count; i++) {
        totalSum += fibonacci(i);
    }
    return totalSum;
}

const count: number = 10;
const fibonacciSum: number = calculateFibonacciSum(count);

console.log("Tổng các số Fibonacci:");
console.log(fibonacciSum);
