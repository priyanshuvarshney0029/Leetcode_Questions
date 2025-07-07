class Solution {
    public int maxEvents(int[][] events) {
        Arrays.sort(events,(a,b)->a[0]-b[0]); // sort the events on the starting time taaki hume starting day pta chal jaae....

        PriorityQueue<Integer> pq=new PriorityQueue<>();
        int count=0;
        int day=1;
        int idx=0;
        while(idx<events.length){
            if(pq.isEmpty()){
                day=events[idx][0];
            }
            while(idx<events.length && day>=events[idx][0]){
                 pq.add(events[idx][1]);
                 idx++;
            }
            while(!pq.isEmpty()&& pq.peek()<day){
                pq.poll();
            }
            if(!pq.isEmpty()){
                pq.poll();
                count++;
                day++;
            }
        }
        while(!pq.isEmpty()){
           if(day<=pq.peek()){
                count++;
                day++;
            }
            pq.poll();
        }
        return count;

    }
}