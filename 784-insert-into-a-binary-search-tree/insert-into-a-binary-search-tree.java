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
    void insertion(TreeNode root,int val){
        if(root==null) return;

        if(root.left==null  || root.right==null){
            if(root.left==null && root.val>val){
                root.left=new TreeNode(val);
                return ;
            }
            else if(root.right==null && root.val<val){
                root.right=new TreeNode(val);
                return;
            }
        }

        if(root.val>val){
            insertion(root.left,val);
        }
        else if(root.val<val){
            insertion(root.right,val);
        }
    }
    public TreeNode insertIntoBST(TreeNode root, int val) {
        insertion(root,val);

        if(root==null){
            return new TreeNode(val);
        }

        return root;
        
    }
}