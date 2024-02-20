def dfs(r, c, grid, visited, rows, cols):
    if r < 0 or c < 0 or r >= rows or c >= cols or (r, c) in visited or (grid[r][c] == "0"):
        return False
    visited.add((r, c))
    dfs(r + 1, c, grid, visited, rows, cols)
    dfs(r - 1, c, grid, visited, rows, cols)
    dfs(r, c + 1, grid, visited, rows, cols)
    dfs(r, c - 1, grid, visited, rows, cols)
    return True


class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        if not grid:
            return 0
        rows = len(grid)
        cols = len(grid[0])

        visited: Set(tuple(int, int)) = set()
        islandsCount: int = 0

        for r in range(rows):
            for c in range(cols):
                if dfs(r, c, grid, visited, rows, cols):
                    islandsCount += 1
        
        return islandsCount