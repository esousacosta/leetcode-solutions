from sys import maxsize


class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:
        memo = [-1] * (amount + 1)
        memo[0] = 0

        for i in range(amount + 1):
            minCoins = sys.maxsize
            for c in coins:
                if c > i:
                    continue
                subproblem = i - c
                if memo[subproblem] == -1:
                    continue
                currCoins = 1 + memo[subproblem]
                if currCoins < minCoins:
                    minCoins = currCoins

            if minCoins != sys.maxsize:
                memo[i] = minCoins

        return memo[amount]
