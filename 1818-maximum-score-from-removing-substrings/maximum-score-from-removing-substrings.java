class Solution {
    public int maximumGain(String s, int x, int y) {
        String temp = x>y?"ab":"ba";
        
        // first process max cost
        Stack<Character> st = new Stack<>();
        int ans = 0;
        ans+=find(s,temp.charAt(0),temp.charAt(1),Math.max(x,y),st);

        // take remaining string for 2nd evaluation
        StringBuilder str = new StringBuilder();
        while(!st.isEmpty()){
            char ch = st.pop();
            str.append(ch);
        }
        
        // then for min cost
        ans+=find(str.reverse().toString(),temp.charAt(1),temp.charAt(0),Math.min(x,y),st);
        return ans;
    }
    public int find(String s,char ch1,char ch2,int cost,Stack<Character> st){
        int ans = 0;
        for(int i=0;i<s.length();i++){
            if(!st.isEmpty() && s.charAt(i)==ch2 && st.peek()==ch1){
                st.pop();
                ans+=cost;
            }else{
                st.push(s.charAt(i));
            }
        }
        return ans;
    }
}