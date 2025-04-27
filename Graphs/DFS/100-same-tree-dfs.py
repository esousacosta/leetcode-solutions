# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isSameTree(self, p: Optional[TreeNode], q: Optional[TreeNode]) -> bool:
        return sameTreeDoubleDfs(p, q)


def sameTreeDoubleDfs(rootA, rootB) -> bool:
    if not rootA and not rootB:
        return True
    elif (
        (rootA and not rootB)
        or (not rootA and rootB)
        or (rootA.val != rootB.val)
        or not sameTreeDoubleDfs(rootA.left, rootB.left)
        or not sameTreeDoubleDfs(rootA.right, rootB.right)
    ):
        return False

    return True
