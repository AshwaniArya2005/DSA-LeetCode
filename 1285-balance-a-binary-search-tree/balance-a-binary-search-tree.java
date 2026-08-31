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
    ArrayList<Integer> al = new ArrayList<>();
    public TreeNode balanceBST(TreeNode root) {
        inorder(root);
        int[] nodes = al.stream().mapToInt(Integer::intValue).toArray();
        int start = 0;
        int end = al.size()-1;

        return balance(nodes,start,end);
        
    }

    public void inorder(TreeNode root){
        if(root == null) return;

        inorder(root.left);
        al.add(root.val);
        inorder(root.right);
    }

    public TreeNode balance( int[] nodes  , int start, int end){
        if(start > end) return null;
        int mid = start + (end-start)/2;
        TreeNode root = new TreeNode(nodes[mid]);
        root.left = balance(nodes,start,mid-1);
        root.right = balance(nodes,mid+1,end);
        return root;
    }

}