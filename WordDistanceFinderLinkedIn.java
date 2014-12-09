/* This class will be given a list of words (such as might be tokenized
 * from a paragraph of text), and will provide a method that takes two
 * words and returns the shortest distance (in words) between those two
 * words in the provided text. 
 * Example:
 *   WordDistanceFinder finder = new WordDistanceFinder(Arrays.asList("the", "quick", "brown", "fox", "quick"));
 *   assert(finder.distance("fox","the") == 3);
 *   assert(finder.distance("quick", "fox") == 1);
 
 */
 
public class WordDistanceFinder {
    private const int SENTINAL = -1;
    private Map<String, List<Integer>> map;
    
    public WordDistanceFinder (List<String> words) {
        // implementation here
        
        map = new HashMap<String, List<Integer>>();
        for(int i=0; i<words.Length;i++)
        {
            String wrd = words[i];
            if(!map.contains(wrd))
            {
                map.add(wrd, new LinkedList<Integer>());
            }
            map.get(wrd).add(i);
        }
        
    }
    public int distance (String wordOne, String wordTwo) {
        // implementation here
        if(!map.contains(wordOne) || !map.contains(wordTwo))
            return SENTINAL;

        if(word1.equals(wordTwo))
            return 0;
        
        int ans = INTEGER.MAX_VALUE;
        for(int i in map.get(wordOne))
        {
            for(int j in map.get(wordTwo))
            {
                ans = Math.min(ans, Math.abs(i - j));
            }
        }
        return ans;        
    }
    
    // L1 - {a1, a2,  a3,....,an}  [1, 4, 7]
    // L2 - {b1, b2, b3, ....,bn}  [2, 6, 9]
    // {}
    // {a1, a2, b1, a3, b2, b3, ....... an...bn}
    
    private int minDistance(int[] a, int[] b)
    {
        int i = 0;
        int j = 0;
        int ans = Integer.MAX_VALUE;
        while(i<len(a) && j<len(b))
        {
            ans = Math.min(ans, Math.abs(a[i]-b[j])); 
            if(a[i] < b[j])
            {
                i++;
            
            }else
            {

                j++
            }
        }
        return ans;    
    } 

    
    
    
}


