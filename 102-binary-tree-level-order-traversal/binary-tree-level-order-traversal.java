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
    int levels(TreeNode root){
        if(root==null) return 0;

        return 1+Math.max(levels(root.left),levels(root.right));
    }

    void bfs(int lev,TreeNode root,List<List<Integer>> list){
        if(root==null) return ;

        list.get(lev).add(root.val);
        bfs(lev+1,root.left,list);
        bfs(lev+1,root.right,list);
    }

    public List<List<Integer>> levelOrder(TreeNode root) {

        int lev=levels(root);

        List<List<Integer>> list=new ArrayList<>();
        for(int i=0;i<lev;i++) list.add(new ArrayList<>());

        bfs(0,root,list);

        return list;


        
    }
}