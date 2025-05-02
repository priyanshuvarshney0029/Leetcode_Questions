class Solution {
    public String largestOddNumber(String num) {
        String odd="";
        int c=-1;
       for(int i=num.length()-1;i>=0;i--){
           if((num.charAt(i)-'0')%2!=0){
               c=i;
               break;
           }
       }
       if(c==-1){
           return "";
       }
       for(int i=0;i<=c;i++){
           odd+=num.charAt(i);
       }
       return odd;
    }
}