class Solution {
    public String pushDominoes(String dominoes) {
        int []first = new int[dominoes.length()];
        int count = 0;
        for(int i=0;i<first.length;i++){
            if(dominoes.charAt(i)=='R'){
                count = 1;
            }else if(dominoes.charAt(i)=='.'){
                if(count>0){
                    count++;
                }
            }else{
                count = 0;
            }
            first[i] = count;
        }
        int []second = new int[dominoes.length()];
        count = 0;
        for(int i=second.length-1;i>=0;i--){
            if(dominoes.charAt(i)=='L'){
                count = -1;
            }else if(dominoes.charAt(i)=='.'){
                if(count<0){
                    count--;
                }
            }else{
                count = 0;
            }
            second[i] = count;
        }
        StringBuilder ans = new StringBuilder();
        for(int i=0;i<first.length;i++){
            if((first[i]==0 && second[i]==0) || first[i]+second[i]==0){
               ans.append(".");
            }else if(first[i]==0){
                if(second[i]>0){
                    ans.append("R");
                }else{
                    ans.append("L");
                }
            }else if(second[i]==0){
                if(first[i]>0){
                    ans.append("R");
                }else{
                    ans.append("L");
                }
            }else{
                if(first[i]+second[i]<0){
                    ans.append("R");
                }else{
                    ans.append("L");
                }
            }
        }
        return ans.toString();
    }
}