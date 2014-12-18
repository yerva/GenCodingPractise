
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

#=================== working soln ======================
class TreeNode:
    left = None
    right = None
    data = 0

    def __init__(self, val):
        self.data = val
        self.left,self.right=None,None

def countNodes(node):
    if node is None:
        return 0
    return 1+countNodes(node.left)+countNodes(node.right)

def printTree1(node):
    COUNT = countNodes(node)
    q = []
    q.append((node,0))
    ANS = []
    while len(q)>0 and COUNT>0:
        n,l = q.pop(0)
        if n is not None:
            COUNT = COUNT-1
            ANS.append(n.data)
            q.append((n.left,l+1))
            q.append((n.right,l+1))
        else:
            ANS.append('#')
    return ANS
                 
def loadTree(lst):
    trNodes = [0]*len(lst)
    for i,n in enumerate(lst):
        trNodes[i] = TreeNode(int(n)) if n!='#' else None
    for i,n in enumerate(trNodes):
        if n is not None:
            n.left = trNodes[2*i+1] if 2*i+1<len(trNodes) else None
            n.right = trNodes[2*i+2] if 2*i+2<len(trNodes) else None
    return trNodes[0]



def RevRecurse(root,left,right,isRoot):    
    if left is None:
        return root
    if(isRoot):
         root.left,root.right = None,None  
    else:
         root.left,root.right = right,root 
     
    newNode =   RevRecurse(left, left.left, left.right,False)
    left.left,left.right = right, root    
    return newNode  
        
def reverse(node):
    if node is None:
        return None
    T = RevRecurse(node, node.left, node.right, True)
    print(printTree1(T))
    

print('*************')
T = loadTree(range(1,4))
ans=printTree1(T)
print('*************')
reverse(T)

print('@@@@@@@@@@@@')
T1 = [1,2,3,4,'#','#','#',5,6]
T = loadTree(T1)
ans=printTree1(T)
print(ans)
print('*************')
reverse(T)

    

    
