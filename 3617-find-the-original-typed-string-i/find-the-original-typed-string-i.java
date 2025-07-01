class Solution {
    public int possibleStringCount(String word) {
        char ch = word.charAt(0);
        int count = 1;
        int ans = 0;
        for(int i=1;i<word.length();i++){
            if(word.charAt(i)==ch){
                count++;
            }else{
                ans+=(count-1);
                ch = word.charAt(i);
                count = 1;
            }
        }
        ans+=count;
        return ans;
    }
}