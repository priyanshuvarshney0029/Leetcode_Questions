class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
         int total_sum=0;
         int total_gas=0;

         int curr_gas=0;
         int st_idx=0;

         for(int i=0;i<gas.length;i++){
             total_sum+=gas[i];
             total_gas+=cost[i];

             curr_gas+=(gas[i]-cost[i]);
             if(curr_gas<0){
                 st_idx=i+1;
                 curr_gas=0;
             }
         }
          if(total_gas > total_sum){
                 return -1;
             }
             return st_idx;
    }
}