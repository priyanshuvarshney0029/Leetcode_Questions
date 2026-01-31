class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        int low=0;
        int high=letters.length-1;
        // char ans='\0';  // for null character we can take like that in java
        char ans=letters[0];
        while(low <= high){
            int mid=low+(high-low)/2;
            int ch=(int) letters[mid];
            int tar=(int) target;
            if(ch > tar){
                 ans=letters[mid];
                 high=mid-1;
            }
            else{
                low=mid+1;
            }
        }
        return ans;
    
    }
}