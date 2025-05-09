# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isBalanced(self, root: Optional[TreeNode]) -> bool:
        def dfs(root):
            if not root:
                return [True, 0]

            leftBalanced, leftHeight = dfs(root.left)
            rightBalanced, rightHeight = dfs(root.right)

            isBalanced = leftBalanced and rightBalanced and (abs(leftHeight - rightHeight) <= 1)

            return [isBalanced, 1 + max(leftHeight, rightHeight)]

        return dfs(root)[0]