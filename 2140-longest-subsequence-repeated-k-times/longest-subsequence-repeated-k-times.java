class Solution {
    public String longestSubsequenceRepeatedK(String s, int k) {
        Queue<String> q = new LinkedList<>();
        q.add("");
        String ans = "";
        while(!q.isEmpty()){
            String temp = q.poll();
            for(char ch='a';ch<='z';ch++){
                String curr = temp+ch;
                if(isPossible(curr,s,k)){
                    ans = curr;
                    q.add(curr);
                }
            }
        }
        return ans;
    }
    public boolean isPossible(String curr,String s,int k){
        int idx = 0;
        int count = 0;
        for(int i=0;i<s.length();i++){
            if(curr.charAt(idx)==s.charAt(i)){
                idx++;
                if(idx==curr.length()){
                    idx = 0;
                    count++;
                }
            }
            if(count==k){
                return true;
            }
        }
        return false;
    }
}