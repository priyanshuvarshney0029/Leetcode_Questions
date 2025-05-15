class Solution {
    public List<String> getLongestSubsequence(String[] words, int[] groups) {
        List<String> ll=new ArrayList<>();
        ll.add(words[0]);
        int last_num=groups[0];
        for(int i=1;i<words.length;i++){
           if(groups[i]!=last_num){
               ll.add(words[i]);
               last_num=groups[i];
           }
        }
        return ll;
    }
}
