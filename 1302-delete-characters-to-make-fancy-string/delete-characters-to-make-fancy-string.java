// class Solution {
//     public String makeFancyString(String s) {
//         Stack<Character> st=new Stack<>();
//         // Stack<Character> st1=new Stack<>();
//         st.push(s.charAt(0));
//         int count=0;
//         String res="";
//         for(int i=1;i<s.length();i++){
//             char ch=s.charAt(i);
//             if(ch==st.peek()){
//                 count++;
//                 if(count<2){
//                     st.push(ch);
//                 }
//             }
//             else{
//                 st.push(ch);
//                 count=0;
//             }

//         }
//         for(char cht:st){
//                 res+=cht;
//             }
//        return res;
        
//     }
// }
import java.util.Stack;

class Solution {
    public String makeFancyString(String s) {
        Stack<Character> st = new Stack<>();
        st.push(s.charAt(0));
        int count = 1;  // Start from 1 to count the first character..
        StringBuilder res = new StringBuilder();

        for (int i = 1; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == st.peek()) {
                count++;
                if (count < 3) {
                    st.push(ch);
                }
            } else {
                st.push(ch);
                count = 1;  // Reset count for a new character
            }
        }

        for (char cht : st) {
            res.append(cht);
        }
        return res.toString();
    }
}
