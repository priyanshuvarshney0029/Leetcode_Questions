class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> set=new HashSet<>();
        int si=0;
        int ei=0;
        int result=0;
        while(ei < s.length()){
            char ch=s.charAt(ei);
            
            // shrink....
            while(set.contains(ch)){
                set.remove(s.charAt(si));
                si++;
            }
            result=Math.max(result,ei-si+1);
            set.add(ch);
            ei++;
        }
        return result;
    }
}