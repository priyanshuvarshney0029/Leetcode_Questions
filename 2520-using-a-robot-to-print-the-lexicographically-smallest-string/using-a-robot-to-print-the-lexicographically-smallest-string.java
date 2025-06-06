class Solution {
    public String robotWithString(String s) {
        int []freq = new int[26];
        for(int i=0;i<s.length();i++){
            freq[s.charAt(i)-'a']++;
        }
        Stack<Character> st = new Stack<>();
        StringBuilder ans = new StringBuilder();
        for(int i=0;i<s.length();i++){
            freq[s.charAt(i)-'a']--;
            st.push(s.charAt(i));
            while(!st.isEmpty() && st.peek()<=find(freq)){
                ans.append(st.pop());
            }
        }
        while(!st.isEmpty()){
            ans.append(st.pop());
        }
        return ans.toString();
    }
    public char find(int []freq){
        for(int i=0;i<freq.length;i++){
            if(freq[i]>0){
                return (char)(i+97); 
            }
        }
        return 'a';
    }
}