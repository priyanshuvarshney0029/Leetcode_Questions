class Solution {
    public char kthCharacter(int k) {
        StringBuilder sb=new StringBuilder();
        sb.append('a');
        while(sb.length()<k){
            StringBuilder sb1=new StringBuilder(sb);
            for(int i=0;i<sb1.length();i++){
                if(sb1.charAt(i) < 'z'){
                    char ch=sb1.charAt(i);
                    ch++;
                    sb.append(ch);
                }
               else if(sb1.charAt(i)=='z'){
                  sb.append('a');
               }
            }
        }
        return sb.charAt(k-1);

    }
}