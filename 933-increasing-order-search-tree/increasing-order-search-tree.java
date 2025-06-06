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
    TreeNode newRoot;
    void straight(TreeNode root){
        if(root==null) return ;

        straight(root.left);

        TreeNode newNode=new TreeNode(root.val);
        newRoot.right=newNode;
        newRoot=newRoot.right;
       
        straight(root.right);
        

    }
    public TreeNode increasingBST(TreeNode root) {
        TreeNode newNode=new TreeNode(-1);
        newRoot=new TreeNode(-1);
        newNode=newRoot;
        straight(root);
        return newNode.right;
    }
}