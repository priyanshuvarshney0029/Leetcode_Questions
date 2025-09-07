class Solution {
    public int[] sumZero(int n) {
         int arr[]=new int[n];
         int p=0;
         int count=1;
         int count_min=-1;
         for(int i=0;i<n/2;i++){
            arr[p++]=count;
            arr[p++]=count_min;
            count++;
            count_min--;
         }
         if(n%2!=0){
            arr[p++]=0;
         }
         return arr;
         
    }
}