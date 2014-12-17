
/**
 * Given a binary tree where all the right nodes are either empty or leaf nodes, flip it upside down
 * and turn it into a tree with left leaf nodes.
 * In the original tree, if a node has a right child, it also must have a left child.
 *
 * for example, turn these:
 *
 *        1                1
 *       / \              / \
 *      2   3            2   3
 *     /
 *    4
 *   / \
 *  5   6
 
 reverse(1) --> reverse(1.left == 2)
 
 RevRec(root, left, right,IsRoot)
     if(left is None):
         return root
 
 --> if(isRoot):
         root.left,root.right = None,None    (1-2,1-3) ==> (1-None, 1-None)
     else:
         root.left,root.right = right,root
 --> left.left,left.right = right, root  
 ---> RevRec(left, left.left, left.right,False)
     return  left
 
 *
 * into these:
 *
 *        1               1
 *       /               /
 *      2---3           2---3
 *     /
 *    4
 *   /
 *  5---6
 *
 * where 5 is the new root node for the left tree, and 2 for the right tree.
 * oriented correctly:
 *
 *     5                  2
 *    / \                / \
 *   6   4              3   1
 *        \
 *         2
 *        / \
 *       3   1
 *
 
   1    2
  / =>   \
 2        1
 */
class TreeNode {
    TreeNode left;
    TreeNode right;
    int data;
}
 
public TreeNode reverse(TreeNode node) {
    // implementation here
    return RevRecurse(node, node.left, node.right, True)
    
    
def RevRecurse(root,left,right,isRoot): 

    if left is None:
        return root
    if(isRoot):
         root.left,root.right = None,None  
     else:
         root.left,root.right = right,root 
     
     newNode =   RevRec(left, left.left, left.right,False)
     left.left,left.right = right, root    
     return newNode  
    
    
}
