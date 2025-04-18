class Solution {
    public String countAndSay(int n) {
        if(n==1){
            return "1";
        }
        String ans = countAndSay(n-1);
        int count = 1;
        char x = ans.charAt(0);
        String say = "";
        for(int i=1;i<ans.length();i++){
            if(ans.charAt(i)==x){
                count++;
            }else{
                say+=String.valueOf(count)+x;
                x = ans.charAt(i);
                count = 1;
            }
        }
        say+=String.valueOf(count)+x;
        return say;
    }
}