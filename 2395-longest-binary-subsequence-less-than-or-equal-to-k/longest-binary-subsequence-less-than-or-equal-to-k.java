class Solution {
    public int longestSubsequence(String s, int k) {
        int len = 0;
        int mask = 0;
        long ans = 0;
        for(int i=s.length()-1;i>=0;i--){
            if(s.charAt(i)=='0'){
                len++;
                mask++;
            }
            else if(mask<32){
                long temp = 1L<<mask;
                if(ans+temp<=k){
                    ans+=temp;
                    len++;
                    mask++;
                }
            }
        }
        return len;
    }
}