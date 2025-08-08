class Solution {
    public List<List<String>> partition(String s) {
        List<String> ll=new ArrayList<>();
        List<List<String>> ans=new ArrayList<>();
        solve(s,ll,ans);
        return ans;
    }
    public void solve(String ques,List<String> ll,List<List<String>> ans){
        if(ques.length()==0){
            ans.add(new ArrayList<>(ll));
            return;
        }
        for(int i=1;i<=ques.length();i++){
            String s=ques.substring(0,i);
            
            if(ispalindrome(s)){
                ll.add(s);
                solve(ques.substring(i),ll,ans);
                ll.remove(ll.size()-1);
            }
        }
    }
    public static boolean ispalindrome(String ques){
		int st=0;
		  int end=ques.length()-1;
		  while(st<end) {
			 if(ques.charAt(st)!=ques.charAt(end)) {
				 return false;
			 }
			 st++;
			 end--;
		  }
		  return true;
	}
}