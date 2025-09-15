class Solution {
    public int canBeTypedWords(String text, String brokenLetters) {
        String []arr = text.split(" ");
        int count = 0;
        for(String st:arr){
            boolean flag = true;
            for(int i=0;i<st.length();i++){
                if(brokenLetters.contains(String.valueOf(st.charAt(i)))){
                    flag = false;
                    break;
                }
            }
            if(flag==true){
                count++;
            }
        }
        return count;
    }
}