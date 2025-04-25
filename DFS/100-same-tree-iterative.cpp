/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode() : val(0), left(nullptr), right(nullptr) {}
 *     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
 *     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
 * };
 */
 // Problem link: https://leetcode.com/problems/same-tree/description/?envType=problem-list-v2&envId=depth-first-search
class Solution {
public:
    bool isSameTree(TreeNode* p, TreeNode* q) {
        std::stack<TreeNode*> pToVisit;
        std::stack<TreeNode*> qToVisit;
        std::vector<int> pVisited;
        std::vector<int> qVisited;
        if (p == nullptr && q == nullptr)
            return true;
        else if ((p == nullptr && q != nullptr) || (p != nullptr && q == nullptr))
            return false;
        else {
            pToVisit.push(p);
            qToVisit.push(q);
            while (!pToVisit.empty()) {
                auto node = pToVisit.top();
                pToVisit.pop();
                if (node == nullptr) {
                    pVisited.push_back(10001);
                    continue;
                }

                pVisited.push_back(node->val);
                pToVisit.push(node->right);
                pToVisit.push(node->left);
            }

            while (!qToVisit.empty()) {
                auto node = qToVisit.top();
                qToVisit.pop();
                if (node == nullptr) {
                    qVisited.push_back(10001);
                    continue;
                }

                qVisited.push_back(node->val);
                qToVisit.push(node->right);
                qToVisit.push(node->left);
            }
        }

        /*for (auto val : pVisited)
            cout << val << " ";
        cout << endl;
        for (auto val : qVisited)
            cout << val << " ";
        cout << endl;*/
        

        return pVisited == qVisited;
    }
};