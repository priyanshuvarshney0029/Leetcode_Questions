class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length==1){
            return strs[0];
        }
        String p=strs[0];
        for(int i=1;i<strs.length;i++){
            String t=strs[i];
            int k=0;
            while((k < p.length() && k < t.length() && t.charAt(k)==p.charAt(k))){
                k++;
            }
            p=p.substring(0,k);
        }
        return p;
    }
}