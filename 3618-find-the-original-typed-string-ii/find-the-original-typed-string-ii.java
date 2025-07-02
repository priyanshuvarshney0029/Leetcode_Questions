class Solution {
    public int possibleStringCount(String word, int k) {
        int MOD = 1_000_000_007;
        List<Integer> ll = new ArrayList<>();
        char ch = word.charAt(0);
        int count = 1;
        for(int i=1;i<word.length();i++){
            if(word.charAt(i)==ch){
                count++;
            }else{
                ll.add(count);
                ch = word.charAt(i);
                count = 1;
            }
        }
        ll.add(count);
        long totalPair = 1;
        for(int i:ll){
            totalPair = (totalPair*i)%MOD;
        }
        if(ll.size()>=k){
            return (int)totalPair;
        }
        long []dp = new long[k+1];
        for(int i=0;i<k;i++){
            dp[i] = 1;
        }
        for(int idx=ll.size()-1;idx>=0;idx--){
            long []prefix = new long[k+1];
            for(int i=0;i<k;i++){
                prefix[i+1] = (dp[i]+prefix[i])%MOD;
            }

            long []temp = new long[k+1];
            for(int cnt=k-1;cnt>=0;cnt--){
                int l = cnt+1;
                int r = Math.min(k-1,cnt+ll.get(idx));
                temp[cnt] = (prefix[r+1]-prefix[l]+MOD)%MOD;
            }
            dp = temp;
        }
        long invalidPair = dp[0];
        return (int)((totalPair-invalidPair+MOD)%MOD);
    }
}