# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isBalanced(self, root: Optional[TreeNode]) -> bool:
        def dfs(root: Optional[TreeNode]):
            if not root:
                return 0

            lHeight = dfs(root.left)
            rHeight = dfs(root.right)

            if lHeight == -1 or rHeight == -1 or abs(lHeight - rHeight) > 1:
                return -1

            return 1 + max(lHeight, rHeight)

        return True if dfs(root) != -1 else False
