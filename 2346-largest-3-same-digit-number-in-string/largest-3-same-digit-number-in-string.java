class Solution {
    public String largestGoodInteger(String num) {
        String ans="";
        for(int i=0;i<num.length();i++){
            String s="";
            for(int j=i;j<num.length();j++){
                char ch=num.charAt(j);
                s+=ch;

                if(s.length()==3){
                    if(s.charAt(0)==s.charAt(1) && s.charAt(2)==s.charAt(0)){
                        if(ans.length()==0){
                            ans=s;
                        }
                        else{
                            char chhh=ans.charAt(0);
                            if(chhh > s.charAt(0)){
                                
                            }
                            else{
                                ans=s;
                            }
                        }
                    }
                    break;
                }
            }
        }
        return ans;

    }
}