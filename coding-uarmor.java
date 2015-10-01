// Input: a decimal-coded array, e.g., [1, 2, 3, 5]
// Output: a decimal-coded array which represents the number of input+1. For [1, 2, 3, 5], the output should be [1, 2, 3, 6].

// CASE 1: ex: [1,2,3,4] => [1,2,3,5] L =4
// CASE 2: ex: [9,9,9,9] => [1,0,0,0,0]

// [9] => [1,0]
public class Solution{
    
    public int[] getNext(int[] curr){
        
        int L = curr.length; //L=1
        boolean all9s = true;
        for(int n:curr){
            if(n!=9){
                all9s = false;
                break;
            }
        }
        
        if(all9s){
            L = L+1; //L=2
        }
        
        // L 
        
        int[] ans = new int[L];
        int prevCarry = 1;
        for(int i=curr.length-1; i>=0; i--){
            int S = curr[i]+prevCarry; //S=10
            prevCarry = S/10; // 1
            
            L = L-1; // L=1
            ans[L] = S%10; // 0 
        }
        
        if(L==1){
            ans[--L] = prevCarry;
        }
        
        return ans;
        
    }
    
}
/*
Given two nodes in a binary tree, the problem is to find the lowest common ancestor in the tree. Note that every pair of nodes in the tree have to have a lowest common ancestor.

Examples:
            A
        B      C
    D    E   F   G
                    H
lowestCommonAncestor(D, E) = B
lowestCommonAncestor(H, D) = A
lowestCommonAncestor(A, A) = A

lowestCommonAncesot(A,F) = A;

lowestCommonAncesot(B,C) = A;
*/

lca(A, B, C)
   llca = lca(B, B, C) = B
   
   rlca = lca(C, B, C) = C
   return A

// LCA is a node.. find the first node,

public class Solution{
    
    // Treenode { val, Treenode left, Treenode right }
    
    public Treenode lowestCommonAncestor(Treenode root, Treenode a, Treenode b){
        
        if(root == null || a==null || b==null){
            return null;
        }
        
        if(root == a || root == b){
            return root;
        }
        
        Treenode llca = lowestCommonAncestor(root.left, a, b);
        Treenode rlca = lowestCommonAncestor(root.right, a, b);
        
        if(llca != null && rlca != null){
            return root;
        }
        
        return llca == null? rlca: llca;
        
    }
    
    
}
