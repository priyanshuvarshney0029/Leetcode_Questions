class Solution {
    public String answerString(String word, int numFriends) {
        if(numFriends==1){
            return word;
        }
        int i = 0;
        int j = 1;
        while(j<word.length()){
            int k = 0;
            while(j+k<word.length() && word.charAt(i+k)==word.charAt(j+k)){
                k++;
            }
            if(j+k<word.length() && word.charAt(j+k)>word.charAt(i+k)){
                i = j;
                j++;
            }else{
                j = j+k+1;
            }
        }
        int maxlen = word.length()-numFriends+1;
        if(i+maxlen<=word.length()){
            return word.substring(i,i+maxlen);
        }
        return word.substring(i);
    }
}