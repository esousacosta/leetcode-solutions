import sys
class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:
        if amount == 0:
            return 0

        memo = {}
        memo[0] = 0

        for i in range(1, amount + 1):
            memo[i] = -1
            currCoins = 0
            minCoins = sys.maxsize
            for coin in coins:
                if coin <= i:
                    if memo[i - coin] == -1:
                        continue
                    currCoins = 1 + memo[i - coin]
                    if currCoins < minCoins:
                        minCoins = currCoins
            if minCoins != sys.maxsize:
                memo[i] = minCoins
            else:
                memo[i] = -1

        return memo[amount]        
