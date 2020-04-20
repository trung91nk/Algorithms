/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode bstFromPreorder(int[] preorder) {
        TreeNode root = new TreeNode(preorder[0]);
        for(int i=1;i<preorder.length;i++){
            add(root,preorder[i]);    
        }
        return root;
    }
    public void add(TreeNode root, int newVal){
        if(newVal<root.val){
            if(root.left == null){
                root.left = new TreeNode(newVal);
            }else{
                add(root.left,newVal);
            }
        }else{
            if(root.right == null){
                root.right = new TreeNode(newVal);
            }else{
                add(root.right,newVal);
            }
        }
    }
}
