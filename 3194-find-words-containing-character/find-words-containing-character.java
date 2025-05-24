class Solution {
    public List<Integer> findWordsContaining(String[] words, char x) {
        List<Integer> ll=new ArrayList<>();
        for(int i=0;i<words.length;i++){
            String s=words[i];
            for(char ch:s.toCharArray()){
                if(ch==x){
                    ll.add(i);
                    break;
                }
            }
        }
        return ll;
    }
}