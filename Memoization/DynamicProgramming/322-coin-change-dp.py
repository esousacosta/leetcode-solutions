import sys
class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:
        memo = {}
        memo[0] = 0

        def change(amount):
            if amount in memo:
                return memo[amount]
                
            if amount == 0:
                return 0

            minCoins = sys.maxsize

            for coin in coins:
                currCoins = 0
                if coin <= amount:
                    subproblem = change(amount - coin)
                    if subproblem == -1:
                        continue
                    currCoins = 1 + subproblem
                    if currCoins < minCoins:
                        minCoins = currCoins

            if minCoins == sys.maxsize:
                minCoins = -1

            memo[amount] = minCoins
            return minCoins

        return change(amount)
