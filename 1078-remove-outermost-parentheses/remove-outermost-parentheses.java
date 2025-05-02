class Solution {
    public String removeOuterParentheses(String s) {
        int left=0;
        int right=0;
        StringBuilder sb=new StringBuilder();
        String t="";
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='('){
                left++;
                t=t+"(";
            }
            else{
                right++;
                t=t+")";
            }
            if(left == right){
                String p=t.substring(1,t.length()-1);
                sb.append(p);
                t="";
                left=0;
                right=0;
            }
        }
        return sb.toString();
    }
}