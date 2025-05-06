class Solution:
    def change(self, amount: int, coins: List[int]) -> int:
        memo = [0] * (amount + 1)

        memo[0] = 1
        # This arrangement of arrays makes it so that we only calculate
        # the combinations (not permutations - we exclude duplicate combinations)
        # at each outter loop run using the current coin + previous ones.
        for coin in coins:
            for i in range(coin, amount + 1):
                memo[i] += memo[i - coin]

        return memo[amount]