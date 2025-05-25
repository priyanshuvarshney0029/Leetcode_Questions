class Solution {
    public int longestPalindrome(String[] words) {
        HashMap<String,Integer> map=new HashMap<>();
        int longest_len=0;

        for(String s:words){
            String rev=new StringBuilder(s).reverse().toString();

            if(map.getOrDefault(rev,0)>0){
                longest_len+=4;
                map.put(rev,map.get(rev)-1);
            }
            else{
                map.put(s,map.getOrDefault(s,0)+1);
            }
        }
        for(String key:map.keySet()){
            if(key.charAt(0)==key.charAt(1) && map.get(key)>0){
                longest_len+=2;
                break;
            }
        }
        return longest_len;
    }
}