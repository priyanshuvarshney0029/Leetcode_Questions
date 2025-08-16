class Solution {
    public int lengthOfLongestSubstring(String s) {
         HashSet<Character> set=new HashSet<>();
         int si=0;
         int ei=0;
         int ans=0;
         while(ei<s.length()){
            char ch=s.charAt(ei);
            if(!set.contains(ch)){
                set.add(ch);
                ans=Math.max(ans,ei-si+1);
                ei++;
            }
            else{
                set.remove(s.charAt(si));
                si++;
            }
         }
         return ans;
    }
}