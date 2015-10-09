Input: A[N]    [1,2,3,4]
output:B[N]    [24,12,8,6] 

//brute force approach O(N*N)
int[] solution(int[] n){

   int[] ans =  new int[n.length];
   for(int i = 0;i<n.length; i++){
       long tmp = 1;
       for(int j = 0; j<n.length; j++){
          if(i==j) continue;
          tmp= tmp*n[j];
       }
       ans[i] = tmp;
   }
   return ans;
}

[1,2,0,4]

// O(N)
// prod = A1*....*AN;
// ans[i] = prod/n[i];


// LR[i] = LR[i-1] * n[i];
// RL[i] = RL[i+1] * n[i];
// ans[i] = LR[i-1] * RL[i+1]; 

// O(N) approach
int[] solution(int[] n){
   int L = n.length;
   int[] LR = new int[L];
   int[] RL = new int[L];
   int[] ans = new int[L];
   
   int tmp = 1;
   for(int i=0;i<L;i++){
     tmp = tmp * n[i];
     LR[i] = tmp;   
   }
   
   tmp = 1;
   for(int i=L-1;i>=0;i--){
     tmp = tmp * n[i];
     RL[i] = tmp;   
   } 
   
   for(int i = 0;i<L; i++){
      int lr = i==0? 1 : LR[i-1];
      int rl = i==L-1 ? 1 : RL[i-1];
      ans[i] = lr*rl;
   }
   return ans;
 
}



































1->A
...
26->Z
27->AA
...
52->AZ
53->BA
...

  ->ZZ
  ->AAA

n -> a,b
a = n/26
b = n%26

a -> Char

34 -> r=8,n=1
ans = AH

public class Solution{
}
26
n = 52%26 = 0 AZ
n = 2
ans = Z
n= 27....52 (A)
new n= 1.....2

26*2 => AZ
26*2+1 => BA
26*3 => BZ

String solution(int n){
   if(n<=0){
   // throw exeception or return "INVALID";
   }
   String ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
   String ans = "";
   while(n>0){
       int r = n%26 == 0? 26 : n%26; //r=1.....26
       int n = n/26;
       n = r==26 ? n-1: n;
       
       char ch = ALPHABET.charAt(r-1);
       ans = ch+ans;   
   }   
   return ans;
}



