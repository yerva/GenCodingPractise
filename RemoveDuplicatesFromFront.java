// This is the text editor interface. 
// Anything you type or change here will be seen by the other person in real time.

// stream of characters 
// Iterator<Character> 
// "abcacab"
// "____cab"
// "cab"

// "aaaaaabab"
// "ab"

// "aaaaaababa"
// "ba" <= required solution

//xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
//    yyyyyyyyy
// i

//i: 0...N
//S[i]
//S[i+1] = F(S[i], a[i+1])
import java.util.*;

public class Solution {
    private static void verify(String input, String expected) {
        ArrayList<Character> x = new ArrayList();
        for (char c: input.toCharArray()) x.add(c);
        Iterator<Character> ip = x.iterator(); 
    	System.out.println(RemoveDuplicates(ip) + " for " + input);
    }
    
    public static void main(String args[]) {
    	verify("hello", "elo");
    	verify("abababababa", "ba");	
    	verify("xxxxyyyxyxyxyxyx", "yx");
    	verify("sldjkfslkdfjsdklsndvksdv", "???");	
    }
    
    public static String OldRemoveDuplicates(Iterator<Character> iter){
        String solnSoFar = "";
        while(iter.hasNext()){
            char ch = iter.next();
            
            // if ch already in solnSoFar , remove that char, anc append ch
            int idx = solnSoFar.indexOf(ch);
            if( idx != -1){
                solnSoFar = solnSoFar.substring(0,idx)+solnSoFar.substring(idx+1);
            }
            solnSoFar += ch;
        }
        
        return solnSoFar;
    }
    
    public class Node{
        public Character ch;
        public int val;
        public Node(Char c, int v){
            val = v;
            ch = c;
        }
        
        // override compareTo
        public int compareTo(Object o){
            Node n = (Node)o;
            if()
        }
    }
    
    public static String RemoveDuplicates(Iterator<Character> iter){
        Map<Character,Node> map = new HashMap<Character,Node>();
        int idx = 0;
        while(iter.hasNext()){
            idx++;
            char ch = iter.next();
            map.put(ch,new Node(ch,idx)); // if it doesnt exist it will put the value, if already exists
        }
        
        // form the solution from the data in map;
        Collections.sort(map.values());
        String ans = "";
        for(Node n: map.values()){
            ans += n.ch;   
        }
    }
    
}
