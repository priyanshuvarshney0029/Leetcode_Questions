class Solution {
    public int totalFruit(int[] fruits) {
        int si=0;
        int ei=0;
        int max_fruits=0;
        HashMap<Integer,Integer> map=new HashMap<>();
        while(ei<fruits.length){
            map.put(fruits[ei],map.getOrDefault(fruits[ei],0)+1);

            while(map.size()>2 && ei>=si){
                map.put(fruits[si],map.get(fruits[si])-1);
               if(map.get(fruits[si])==0){
                    map.remove(fruits[si]);
                }
                si++;
            }
            max_fruits=Math.max(max_fruits,ei-si+1);
            ei++;
        }
        return max_fruits;
    }
}