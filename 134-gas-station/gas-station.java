class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
       int curr=0;
       int total=0;
       int total_cost=0;
       int idx=0;
       for(int i=0;i<gas.length;i++){
          total+=gas[i];
          total_cost+=cost[i];
          curr+=gas[i]-cost[i];
          if(curr<0){
             curr=0;
             idx=i+1;
          }
          
       }
       if(total<total_cost){
          return -1;
       }
       return idx;
    }
}