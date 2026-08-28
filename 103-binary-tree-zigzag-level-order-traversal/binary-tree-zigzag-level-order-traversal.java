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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        List<List<Integer>> result = new ArrayList<>();
        if(root == null) return result;
        q.offer(root);
        boolean flag = true;

        while(!q.isEmpty()){
            int size = q.size();
            List<Integer> ls = new ArrayList<>();

            for(int i=0;i<size;i++){
                TreeNode curr = q.poll();
                if(curr.left != null) q.offer(curr.left);
                if(curr.right != null) q.offer(curr.right);

                ls.add(curr.val);
            }
            if(flag){
                result.add(ls);
                flag = false;
            }else{
                Collections.reverse(ls);
                result.add(ls);
                flag = true;
            }

        }

        return result;
    }
}