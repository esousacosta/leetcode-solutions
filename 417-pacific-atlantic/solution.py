def dfs(r, c, previousHeight: int, visited: Set[tuple[int, int]], heights: List[List[int]], rows, cols):
        if ((r, c) in visited) or r < 0 or r >= rows or c < 0 or c >= cols or heights[r][c] < previousHeight:
            return
        visited.add((r, c))

        dfs(r + 1, c, heights[r][c], visited, heights, rows, cols)
        dfs(r - 1, c, heights[r][c], visited, heights, rows, cols)
        dfs(r, c + 1, heights[r][c], visited, heights, rows, cols)
        dfs(r, c - 1, heights[r][c], visited, heights, rows, cols)

class Solution:

    def pacificAtlantic(self, heights: List[List[int]]) -> List[List[int]]:
        rows = len(heights)
        cols = len(heights[0])
        pac = set()
        atl = set()

        for c in range(cols):
            dfs(0, c, heights[0][c], pac, heights, rows, cols)
            dfs(rows - 1, c, heights[rows - 1][c], atl, heights, rows, cols)

        for r in range(rows):
            dfs(r, 0, heights[r][0], pac, heights, rows, cols)
            dfs(r, cols - 1, heights[r][cols - 1], atl, heights, rows, cols)

        return pac.intersection(atl)
