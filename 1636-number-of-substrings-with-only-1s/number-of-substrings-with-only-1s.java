class Solution {
    public int numSub(String s) {
        int si=0;
        int ei=0;
        int ans=0;
        while(ei < s.length()){
           if(s.charAt(ei)=='0'){
              si=ei+1;
           }
           else{
             ans=(ans+(ei-si+1))%1000000007;
           }
           ei++;
        }
        return ans;
    }
}