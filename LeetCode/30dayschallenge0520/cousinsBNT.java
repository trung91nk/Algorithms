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
    public boolean isCousins(TreeNode root, int x, int y) {
        return getDepth(root,x)==getDepth(root,y) && !parent(root,x,y)? true : false;
    }
    //distance between root and nood having value = x
    public int getDepth(TreeNode root, int x){
        if(root==null){
            return -1;
        }
        int distance = -1;
        if(root.val == x || (distance = getDepth(root.left,x))>=0 || (distance = getDepth(root.right,x))>=0){
            return distance+1;
        }
        return distance;      
    }
    
    //check if 2 nodes have same parent
    public boolean parent(TreeNode root, int x, int y){
        if(root==null){
            return false;
        }else{
            if(root.left!= null && root.right!=null){
                if((root.left.val == x && root.right.val==y) || (root.left.val==y && root.right.val == x)){
                    return true;
                }else{
                    return parent(root.left,x,y) || parent(root.right,x,y);
                }
            }else if(root.left!=null && root.right==null){
                return parent(root.left,x,y);
            }else if(root.left==null && root.right!=null){
                return parent(root.right,x,y);
            }else{
                return false;
            }
        }
    }
}
