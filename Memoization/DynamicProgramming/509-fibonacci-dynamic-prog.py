class Solution:
    def fib(self, n: int) -> int:
        def fibonacci(n: int, memo: dict):
            if n in memo:
                return memo[n]

            if n <= 1:
                return n
            else:
                return fibonacci(n - 1, memo) + fibonacci(n - 2, memo)

        memo = {}
        return fibonacci(n, memo)
