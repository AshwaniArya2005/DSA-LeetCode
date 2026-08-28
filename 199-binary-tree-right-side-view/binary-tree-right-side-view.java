/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        List<TreeNode> ls = new ArrayList<>();
        util(root, ls, 0);

        for(TreeNode n : ls){
            result.add(n.val);
        }
        return result;
    }

    public List<TreeNode> util(TreeNode root, List<TreeNode> ls , int level){
        if(root == null){
            return ls;
        }
        if(level == ls.size()){
            ls.add(level,root);
        }
        util(root.right,ls,level+1);
        util(root.left,ls,level+1);
        return ls;
    }
}