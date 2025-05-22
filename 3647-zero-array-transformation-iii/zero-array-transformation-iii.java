class Solution {
    public int maxRemoval(int[] nums, int[][] queries) {
        PriorityQueue<Integer> pq=new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> pq1=new PriorityQueue<>(); // min heap

      Arrays.sort(queries, (a, b) -> a[0] - b[0]);

        int trans_count=0;
        int j=0;
        for(int i=0;i<nums.length;i++){
            while(j < queries.length && i==queries[j][0]){
                pq.add(queries[j][1]);
                j++;
            }
            nums[i]=nums[i]-pq1.size();

            while(nums[i] > 0 && !pq.isEmpty() && pq.peek()>=i){
                pq1.add(pq.peek());
                pq.poll();
                nums[i]--;
                trans_count++;
            }

            if(nums[i]>0){
                return -1;
            }

            while(!pq1.isEmpty() && pq1.peek()==i){
                pq1.poll();
            }
        }
        return queries.length-trans_count;
    }
}