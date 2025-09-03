class Solution {
    public int countPrimes(int n) {
        if(n==1 || n==0){
            return 0;
        }
        boolean prime[]=new boolean[n];
        prime[0]=true; // not prime
        prime[1]=true; // not prime

        for(int i=2;i*i<prime.length;i++){
            if(prime[i]==false){
                for(int j=2;i*j<prime.length;j++){
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