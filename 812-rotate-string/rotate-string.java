class Solution {
    public boolean rotateString(String s, String goal) {
        if(s.length()!=goal.length()){
             return false;
        }
         StringBuilder sb=new StringBuilder(s);
         for(int i=0;i<s.length();i++){
             char ch=sb.charAt(0);
             sb.append(ch);
             sb.deleteCharAt(0);
             if(goal.equals(sb.toString())){
                 return true;
             }
         }
         return false;
    }
}