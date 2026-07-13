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
    public int diameterOfBinaryTree(TreeNode root) {
        return(diameter(root));
    }

    public int height(TreeNode root){
        if(root == null){
            return 0;
        }
        return(Math.max(height(root.left),height(root.right))+1);
    }

    public int diameter(TreeNode root){
        if(root == null){
            return 0;
        }

        int dl = diameter((root.left));
        int dr = diameter((root.right));

        int curr = height(root.left)+height(root.right);
        return Math.max(curr,Math.max(dl,dr));
    }
}