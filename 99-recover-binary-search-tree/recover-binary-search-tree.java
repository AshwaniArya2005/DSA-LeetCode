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
    ArrayList<TreeNode> al = new ArrayList<>();
    public void recoverTree(TreeNode root) {
        inorder(root);
        int n = al.size();
        TreeNode f = null, s = null;
        for(int i = 1; i<n;i++){
            if(al.get(i-1).val > al.get(i).val){
                if(f == null) {
                    f = al.get(i-1);
                }
                s = al.get(i);
            }
        }

        int temp = f.val;
        f.val = s.val;
        s.val = temp;
    }

    public void inorder(TreeNode root){
        if(root == null) return;

        inorder(root.left);
        al.add(root);
        inorder(root.right);
    }
}