class Solution {
    public List<String> getWordsInLongestSubsequence(String[] words, int[] groups) {
        int []dp = new int[groups.length];
        int []prev = new int[groups.length];
        for(int i=0;i<groups.length;i++){
            dp[i] = 1;
            prev[i] = i;
        }

        for(int i=0;i<words.length;i++){
            for(int j=0;j<i;j++){
                if(hamming(words[i],words[j]) && groups[i]!=groups[j]){
                    if(dp[j]+1>dp[i]){
                        dp[i] = dp[j]+1;
                        prev[i] = j;
                    }
                }
            }
        }

        int max = 0;
        int idx = -1;
        for(int i=0;i<dp.length;i++){
            if(dp[i]>max){
                max = dp[i];
                idx = i;
            }
        }
        List<String> ans = new ArrayList<>();
        while(idx!=prev[idx]){
           ans.add(words[idx]);
           idx = prev[idx];
        }
        ans.add(words[idx]);
        Collections.reverse(ans);
        return ans;

    }
    public boolean hamming(String s1,String s2){
        if(s1.length()!=s2.length()){
            return false;
        }
        int count = 0;
        int i = 0;
        int j = 0;
        while(i<s1.length() && j<s2.length()){
            if(s1.charAt(i)==s2.charAt(j)){
                count++;
            }
            i++;
            j++;
        }
        return Math.max(s1.length(),s2.length())-count==1;
    }
}