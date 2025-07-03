class Solution {
    public int countPrimes(int n) {
        boolean prime[]=new boolean[n];
        for(int i=2;i*i<=prime.length;i++){  //sqrt of n tak loop hain ye
             if(prime[i]==false){
                for(int j=2;j*i<prime.length;j++){
                    prime[i*j]=true;
                }
            }
        }
        int count=0;
        for(int i=2;i<prime.length;i++){
            if(prime[i]==false){
                count++;
            }
        }
        return count;
    }
}